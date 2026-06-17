/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OpenIdConnectApplicationConfigurationJSON;

@JSON
public record OpenIdConnectApplicationConfiguration(
    String buttonImageURL,
    String buttonText,
    IdentityProviderOauth2Configuration oauth2,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return OpenIdConnectApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return OpenIdConnectApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static OpenIdConnectApplicationConfiguration fromJSON(String json) {
    return OpenIdConnectApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static OpenIdConnectApplicationConfiguration fromJSONBytes(byte[] json) {
    return OpenIdConnectApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String buttonImageURL;
    private String buttonText;
    private IdentityProviderOauth2Configuration oauth2;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder buttonImageURL(String buttonImageURL) { this.buttonImageURL = buttonImageURL; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder oauth2(IdentityProviderOauth2Configuration oauth2) { this.oauth2 = oauth2; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public OpenIdConnectApplicationConfiguration build() { return new OpenIdConnectApplicationConfiguration(buttonImageURL, buttonText, oauth2, data, createRegistration); }
  }
}
