/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWKSResponseJSON;

@JSON
public record JWKSResponse(
    List<JSONWebKey> keys) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWKSResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JWKSResponseJSON.toJSONBytes(this);
  }

  public static JWKSResponse fromJSON(String json) {
    return JWKSResponseJSON.fromJSON(json);
  }

  public static JWKSResponse fromJSONBytes(byte[] json) {
    return JWKSResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<JSONWebKey> keys;
    public Builder keys(List<JSONWebKey> keys) { this.keys = keys; return this; }
    public JWKSResponse build() { return new JWKSResponse(keys); }
  }
}
