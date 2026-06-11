/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderTenantConfigurationJSON;

@JSON
public record IdentityProviderTenantConfiguration(
    Map<String, Object> data,
    IdentityProviderLimitUserLinkingPolicy limitUserLinkCount) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderTenantConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderTenantConfigurationJSON.toJSONBytes(this);
  }

  public static IdentityProviderTenantConfiguration fromJSON(String json) {
    return IdentityProviderTenantConfigurationJSON.fromJSON(json);
  }

  public static IdentityProviderTenantConfiguration fromJSONBytes(byte[] json) {
    return IdentityProviderTenantConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private IdentityProviderLimitUserLinkingPolicy limitUserLinkCount;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder limitUserLinkCount(IdentityProviderLimitUserLinkingPolicy limitUserLinkCount) { this.limitUserLinkCount = limitUserLinkCount; return this; }
    public IdentityProviderTenantConfiguration build() { return new IdentityProviderTenantConfiguration(data, limitUserLinkCount); }
  }
}
