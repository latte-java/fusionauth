/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginConfigurationJSON;

@JSON
public record LoginConfiguration(
    Boolean allowTokenRefresh,
    Boolean generateRefreshTokens,
    Boolean requireAuthentication) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginConfigurationJSON.toJSONBytes(this);
  }
  
  public static LoginConfiguration fromJSON(String json) {
    return LoginConfigurationJSON.fromJSON(json);
  }
  
  public static LoginConfiguration fromJSONBytes(byte[] json) {
    return LoginConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean allowTokenRefresh;
    private Boolean generateRefreshTokens;
    private Boolean requireAuthentication;
    public Builder allowTokenRefresh(Boolean allowTokenRefresh) { this.allowTokenRefresh = allowTokenRefresh; return this; }
    public Builder generateRefreshTokens(Boolean generateRefreshTokens) { this.generateRefreshTokens = generateRefreshTokens; return this; }
    public Builder requireAuthentication(Boolean requireAuthentication) { this.requireAuthentication = requireAuthentication; return this; }
    public LoginConfiguration build() { return new LoginConfiguration(allowTokenRefresh, generateRefreshTokens, requireAuthentication); }
  }
}
