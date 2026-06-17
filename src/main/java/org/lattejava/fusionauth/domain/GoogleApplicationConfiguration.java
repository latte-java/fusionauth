/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GoogleApplicationConfigurationJSON;

@JSON
public record GoogleApplicationConfiguration(
    String buttonText,
    String client_id,
    String client_secret,
    IdentityProviderLoginMethod loginMethod,
    GoogleIdentityProviderProperties properties,
    String scope,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GoogleApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GoogleApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static GoogleApplicationConfiguration fromJSON(String json) {
    return GoogleApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static GoogleApplicationConfiguration fromJSONBytes(byte[] json) {
    return GoogleApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String buttonText;
    private String client_id;
    private String client_secret;
    private IdentityProviderLoginMethod loginMethod;
    private GoogleIdentityProviderProperties properties;
    private String scope;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder loginMethod(IdentityProviderLoginMethod loginMethod) { this.loginMethod = loginMethod; return this; }
    public Builder properties(GoogleIdentityProviderProperties properties) { this.properties = properties; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public GoogleApplicationConfiguration build() { return new GoogleApplicationConfiguration(buttonText, client_id, client_secret, loginMethod, properties, scope, data, createRegistration); }
  }
}
