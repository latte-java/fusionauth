/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnRegisterCompleteResponseJSON;

@JSON
public record WebAuthnRegisterCompleteResponse(
    WebAuthnCredential credential) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnRegisterCompleteResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebAuthnRegisterCompleteResponseJSON.toJSONBytes(this);
  }

  public static WebAuthnRegisterCompleteResponse fromJSON(String json) {
    return WebAuthnRegisterCompleteResponseJSON.fromJSON(json);
  }

  public static WebAuthnRegisterCompleteResponse fromJSONBytes(byte[] json) {
    return WebAuthnRegisterCompleteResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebAuthnCredential credential;
    public Builder credential(WebAuthnCredential credential) { this.credential = credential; return this; }
    public WebAuthnRegisterCompleteResponse build() { return new WebAuthnRegisterCompleteResponse(credential); }
  }
}
