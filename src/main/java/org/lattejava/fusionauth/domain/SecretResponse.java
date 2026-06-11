/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SecretResponseJSON;

@JSON
public record SecretResponse(
    String secret,
    String secretBase32Encoded) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SecretResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SecretResponseJSON.toJSONBytes(this);
  }

  public static SecretResponse fromJSON(String json) {
    return SecretResponseJSON.fromJSON(json);
  }

  public static SecretResponse fromJSONBytes(byte[] json) {
    return SecretResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String secret;
    private String secretBase32Encoded;
    public Builder secret(String secret) { this.secret = secret; return this; }
    public Builder secretBase32Encoded(String secretBase32Encoded) { this.secretBase32Encoded = secretBase32Encoded; return this; }
    public SecretResponse build() { return new SecretResponse(secret, secretBase32Encoded); }
  }
}
