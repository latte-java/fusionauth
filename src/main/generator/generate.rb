#!/usr/bin/env ruby
# frozen_string_literal: true
#
# Copyright (c) 2026 The Latte Project
# SPDX-License-Identifier: MIT
#
# FusionAuth client generator. Regenerates org.lattejava.fusionauth from
# src/main/openapi.yaml per src/main/generator/README.md.
#
# Usage (from repo root):
#   ruby src/main/generator/generate.rb enums     # write domain enums
#   ruby src/main/generator/generate.rb records   # write domain records + IdentityProviderField
#   ruby src/main/generator/generate.rb client    # inject FusionAuthClient methods between markers
#   ruby src/main/generator/generate.rb all        # all of the above
#
# Deterministic; safe to re-run (overwrites generated files). Hand-written client
# helpers (execute/executeVoid/send/encode/query/queryList/error + constructors) are
# the contract and are never touched — only the GENERATED METHODS block is rewritten.

require 'yaml'
require 'set'

ROOT   = File.expand_path('../../../..', __FILE__)
SPEC   = File.join(ROOT, 'src/main/openapi.yaml')
DOMAIN = File.join(ROOT, 'src/main/java/org/lattejava/fusionauth/domain')
CLIENT = File.join(ROOT, 'src/main/java/org/lattejava/fusionauth/FusionAuthClient.java')

HEADER = <<~H
  /*
   * Copyright (c) 2026 The Latte Project
   * SPDX-License-Identifier: MIT
   */
H

SPEC_DOC = YAML.load_file(SPEC)
SCHEMAS  = SPEC_DOC['components']['schemas']
PATHS    = SPEC_DOC['paths']

# ---- schema classification ---------------------------------------------------
ENUM_NAMES = SCHEMAS.select { |_, v| v.is_a?(Hash) && v['enum'] }.keys.to_set

POLY_NAME = 'IdentityProviderField'
POLY = SCHEMAS[POLY_NAME]
# discriminator wire value -> subtype schema name, and the reverse
IDP_MAPPING = (POLY && POLY['discriminator'] && POLY['discriminator']['mapping']) || {}
SUBTYPE_TO_WIRE = IDP_MAPPING.each_with_object({}) { |(wire, ref), h| h[ref.split('/').last] = wire }
# permitted subtypes in oneOf order
IDP_SUBTYPES = (POLY && POLY['oneOf'] || []).map { |o| o['$ref'].split('/').last }

# Alias schemas: mapped to JDK types, never emitted as files.
# ZonedDateTime -> Instant (+ instant annotation); LocalDate -> java.time.LocalDate;
# Locale -> String; ZoneId -> String.
ALIASES = %w[ZonedDateTime LocalDate Locale ZoneId].to_set

def record_name?(name)
  return false if ENUM_NAMES.include?(name)
  return false if ALIASES.include?(name)
  return false if name == POLY_NAME
  true
end

# ---- type mapping (rulebook, json 0.4.0) -------------------------------------
# Returns [java_type_string, needs_instant_annotation_bool] for a property schema node.
def map_type(node)
  if node.key?('$ref')
    name = node['$ref'].split('/').last
    return ['Instant', true] if name == 'ZonedDateTime'
    return ['LocalDate', false] if name == 'LocalDate'
    return ['String', false] if name == 'Locale' || name == 'ZoneId'
    return [name, false] # enum, record, or IdentityProviderField — all by simple name
  end

  case node['type']
  when 'string'
    fmt = node['format'].to_s.downcase
    [fmt == 'uuid' ? 'UUID' : 'String', false]
  when 'integer'
    [node['format'].to_s.downcase == 'int64' ? 'Long' : 'Integer', false]
  when 'number'
    ['Double', false]
  when 'boolean'
    ['Boolean', false]
  when 'array'
    elem = array_element_type(node['items'])
    coll = node['uniqueItems'] ? 'Set' : 'List'
    ["#{coll}<#{elem}>", false]
  when 'object'
    [object_type(node), false]
  else
    # bare {} or unknown -> free-form
    ['Map<String, Object>', false]
  end
