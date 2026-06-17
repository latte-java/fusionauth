/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnStartResponseJSON;

@JSON
public record WebAuthnStartResponse(
    PublicKeyCredentialRequestOptions options) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnStartResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnStartResponseJSON.toJSONBytes(this);
  }
  
  public static WebAuthnStartResponse fromJSON(String json) {
    return WebAuthnStartResponseJSON.fromJSON(json);
  }
  
  public static WebAuthnStartResponse fromJSONBytes(byte[] json) {
    return WebAuthnStartResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private PublicKeyCredentialRequestOptions options;
    public Builder options(PublicKeyCredentialRequestOptions options) { this.options = options; return this; }
    public WebAuthnStartResponse build() { return new WebAuthnStartResponse(options); }
  }
}
