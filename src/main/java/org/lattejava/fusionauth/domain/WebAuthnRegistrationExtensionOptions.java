/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnRegistrationExtensionOptionsJSON;

@JSON
public record WebAuthnRegistrationExtensionOptions(
    Boolean credProps) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnRegistrationExtensionOptionsJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnRegistrationExtensionOptionsJSON.toJSONBytes(this);
  }
  
  public static WebAuthnRegistrationExtensionOptions fromJSON(String json) {
    return WebAuthnRegistrationExtensionOptionsJSON.fromJSON(json);
  }
  
  public static WebAuthnRegistrationExtensionOptions fromJSONBytes(byte[] json) {
    return WebAuthnRegistrationExtensionOptionsJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean credProps;
    public Builder credProps(Boolean credProps) { this.credProps = credProps; return this; }
    public WebAuthnRegistrationExtensionOptions build() { return new WebAuthnRegistrationExtensionOptions(credProps); }
  }
}
