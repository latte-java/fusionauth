/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FacebookApplicationConfigurationJSON;

@JSON
public record FacebookApplicationConfiguration(
    String appId,
    String buttonText,
    String client_secret,
    String fields,
    IdentityProviderLoginMethod loginMethod,
    String permissions,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FacebookApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FacebookApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static FacebookApplicationConfiguration fromJSON(String json) {
    return FacebookApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static FacebookApplicationConfiguration fromJSONBytes(byte[] json) {
    return FacebookApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String appId;
    private String buttonText;
    private String client_secret;
    private String fields;
    private IdentityProviderLoginMethod loginMethod;
    private String permissions;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder appId(String appId) { this.appId = appId; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder fields(String fields) { this.fields = fields; return this; }
    public Builder loginMethod(IdentityProviderLoginMethod loginMethod) { this.loginMethod = loginMethod; return this; }
    public Builder permissions(String permissions) { this.permissions = permissions; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public FacebookApplicationConfiguration build() { return new FacebookApplicationConfiguration(appId, buttonText, client_secret, fields, loginMethod, permissions, data, createRegistration); }
  }
}
