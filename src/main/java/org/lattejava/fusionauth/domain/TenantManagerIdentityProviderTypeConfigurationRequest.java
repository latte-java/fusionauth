/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantManagerIdentityProviderTypeConfigurationRequestJSON;

@JSON
public record TenantManagerIdentityProviderTypeConfigurationRequest(
    TenantManagerIdentityProviderTypeConfiguration typeConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantManagerIdentityProviderTypeConfigurationRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantManagerIdentityProviderTypeConfigurationRequestJSON.toJSONBytes(this);
  }

  public static TenantManagerIdentityProviderTypeConfigurationRequest fromJSON(String json) {
    return TenantManagerIdentityProviderTypeConfigurationRequestJSON.fromJSON(json);
  }

  public static TenantManagerIdentityProviderTypeConfigurationRequest fromJSONBytes(byte[] json) {
    return TenantManagerIdentityProviderTypeConfigurationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private TenantManagerIdentityProviderTypeConfiguration typeConfiguration;
    public Builder typeConfiguration(TenantManagerIdentityProviderTypeConfiguration typeConfiguration) { this.typeConfiguration = typeConfiguration; return this; }
    public TenantManagerIdentityProviderTypeConfigurationRequest build() { return new TenantManagerIdentityProviderTypeConfigurationRequest(typeConfiguration); }
  }
}
