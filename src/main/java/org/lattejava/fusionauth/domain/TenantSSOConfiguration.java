/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantSSOConfigurationJSON;

@JSON
public record TenantSSOConfiguration(
    Boolean allowAccessTokenBootstrap,
    Integer deviceTrustTimeToLiveInSeconds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantSSOConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantSSOConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantSSOConfiguration fromJSON(String json) {
    return TenantSSOConfigurationJSON.fromJSON(json);
  }
  
  public static TenantSSOConfiguration fromJSONBytes(byte[] json) {
    return TenantSSOConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean allowAccessTokenBootstrap;
    private Integer deviceTrustTimeToLiveInSeconds;
    public Builder allowAccessTokenBootstrap(Boolean allowAccessTokenBootstrap) { this.allowAccessTokenBootstrap = allowAccessTokenBootstrap; return this; }
    public Builder deviceTrustTimeToLiveInSeconds(Integer deviceTrustTimeToLiveInSeconds) { this.deviceTrustTimeToLiveInSeconds = deviceTrustTimeToLiveInSeconds; return this; }
    public TenantSSOConfiguration build() { return new TenantSSOConfiguration(allowAccessTokenBootstrap, deviceTrustTimeToLiveInSeconds); }
  }
}
