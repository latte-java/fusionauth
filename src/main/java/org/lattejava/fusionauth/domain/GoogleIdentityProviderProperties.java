/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GoogleIdentityProviderPropertiesJSON;

@JSON
public record GoogleIdentityProviderProperties(
    String api,
    String button) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GoogleIdentityProviderPropertiesJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GoogleIdentityProviderPropertiesJSON.toJSONBytes(this);
  }
  
  public static GoogleIdentityProviderProperties fromJSON(String json) {
    return GoogleIdentityProviderPropertiesJSON.fromJSON(json);
  }
  
  public static GoogleIdentityProviderProperties fromJSONBytes(byte[] json) {
    return GoogleIdentityProviderPropertiesJSON.fromJSON(json);
  }

  public static final class Builder {
    private String api;
    private String button;
    public Builder api(String api) { this.api = api; return this; }
    public Builder button(String button) { this.button = button; return this; }
    public GoogleIdentityProviderProperties build() { return new GoogleIdentityProviderProperties(api, button); }
  }
}
