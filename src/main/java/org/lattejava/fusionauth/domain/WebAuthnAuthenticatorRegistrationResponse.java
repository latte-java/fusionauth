/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnAuthenticatorRegistrationResponseJSON;

@JSON
public record WebAuthnAuthenticatorRegistrationResponse(
    String attestationObject,
    String clientDataJSON) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnAuthenticatorRegistrationResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnAuthenticatorRegistrationResponseJSON.toJSONBytes(this);
  }
  
  public static WebAuthnAuthenticatorRegistrationResponse fromJSON(String json) {
    return WebAuthnAuthenticatorRegistrationResponseJSON.fromJSON(json);
  }
  
  public static WebAuthnAuthenticatorRegistrationResponse fromJSONBytes(byte[] json) {
    return WebAuthnAuthenticatorRegistrationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String attestationObject;
    private String clientDataJSON;
    public Builder attestationObject(String attestationObject) { this.attestationObject = attestationObject; return this; }
    public Builder clientDataJSON(String clientDataJSON) { this.clientDataJSON = clientDataJSON; return this; }
    public WebAuthnAuthenticatorRegistrationResponse build() { return new WebAuthnAuthenticatorRegistrationResponse(attestationObject, clientDataJSON); }
  }
}
