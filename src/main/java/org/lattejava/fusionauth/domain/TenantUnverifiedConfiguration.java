/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantUnverifiedConfigurationJSON;

@JSON
public record TenantUnverifiedConfiguration(
    UnverifiedBehavior email,
    RegistrationUnverifiedOptions whenGated) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantUnverifiedConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantUnverifiedConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantUnverifiedConfiguration fromJSON(String json) {
    return TenantUnverifiedConfigurationJSON.fromJSON(json);
  }
  
  public static TenantUnverifiedConfiguration fromJSONBytes(byte[] json) {
    return TenantUnverifiedConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UnverifiedBehavior email;
    private RegistrationUnverifiedOptions whenGated;
    public Builder email(UnverifiedBehavior email) { this.email = email; return this; }
    public Builder whenGated(RegistrationUnverifiedOptions whenGated) { this.whenGated = whenGated; return this; }
    public TenantUnverifiedConfiguration build() { return new TenantUnverifiedConfiguration(email, whenGated); }
  }
}
