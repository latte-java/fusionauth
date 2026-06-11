/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWTRefreshResponseJSON;

@JSON
public record JWTRefreshResponse(
    String refreshToken,
    UUID refreshTokenId,
    String token) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWTRefreshResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JWTRefreshResponseJSON.toJSONBytes(this);
  }

  public static JWTRefreshResponse fromJSON(String json) {
    return JWTRefreshResponseJSON.fromJSON(json);
  }

  public static JWTRefreshResponse fromJSONBytes(byte[] json) {
    return JWTRefreshResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String refreshToken;
    private UUID refreshTokenId;
    private String token;
    public Builder refreshToken(String refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder refreshTokenId(UUID refreshTokenId) { this.refreshTokenId = refreshTokenId; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public JWTRefreshResponse build() { return new JWTRefreshResponse(refreshToken, refreshTokenId, token); }
  }
}
