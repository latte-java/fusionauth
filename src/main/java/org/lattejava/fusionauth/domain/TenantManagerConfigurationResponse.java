/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantManagerConfigurationResponseJSON;

@JSON
public record TenantManagerConfigurationResponse(
    TenantManagerConfiguration tenantManagerConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantManagerConfigurationResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantManagerConfigurationResponseJSON.toJSONBytes(this);
  }
  
  public static TenantManagerConfigurationResponse fromJSON(String json) {
    return TenantManagerConfigurationResponseJSON.fromJSON(json);
  }
  
  public static TenantManagerConfigurationResponse fromJSONBytes(byte[] json) {
    return TenantManagerConfigurationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private TenantManagerConfiguration tenantManagerConfiguration;
    public Builder tenantManagerConfiguration(TenantManagerConfiguration tenantManagerConfiguration) { this.tenantManagerConfiguration = tenantManagerConfiguration; return this; }
    public TenantManagerConfigurationResponse build() { return new TenantManagerConfigurationResponse(tenantManagerConfiguration); }
  }
}
