/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnCredentialResponseJSON;

@JSON
public record WebAuthnCredentialResponse(
    WebAuthnCredential credential,
    List<WebAuthnCredential> credentials) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnCredentialResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnCredentialResponseJSON.toJSONBytes(this);
  }
  
  public static WebAuthnCredentialResponse fromJSON(String json) {
    return WebAuthnCredentialResponseJSON.fromJSON(json);
  }
  
  public static WebAuthnCredentialResponse fromJSONBytes(byte[] json) {
    return WebAuthnCredentialResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebAuthnCredential credential;
    private List<WebAuthnCredential> credentials;
    public Builder credential(WebAuthnCredential credential) { this.credential = credential; return this; }
    public Builder credentials(List<WebAuthnCredential> credentials) { this.credentials = credentials; return this; }
    public WebAuthnCredentialResponse build() { return new WebAuthnCredentialResponse(credential, credentials); }
  }
}
