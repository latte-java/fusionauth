/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PublicKeyResponseJSON;

@JSON
public record PublicKeyResponse(
    String publicKey,
    Map<String, String> publicKeys) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PublicKeyResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PublicKeyResponseJSON.toJSONBytes(this);
  }
  
  public static PublicKeyResponse fromJSON(String json) {
    return PublicKeyResponseJSON.fromJSON(json);
  }
  
  public static PublicKeyResponse fromJSONBytes(byte[] json) {
    return PublicKeyResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String publicKey;
    private Map<String, String> publicKeys;
    public Builder publicKey(String publicKey) { this.publicKey = publicKey; return this; }
    public Builder publicKeys(Map<String, String> publicKeys) { this.publicKeys = publicKeys; return this; }
    public PublicKeyResponse build() { return new PublicKeyResponse(publicKey, publicKeys); }
  }
}
