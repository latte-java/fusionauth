/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantRegistrationConfigurationJSON;

@JSON
public record TenantRegistrationConfiguration(
    Set<String> blockedDomains) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantRegistrationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantRegistrationConfigurationJSON.toJSONBytes(this);
  }

  public static TenantRegistrationConfiguration fromJSON(String json) {
    return TenantRegistrationConfigurationJSON.fromJSON(json);
  }

  public static TenantRegistrationConfiguration fromJSONBytes(byte[] json) {
    return TenantRegistrationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Set<String> blockedDomains;
    public Builder blockedDomains(Set<String> blockedDomains) { this.blockedDomains = blockedDomains; return this; }
    public TenantRegistrationConfiguration build() { return new TenantRegistrationConfiguration(blockedDomains); }
  }
}
