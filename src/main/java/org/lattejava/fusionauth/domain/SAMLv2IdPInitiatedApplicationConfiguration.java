/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2IdPInitiatedApplicationConfigurationJSON;

@JSON
public record SAMLv2IdPInitiatedApplicationConfiguration(
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2IdPInitiatedApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SAMLv2IdPInitiatedApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static SAMLv2IdPInitiatedApplicationConfiguration fromJSON(String json) {
    return SAMLv2IdPInitiatedApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static SAMLv2IdPInitiatedApplicationConfiguration fromJSONBytes(byte[] json) {
    return SAMLv2IdPInitiatedApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public SAMLv2IdPInitiatedApplicationConfiguration build() { return new SAMLv2IdPInitiatedApplicationConfiguration(data, createRegistration); }
  }
}
