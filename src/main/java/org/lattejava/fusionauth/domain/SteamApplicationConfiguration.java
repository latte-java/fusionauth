/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SteamApplicationConfigurationJSON;

@JSON
public record SteamApplicationConfiguration(
    SteamAPIMode apiMode,
    String buttonText,
    String client_id,
    String scope,
    String webAPIKey,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SteamApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SteamApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static SteamApplicationConfiguration fromJSON(String json) {
    return SteamApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static SteamApplicationConfiguration fromJSONBytes(byte[] json) {
    return SteamApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private SteamAPIMode apiMode;
    private String buttonText;
    private String client_id;
    private String scope;
    private String webAPIKey;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder apiMode(SteamAPIMode apiMode) { this.apiMode = apiMode; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder webAPIKey(String webAPIKey) { this.webAPIKey = webAPIKey; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public SteamApplicationConfiguration build() { return new SteamApplicationConfiguration(apiMode, buttonText, client_id, scope, webAPIKey, data, createRegistration); }
  }
}
