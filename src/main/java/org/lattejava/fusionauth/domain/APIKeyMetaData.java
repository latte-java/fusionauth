/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.APIKeyMetaDataJSON;

@JSON
public record APIKeyMetaData(
    Map<String, String> attributes) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return APIKeyMetaDataJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return APIKeyMetaDataJSON.toJSONBytes(this);
  }
  
  public static APIKeyMetaData fromJSON(String json) {
    return APIKeyMetaDataJSON.fromJSON(json);
  }
  
  public static APIKeyMetaData fromJSONBytes(byte[] json) {
    return APIKeyMetaDataJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, String> attributes;
    public Builder attributes(Map<String, String> attributes) { this.attributes = attributes; return this; }
    public APIKeyMetaData build() { return new APIKeyMetaData(attributes); }
  }
}