end

# Element type for an array's `items` node. Untyped items ({}) -> String.
def array_element_type(items)
  return 'String' if items.nil? || items.empty?
  if items.key?('$ref')
    name = items['$ref'].split('/').last
    return 'Instant' if name == 'ZonedDateTime'
    return 'LocalDate' if name == 'LocalDate'
    return 'String' if name == 'Locale' || name == 'ZoneId'
    return name
  end
  case items['type']
  when 'string'  then items['format'].to_s.downcase == 'uuid' ? 'UUID' : 'String'
  when 'integer' then items['format'].to_s.downcase == 'int64' ? 'Long' : 'Integer'
  when 'number'  then 'Double'
  when 'boolean' then 'Boolean'
  else 'String'
  end
end

# Map type for an `object` node (free-form or additionalProperties variants).
def object_type(node)
  ap = node['additionalProperties']
  return 'Map<String, Object>' if ap.nil? || ap == true || (ap.is_a?(Hash) && ap.empty?)
  if ap.key?('$ref')
    return "Map<String, #{ap['$ref'].split('/').last}>"
  end
  case ap['type']
  when 'string' then 'Map<String, String>'
  when 'array'
    items = ap['items']
    if items.nil? || items.empty?
      'Map<String, Object>'            # free-form array values
    else
      coll = ap['uniqueItems'] ? 'Set' : 'List'
      "Map<String, #{coll}<#{array_element_type(items)}>>"  # json 0.4.0: nested collection map value
    end
  else
    'Map<String, Object>'              # additionalProperties {type: object} or other
  end
end

# ---- emit: enums -------------------------------------------------------------
def emit_enum(name)
  consts = SCHEMAS[name]['enum']
  body = +HEADER
  body << "package org.lattejava.fusionauth.domain;\n\n"
  body << "public enum #{name} {\n"
  body << consts.map { |c| "  #{c}" }.join(",\n")
  body << "\n}\n"
  File.write(File.join(DOMAIN, "#{name}.java"), body)
end

# ---- emit: records (incl. polymorphic subtypes) ------------------------------
def emit_record(name)
  schema = SCHEMAS[name]
  props  = schema['properties'] || {}
  subtype = SUBTYPE_TO_WIRE[name]
  props = props.reject { |k, _| k == 'type' } if subtype # discriminator written by machinery

  comps = props.map do |key, node|
    type, instant = map_type(node)
    field = key.gsub(/[^A-Za-z0-9_]/, '') # JSON key -> valid Java identifier
    { field: field, key: key, type: type, instant: instant }
  end

  b = +HEADER
  b << "package org.lattejava.fusionauth.domain;\n\n"
  b << "import module java.base;\n"
  b << "import module org.lattejava.json;\n\n"
  b << "import org.lattejava.fusionauth.domain.internal.#{name}JSON;\n\n"
  b << "@JSON\n"
  b << "@JSONSubtype(\"#{subtype}\")\n" if subtype
  impl = subtype ? " implements IdentityProviderField" : ""

  if comps.empty?
    b << "public record #{name}()#{impl} {\n"
  else
    b << "public record #{name}(\n"
    lines = comps.map do |c|
      "    #{field_annotation(c)}#{c[:type]} #{c[:field]}"
    end
    b << lines.join(",\n")
    b << ")#{impl} {\n"
  end

  b << "  public static Builder builder() { return new Builder(); }\n\n"
  b << json_methods(name)
  b << "\n"
  b << builder_class(name, comps)
  b << "}\n"
  File.write(File.join(DOMAIN, "#{name}.java"), b)
end

def field_annotation(c)
  parts = []
  parts << "name = \"#{c[:key]}\"" if c[:field] != c[:key]
  parts << 'instant = InstantFormat.EPOCH_MILLIS' if c[:instant]
  parts.empty? ? '' : "@JSONField(#{parts.join(', ')}) "
end

