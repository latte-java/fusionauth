/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogConfigurationJSON;

@JSON
public record AuditLogConfiguration(
    DeleteConfiguration delete) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return AuditLogConfigurationJSON.toJSONBytes(this);
  }
  
  public static AuditLogConfiguration fromJSON(String json) {
    return AuditLogConfigurationJSON.fromJSON(json);
  }
  
  public static AuditLogConfiguration fromJSONBytes(byte[] json) {
    return AuditLogConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private DeleteConfiguration delete;
    public Builder delete(DeleteConfiguration delete) { this.delete = delete; return this; }
    public AuditLogConfiguration build() { return new AuditLogConfiguration(delete); }
  }
}
