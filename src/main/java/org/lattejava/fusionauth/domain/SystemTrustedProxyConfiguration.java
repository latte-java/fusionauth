/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SystemTrustedProxyConfigurationJSON;

@JSON
public record SystemTrustedProxyConfiguration(
    SystemTrustedProxyConfigurationPolicy trustPolicy,
    List<String> trusted) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SystemTrustedProxyConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SystemTrustedProxyConfigurationJSON.toJSONBytes(this);
  }
  
  public static SystemTrustedProxyConfiguration fromJSON(String json) {
    return SystemTrustedProxyConfigurationJSON.fromJSON(json);
  }
  
  public static SystemTrustedProxyConfiguration fromJSONBytes(byte[] json) {
    return SystemTrustedProxyConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private SystemTrustedProxyConfigurationPolicy trustPolicy;
    private List<String> trusted;
    public Builder trustPolicy(SystemTrustedProxyConfigurationPolicy trustPolicy) { this.trustPolicy = trustPolicy; return this; }
    public Builder trusted(List<String> trusted) { this.trusted = trusted; return this; }
    public SystemTrustedProxyConfiguration build() { return new SystemTrustedProxyConfiguration(trustPolicy, trusted); }
  }
}