def json_methods(name)
  <<~M.gsub(/^/, '  ')
    public String toJSON() {
      return #{name}JSON.toJSON(this);
    }

    public byte[] toJSONBytes() {
      return #{name}JSON.toJSONBytes(this);
    }

    public static #{name} fromJSON(String json) {
      return #{name}JSON.fromJSON(json);
    }

    public static #{name} fromJSONBytes(byte[] json) {
      return #{name}JSON.fromJSON(json);
    }
  M
end

def builder_class(name, comps)
  b = +"  public static final class Builder {\n"
  comps.each { |c| b << "    private #{c[:type]} #{c[:field]};\n" }
  comps.each do |c|
    b << "    public Builder #{c[:field]}(#{c[:type]} #{c[:field]}) { this.#{c[:field]} = #{c[:field]}; return this; }\n"
  end
  args = comps.map { |c| c[:field] }.join(', ')
  b << "    public #{name} build() { return new #{name}(#{args}); }\n"
  b << "  }\n"
  b
end

# ---- emit: the sealed polymorphic interface ----------------------------------
def emit_identity_provider_field
  b = +HEADER
  b << "package org.lattejava.fusionauth.domain;\n\n"
  b << "import module org.lattejava.json;\n\n"
  b << "import org.lattejava.fusionauth.domain.internal.#{POLY_NAME}JSON;\n\n"
  b << "@JSON\n@JSONTypeInfo(property = \"type\")\n"
  b << "public sealed interface #{POLY_NAME}\n"
  b << "    permits " + IDP_SUBTYPES.join(",\n            ") + " {\n\n"
  b << <<~M.gsub(/^/, '  ')
    default String toJSON() {
      return #{POLY_NAME}JSON.toJSON(this);
    }

    default byte[] toJSONBytes() {
      return #{POLY_NAME}JSON.toJSONBytes(this);
    }

    static #{POLY_NAME} fromJSON(String json) {
      return #{POLY_NAME}JSON.fromJSON(json);
    }

    static #{POLY_NAME} fromJSONBytes(byte[] json) {
      return #{POLY_NAME}JSON.fromJSON(json);
    }
  M
  b << "}\n"
  File.write(File.join(DOMAIN, "#{POLY_NAME}.java"), b)
end

# ---- emit: client methods ----------------------------------------------------
# Param order: path -> query -> body -> xFusionAuthTenantId (UUID, last) + no-tenant overload.
def collect_operations
  ops = []
  PATHS.each do |path, item|
    item.each do |method, op|
      next unless %w[get post put patch delete].include?(method)
      next unless op.is_a?(Hash) && op['operationId']
      params = op['parameters'] || []
      path_p = params.select { |p| p['in'] == 'path' }.map { |p| p['name'] }
      query_p = params.select { |p| p['in'] == 'query' }.map do |p|
        { name: p['name'], jtype: query_java_type(p['schema'] || {}) }
      end
      tenant = params.any? { |p| p['in'] == 'header' && p['name'] == 'X-FusionAuth-TenantId' }
      body = op['requestBody'] && op['requestBody']['content']
      req_type = nil
      if body
        json = body['application/json']
        req_type = json && json['schema'] && json['schema']['$ref'] && json['schema']['$ref'].split('/').last
      end
      resp = op.dig('responses', '200', 'content', 'application/json', 'schema', '$ref')
      resp_type = resp && resp.split('/').last
      ops << { id: op['operationId'], method: method.upcase, path: path,
               path_p: path_p, query_p: query_p, tenant: tenant, req: req_type, resp: resp_type }
    end
  end
  ops
end

# Java type for a query parameter. Numbers and arrays are typed precisely; booleans, strings,
# and uuid-format ids stay String to match the client's convention (FusionAuth accepts string
# booleans, and only xFusionAuthTenantId is a UUID).
def query_java_type(sch)
  case sch['type']
  when 'array'   then 'List<String>'
  when 'integer' then sch['format'].to_s.downcase == 'int64' ? 'Long' : 'Integer'
  when 'number'  then 'Double'
  else 'String'
  end
