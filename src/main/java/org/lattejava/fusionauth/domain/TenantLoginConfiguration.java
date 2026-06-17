/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantLoginConfigurationJSON;

@JSON
public record TenantLoginConfiguration(
    Boolean requireAuthentication) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantLoginConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantLoginConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantLoginConfiguration fromJSON(String json) {
    return TenantLoginConfigurationJSON.fromJSON(json);
  }
  
  public static TenantLoginConfiguration fromJSONBytes(byte[] json) {
    return TenantLoginConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean requireAuthentication;
    public Builder requireAuthentication(Boolean requireAuthentication) { this.requireAuthentication = requireAuthentication; return this; }
    public TenantLoginConfiguration build() { return new TenantLoginConfiguration(requireAuthentication); }
  }
}
