/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnExtensionsClientOutputsJSON;

@JSON
public record WebAuthnExtensionsClientOutputs(
    CredentialPropertiesOutput credProps) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnExtensionsClientOutputsJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnExtensionsClientOutputsJSON.toJSONBytes(this);
  }
  
  public static WebAuthnExtensionsClientOutputs fromJSON(String json) {
    return WebAuthnExtensionsClientOutputsJSON.fromJSON(json);
  }
  
  public static WebAuthnExtensionsClientOutputs fromJSONBytes(byte[] json) {
    return WebAuthnExtensionsClientOutputsJSON.fromJSON(json);
  }

  public static final class Builder {
    private CredentialPropertiesOutput credProps;
    public Builder credProps(CredentialPropertiesOutput credProps) { this.credProps = credProps; return this; }
    public WebAuthnExtensionsClientOutputs build() { return new WebAuthnExtensionsClientOutputs(credProps); }
  }
}
