/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnAssertResponseJSON;

@JSON
public record WebAuthnAssertResponse(
    WebAuthnCredential credential) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnAssertResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnAssertResponseJSON.toJSONBytes(this);
  }
  
  public static WebAuthnAssertResponse fromJSON(String json) {
    return WebAuthnAssertResponseJSON.fromJSON(json);
  }
  
  public static WebAuthnAssertResponse fromJSONBytes(byte[] json) {
    return WebAuthnAssertResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebAuthnCredential credential;
    public Builder credential(WebAuthnCredential credential) { this.credential = credential; return this; }
    public WebAuthnAssertResponse build() { return new WebAuthnAssertResponse(credential); }
  }
}
