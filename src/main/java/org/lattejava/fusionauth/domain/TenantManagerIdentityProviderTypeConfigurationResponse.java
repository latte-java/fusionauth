/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantManagerIdentityProviderTypeConfigurationResponseJSON;

@JSON
public record TenantManagerIdentityProviderTypeConfigurationResponse(
    TenantManagerIdentityProviderTypeConfiguration typeConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantManagerIdentityProviderTypeConfigurationResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantManagerIdentityProviderTypeConfigurationResponseJSON.toJSONBytes(this);
  }

  public static TenantManagerIdentityProviderTypeConfigurationResponse fromJSON(String json) {
    return TenantManagerIdentityProviderTypeConfigurationResponseJSON.fromJSON(json);
  }

  public static TenantManagerIdentityProviderTypeConfigurationResponse fromJSONBytes(byte[] json) {
    return TenantManagerIdentityProviderTypeConfigurationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private TenantManagerIdentityProviderTypeConfiguration typeConfiguration;
    public Builder typeConfiguration(TenantManagerIdentityProviderTypeConfiguration typeConfiguration) { this.typeConfiguration = typeConfiguration; return this; }
    public TenantManagerIdentityProviderTypeConfigurationResponse build() { return new TenantManagerIdentityProviderTypeConfigurationResponse(typeConfiguration); }
  }
}
