/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2IdPInitiatedLoginConfigurationJSON;

@JSON
public record SAMLv2IdPInitiatedLoginConfiguration(
    String nameIdFormat,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2IdPInitiatedLoginConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SAMLv2IdPInitiatedLoginConfigurationJSON.toJSONBytes(this);
  }

  public static SAMLv2IdPInitiatedLoginConfiguration fromJSON(String json) {
    return SAMLv2IdPInitiatedLoginConfigurationJSON.fromJSON(json);
  }

  public static SAMLv2IdPInitiatedLoginConfiguration fromJSONBytes(byte[] json) {
    return SAMLv2IdPInitiatedLoginConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String nameIdFormat;
    private Boolean enabled;
    public Builder nameIdFormat(String nameIdFormat) { this.nameIdFormat = nameIdFormat; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public SAMLv2IdPInitiatedLoginConfiguration build() { return new SAMLv2IdPInitiatedLoginConfiguration(nameIdFormat, enabled); }
  }
}
