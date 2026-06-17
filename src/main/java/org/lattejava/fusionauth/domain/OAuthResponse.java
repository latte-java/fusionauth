/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OAuthResponseJSON;

@JSON
public record OAuthResponse() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return OAuthResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return OAuthResponseJSON.toJSONBytes(this);
  }
  
  public static OAuthResponse fromJSON(String json) {
    return OAuthResponseJSON.fromJSON(json);
  }
  
  public static OAuthResponse fromJSONBytes(byte[] json) {
    return OAuthResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    public OAuthResponse build() { return new OAuthResponse(); }
  }
}