end

def path_expr(path)
  out = +'"'
  rest = path.dup
  while (m = rest.match(/\{([a-zA-Z0-9_]+)\}/))
    out << m.pre_match << '" + encode(' << m[1] << ') + "'
    rest = m.post_match
  end
  out << rest << '"'
  out.sub!(/ \+ ""\z/, '')
  out.sub!(/\A"" \+ /, '')
  out
end

def gen_method(op, with_tenant)
  params = []
  params.concat(op[:path_p].map { |n| "String #{n}" })
  op[:query_p].each { |q| params << "#{q[:jtype]} #{q[:name]}" }
  params << "#{op[:req]} request" if op[:req]
  params << 'UUID xFusionAuthTenantId' if op[:tenant] && with_tenant
  ret = op[:resp] || 'int'

  if with_tenant || !op[:tenant]
    # canonical body
    pe = path_expr(op[:path])
    # All query params (scalar or List<String>) fold into ONE query(...) call; the helper
    # manages the leading ?/& and expands collection values into repeated params.
    qpairs = op[:query_p].map { |q| "\"#{q[:name]}\", #{q[:name]}" }.join(', ')
    qexpr = op[:query_p].empty? ? '' : " + query(#{qpairs})"
    body_arg = op[:req] ? 'request.toJSON()' : 'null'
    tenant_arg = op[:tenant] ? 'xFusionAuthTenantId' : 'null'
    call = if op[:resp]
             "execute(\"#{op[:method]}\", #{pe}#{qexpr}, #{body_arg}, #{tenant_arg}, #{op[:resp]}::fromJSON)"
           else
             "executeVoid(\"#{op[:method]}\", #{pe}#{qexpr}, #{body_arg}, #{tenant_arg})"
           end
    +"  public #{ret} #{op[:id]}(#{params.join(', ')}) {\n    return #{call};\n  }\n"
  else
    # no-tenant overload delegating with null
    args = []
    args.concat(op[:path_p])
    args.concat(op[:query_p].map { |q| q[:name] })
    args << 'request' if op[:req]
    args << 'null'
    +"  public #{ret} #{op[:id]}(#{params.join(', ')}) {\n    return #{op[:id]}(#{args.join(', ')});\n  }\n"
  end
end

def emit_client
  ops = collect_operations
  blocks = ops.map do |op|
    out = gen_method(op, true)
    out << "\n" << gen_method(op, false) if op[:tenant]
    out
  end
  generated = blocks.join("\n")

  src = File.read(CLIENT)
  start_m = '// ===== GENERATED METHODS START ====='
  end_m   = '// ===== GENERATED METHODS END ====='
  src = src.sub(/(#{Regexp.escape(start_m)}\n).*?(\n[ ]*#{Regexp.escape(end_m)})/m) do
    "#{$1}#{generated}#{$2}"
  end
  File.write(CLIENT, src)
  ops.size
end

# ---- driver ------------------------------------------------------------------
cmd = ARGV[0] || 'all'
case cmd
when 'enums'
  ENUM_NAMES.each { |n| emit_enum(n) }
  puts "enums: #{ENUM_NAMES.size}"
when 'records'
  recs = SCHEMAS.keys.select { |n| record_name?(n) }
  recs.each { |n| emit_record(n) }
  emit_identity_provider_field
  puts "records: #{recs.size} (+ #{POLY_NAME})"
when 'client'
  puts "client methods for #{emit_client} operations"
when 'all'
  ENUM_NAMES.each { |n| emit_enum(n) }
  recs = SCHEMAS.keys.select { |n| record_name?(n) }
  recs.each { |n| emit_record(n) }
  emit_identity_provider_field
  n = emit_client
  puts "enums: #{ENUM_NAMES.size}, records: #{recs.size} (+#{POLY_NAME}), client ops: #{n}"
else
  abort "unknown command: #{cmd} (enums|records|client|all)"
end
