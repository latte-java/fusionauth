/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshTokenResponseJSON;

@JSON
public record RefreshTokenResponse(
    RefreshToken refreshToken,
    List<RefreshToken> refreshTokens) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshTokenResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RefreshTokenResponseJSON.toJSONBytes(this);
  }
  
  public static RefreshTokenResponse fromJSON(String json) {
    return RefreshTokenResponseJSON.fromJSON(json);
  }
  
  public static RefreshTokenResponse fromJSONBytes(byte[] json) {
    return RefreshTokenResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private RefreshToken refreshToken;
    private List<RefreshToken> refreshTokens;
    public Builder refreshToken(RefreshToken refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder refreshTokens(List<RefreshToken> refreshTokens) { this.refreshTokens = refreshTokens; return this; }
    public RefreshTokenResponse build() { return new RefreshTokenResponse(refreshToken, refreshTokens); }
  }
}
