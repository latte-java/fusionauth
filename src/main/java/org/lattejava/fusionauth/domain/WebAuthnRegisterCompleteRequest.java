/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnRegisterCompleteRequestJSON;

@JSON
public record WebAuthnRegisterCompleteRequest(
    WebAuthnPublicKeyRegistrationRequest credential,
    String origin,
    String rpId,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnRegisterCompleteRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebAuthnRegisterCompleteRequestJSON.toJSONBytes(this);
  }

  public static WebAuthnRegisterCompleteRequest fromJSON(String json) {
    return WebAuthnRegisterCompleteRequestJSON.fromJSON(json);
  }

  public static WebAuthnRegisterCompleteRequest fromJSONBytes(byte[] json) {
    return WebAuthnRegisterCompleteRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebAuthnPublicKeyRegistrationRequest credential;
    private String origin;
    private String rpId;
    private UUID userId;
    public Builder credential(WebAuthnPublicKeyRegistrationRequest credential) { this.credential = credential; return this; }
    public Builder origin(String origin) { this.origin = origin; return this; }
    public Builder rpId(String rpId) { this.rpId = rpId; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public WebAuthnRegisterCompleteRequest build() { return new WebAuthnRegisterCompleteRequest(credential, origin, rpId, userId); }
  }
}
