/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantManagerConfigurationRequestJSON;

@JSON
public record TenantManagerConfigurationRequest(
    TenantManagerConfiguration tenantManagerConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantManagerConfigurationRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantManagerConfigurationRequestJSON.toJSONBytes(this);
  }
  
  public static TenantManagerConfigurationRequest fromJSON(String json) {
    return TenantManagerConfigurationRequestJSON.fromJSON(json);
  }
  
  public static TenantManagerConfigurationRequest fromJSONBytes(byte[] json) {
    return TenantManagerConfigurationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private TenantManagerConfiguration tenantManagerConfiguration;
    public Builder tenantManagerConfiguration(TenantManagerConfiguration tenantManagerConfiguration) { this.tenantManagerConfiguration = tenantManagerConfiguration; return this; }
    public TenantManagerConfigurationRequest build() { return new TenantManagerConfigurationRequest(tenantManagerConfiguration); }
  }
}
