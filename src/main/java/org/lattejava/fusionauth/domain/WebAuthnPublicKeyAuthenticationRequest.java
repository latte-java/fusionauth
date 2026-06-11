/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnPublicKeyAuthenticationRequestJSON;

@JSON
public record WebAuthnPublicKeyAuthenticationRequest(
    WebAuthnExtensionsClientOutputs clientExtensionResults,
    String id,
    String rpId,
    WebAuthnAuthenticatorAuthenticationResponse response,
    String type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnPublicKeyAuthenticationRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebAuthnPublicKeyAuthenticationRequestJSON.toJSONBytes(this);
  }

  public static WebAuthnPublicKeyAuthenticationRequest fromJSON(String json) {
    return WebAuthnPublicKeyAuthenticationRequestJSON.fromJSON(json);
  }

  public static WebAuthnPublicKeyAuthenticationRequest fromJSONBytes(byte[] json) {
    return WebAuthnPublicKeyAuthenticationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebAuthnExtensionsClientOutputs clientExtensionResults;
    private String id;
    private String rpId;
    private WebAuthnAuthenticatorAuthenticationResponse response;
    private String type;
    public Builder clientExtensionResults(WebAuthnExtensionsClientOutputs clientExtensionResults) { this.clientExtensionResults = clientExtensionResults; return this; }
    public Builder id(String id) { this.id = id; return this; }
    public Builder rpId(String rpId) { this.rpId = rpId; return this; }
    public Builder response(WebAuthnAuthenticatorAuthenticationResponse response) { this.response = response; return this; }
    public Builder type(String type) { this.type = type; return this; }
    public WebAuthnPublicKeyAuthenticationRequest build() { return new WebAuthnPublicKeyAuthenticationRequest(clientExtensionResults, id, rpId, response, type); }
  }
}
