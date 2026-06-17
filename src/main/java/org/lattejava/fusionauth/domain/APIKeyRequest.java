/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.APIKeyRequestJSON;

@JSON
public record APIKeyRequest(
    APIKey apiKey,
    UUID sourceKeyId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return APIKeyRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return APIKeyRequestJSON.toJSONBytes(this);
  }
  
  public static APIKeyRequest fromJSON(String json) {
    return APIKeyRequestJSON.fromJSON(json);
  }
  
  public static APIKeyRequest fromJSONBytes(byte[] json) {
    return APIKeyRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private APIKey apiKey;
    private UUID sourceKeyId;
    public Builder apiKey(APIKey apiKey) { this.apiKey = apiKey; return this; }
    public Builder sourceKeyId(UUID sourceKeyId) { this.sourceKeyId = sourceKeyId; return this; }
    public APIKeyRequest build() { return new APIKeyRequest(apiKey, sourceKeyId); }
  }
}
