/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2IdpInitiatedConfigurationJSON;

@JSON
public record SAMLv2IdpInitiatedConfiguration(
    String issuer,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2IdpInitiatedConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SAMLv2IdpInitiatedConfigurationJSON.toJSONBytes(this);
  }
  
  public static SAMLv2IdpInitiatedConfiguration fromJSON(String json) {
    return SAMLv2IdpInitiatedConfigurationJSON.fromJSON(json);
  }
  
  public static SAMLv2IdpInitiatedConfiguration fromJSONBytes(byte[] json) {
    return SAMLv2IdpInitiatedConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String issuer;
    private Boolean enabled;
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public SAMLv2IdpInitiatedConfiguration build() { return new SAMLv2IdpInitiatedConfiguration(issuer, enabled); }
  }
}
