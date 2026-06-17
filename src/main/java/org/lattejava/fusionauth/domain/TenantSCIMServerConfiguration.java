/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantSCIMServerConfigurationJSON;

@JSON
public record TenantSCIMServerConfiguration(
    UUID clientEntityTypeId,
    Map<String, Object> schemas,
    UUID serverEntityTypeId,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantSCIMServerConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantSCIMServerConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantSCIMServerConfiguration fromJSON(String json) {
    return TenantSCIMServerConfigurationJSON.fromJSON(json);
  }
  
  public static TenantSCIMServerConfiguration fromJSONBytes(byte[] json) {
    return TenantSCIMServerConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID clientEntityTypeId;
    private Map<String, Object> schemas;
    private UUID serverEntityTypeId;
    private Boolean enabled;
    public Builder clientEntityTypeId(UUID clientEntityTypeId) { this.clientEntityTypeId = clientEntityTypeId; return this; }
    public Builder schemas(Map<String, Object> schemas) { this.schemas = schemas; return this; }
    public Builder serverEntityTypeId(UUID serverEntityTypeId) { this.serverEntityTypeId = serverEntityTypeId; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public TenantSCIMServerConfiguration build() { return new TenantSCIMServerConfiguration(clientEntityTypeId, schemas, serverEntityTypeId, enabled); }
  }
}
