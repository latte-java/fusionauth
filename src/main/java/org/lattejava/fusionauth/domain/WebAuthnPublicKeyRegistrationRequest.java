/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnPublicKeyRegistrationRequestJSON;

@JSON
public record WebAuthnPublicKeyRegistrationRequest(
    WebAuthnExtensionsClientOutputs clientExtensionResults,
    String id,
    String rpId,
    WebAuthnAuthenticatorRegistrationResponse response,
    List<String> transports,
    String type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnPublicKeyRegistrationRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebAuthnPublicKeyRegistrationRequestJSON.toJSONBytes(this);
  }

  public static WebAuthnPublicKeyRegistrationRequest fromJSON(String json) {
    return WebAuthnPublicKeyRegistrationRequestJSON.fromJSON(json);
  }

  public static WebAuthnPublicKeyRegistrationRequest fromJSONBytes(byte[] json) {
    return WebAuthnPublicKeyRegistrationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebAuthnExtensionsClientOutputs clientExtensionResults;
    private String id;
    private String rpId;
    private WebAuthnAuthenticatorRegistrationResponse response;
    private List<String> transports;
    private String type;
    public Builder clientExtensionResults(WebAuthnExtensionsClientOutputs clientExtensionResults) { this.clientExtensionResults = clientExtensionResults; return this; }
    public Builder id(String id) { this.id = id; return this; }
    public Builder rpId(String rpId) { this.rpId = rpId; return this; }
    public Builder response(WebAuthnAuthenticatorRegistrationResponse response) { this.response = response; return this; }
    public Builder transports(List<String> transports) { this.transports = transports; return this; }
    public Builder type(String type) { this.type = type; return this; }
    public WebAuthnPublicKeyRegistrationRequest build() { return new WebAuthnPublicKeyRegistrationRequest(clientExtensionResults, id, rpId, response, transports, type); }
  }
}
