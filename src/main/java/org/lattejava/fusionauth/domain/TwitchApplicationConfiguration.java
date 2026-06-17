/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwitchApplicationConfigurationJSON;

@JSON
public record TwitchApplicationConfiguration(
    String buttonText,
    String client_id,
    String client_secret,
    String scope,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwitchApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TwitchApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static TwitchApplicationConfiguration fromJSON(String json) {
    return TwitchApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static TwitchApplicationConfiguration fromJSONBytes(byte[] json) {
    return TwitchApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String buttonText;
    private String client_id;
    private String client_secret;
    private String scope;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public TwitchApplicationConfiguration build() { return new TwitchApplicationConfiguration(buttonText, client_id, client_secret, scope, data, createRegistration); }
  }
}
