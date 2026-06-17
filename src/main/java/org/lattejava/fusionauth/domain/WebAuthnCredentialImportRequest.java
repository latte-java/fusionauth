/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnCredentialImportRequestJSON;

@JSON
public record WebAuthnCredentialImportRequest(
    List<WebAuthnCredential> credentials,
    Boolean validateDbConstraints) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnCredentialImportRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnCredentialImportRequestJSON.toJSONBytes(this);
  }
  
  public static WebAuthnCredentialImportRequest fromJSON(String json) {
    return WebAuthnCredentialImportRequestJSON.fromJSON(json);
  }
  
  public static WebAuthnCredentialImportRequest fromJSONBytes(byte[] json) {
    return WebAuthnCredentialImportRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<WebAuthnCredential> credentials;
    private Boolean validateDbConstraints;
    public Builder credentials(List<WebAuthnCredential> credentials) { this.credentials = credentials; return this; }
    public Builder validateDbConstraints(Boolean validateDbConstraints) { this.validateDbConstraints = validateDbConstraints; return this; }
    public WebAuthnCredentialImportRequest build() { return new WebAuthnCredentialImportRequest(credentials, validateDbConstraints); }
  }
}
