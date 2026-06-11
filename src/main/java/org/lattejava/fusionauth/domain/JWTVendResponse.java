/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWTVendResponseJSON;

@JSON
public record JWTVendResponse(
    String token) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWTVendResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JWTVendResponseJSON.toJSONBytes(this);
  }

  public static JWTVendResponse fromJSON(String json) {
    return JWTVendResponseJSON.fromJSON(json);
  }

  public static JWTVendResponse fromJSONBytes(byte[] json) {
    return JWTVendResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String token;
    public Builder token(String token) { this.token = token; return this; }
    public JWTVendResponse build() { return new JWTVendResponse(token); }
  }
}
