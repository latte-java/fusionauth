/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.APIKeyResponseJSON;

@JSON
public record APIKeyResponse(
    APIKey apiKey) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return APIKeyResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return APIKeyResponseJSON.toJSONBytes(this);
  }
  
  public static APIKeyResponse fromJSON(String json) {
    return APIKeyResponseJSON.fromJSON(json);
  }
  
  public static APIKeyResponse fromJSONBytes(byte[] json) {
    return APIKeyResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private APIKey apiKey;
    public Builder apiKey(APIKey apiKey) { this.apiKey = apiKey; return this; }
    public APIKeyResponse build() { return new APIKeyResponse(apiKey); }
  }
}
