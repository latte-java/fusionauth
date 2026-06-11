/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.APIKeyPermissionsJSON;

@JSON
public record APIKeyPermissions(Map<String, Object> endpoints) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Map<String, Object> endpoints;

    public Builder endpoints(Map<String, Object> endpoints) {
      this.endpoints = endpoints;
      return this;
    }

    public APIKeyPermissions build() {
      return new APIKeyPermissions(endpoints);
    }
  }

  public String toJSON() {
    return APIKeyPermissionsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return APIKeyPermissionsJSON.toJSONBytes(this);
  }

  public static APIKeyPermissions fromJSON(String json) {
    return APIKeyPermissionsJSON.fromJSON(json);
  }

  public static APIKeyPermissions fromJSONBytes(byte[] json) {
    return APIKeyPermissionsJSON.fromJSON(json);
  }
}
