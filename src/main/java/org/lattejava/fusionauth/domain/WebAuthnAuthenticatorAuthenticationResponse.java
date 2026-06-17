/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnAuthenticatorAuthenticationResponseJSON;

@JSON
public record WebAuthnAuthenticatorAuthenticationResponse(
    String authenticatorData,
    String clientDataJSON,
    String signature,
    String userHandle) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnAuthenticatorAuthenticationResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnAuthenticatorAuthenticationResponseJSON.toJSONBytes(this);
  }
  
  public static WebAuthnAuthenticatorAuthenticationResponse fromJSON(String json) {
    return WebAuthnAuthenticatorAuthenticationResponseJSON.fromJSON(json);
  }
  
  public static WebAuthnAuthenticatorAuthenticationResponse fromJSONBytes(byte[] json) {
    return WebAuthnAuthenticatorAuthenticationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String authenticatorData;
    private String clientDataJSON;
    private String signature;
    private String userHandle;
    public Builder authenticatorData(String authenticatorData) { this.authenticatorData = authenticatorData; return this; }
    public Builder clientDataJSON(String clientDataJSON) { this.clientDataJSON = clientDataJSON; return this; }
    public Builder signature(String signature) { this.signature = signature; return this; }
    public Builder userHandle(String userHandle) { this.userHandle = userHandle; return this; }
    public WebAuthnAuthenticatorAuthenticationResponse build() { return new WebAuthnAuthenticatorAuthenticationResponse(authenticatorData, clientDataJSON, signature, userHandle); }
  }
}
