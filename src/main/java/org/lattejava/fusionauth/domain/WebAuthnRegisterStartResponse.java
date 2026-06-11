/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnRegisterStartResponseJSON;

@JSON
public record WebAuthnRegisterStartResponse(
    PublicKeyCredentialCreationOptions options) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnRegisterStartResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebAuthnRegisterStartResponseJSON.toJSONBytes(this);
  }

  public static WebAuthnRegisterStartResponse fromJSON(String json) {
    return WebAuthnRegisterStartResponseJSON.fromJSON(json);
  }

  public static WebAuthnRegisterStartResponse fromJSONBytes(byte[] json) {
    return WebAuthnRegisterStartResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private PublicKeyCredentialCreationOptions options;
    public Builder options(PublicKeyCredentialCreationOptions options) { this.options = options; return this; }
    public WebAuthnRegisterStartResponse build() { return new WebAuthnRegisterStartResponse(options); }
  }
}
