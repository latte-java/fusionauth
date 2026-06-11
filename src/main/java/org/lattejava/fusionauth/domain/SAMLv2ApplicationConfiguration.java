/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2ApplicationConfigurationJSON;

@JSON
public record SAMLv2ApplicationConfiguration(
    String buttonImageURL,
    String buttonText,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2ApplicationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SAMLv2ApplicationConfigurationJSON.toJSONBytes(this);
  }

  public static SAMLv2ApplicationConfiguration fromJSON(String json) {
    return SAMLv2ApplicationConfigurationJSON.fromJSON(json);
  }

  public static SAMLv2ApplicationConfiguration fromJSONBytes(byte[] json) {
    return SAMLv2ApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String buttonImageURL;
    private String buttonText;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder buttonImageURL(String buttonImageURL) { this.buttonImageURL = buttonImageURL; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public SAMLv2ApplicationConfiguration build() { return new SAMLv2ApplicationConfiguration(buttonImageURL, buttonText, data, createRegistration); }
  }
}
