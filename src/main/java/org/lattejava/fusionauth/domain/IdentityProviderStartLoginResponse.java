/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderStartLoginResponseJSON;

@JSON
public record IdentityProviderStartLoginResponse(
    String code) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderStartLoginResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderStartLoginResponseJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderStartLoginResponse fromJSON(String json) {
    return IdentityProviderStartLoginResponseJSON.fromJSON(json);
  }
  
  public static IdentityProviderStartLoginResponse fromJSONBytes(byte[] json) {
    return IdentityProviderStartLoginResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    public Builder code(String code) { this.code = code; return this; }
    public IdentityProviderStartLoginResponse build() { return new IdentityProviderStartLoginResponse(code); }
  }
}
