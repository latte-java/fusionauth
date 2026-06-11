/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.NintendoApplicationConfigurationJSON;

@JSON
public record NintendoApplicationConfiguration(
    String buttonText,
    String client_id,
    String client_secret,
    String emailClaim,
    String scope,
    String uniqueIdClaim,
    String usernameClaim,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return NintendoApplicationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return NintendoApplicationConfigurationJSON.toJSONBytes(this);
  }

  public static NintendoApplicationConfiguration fromJSON(String json) {
    return NintendoApplicationConfigurationJSON.fromJSON(json);
  }

  public static NintendoApplicationConfiguration fromJSONBytes(byte[] json) {
    return NintendoApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String buttonText;
    private String client_id;
    private String client_secret;
    private String emailClaim;
    private String scope;
    private String uniqueIdClaim;
    private String usernameClaim;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder emailClaim(String emailClaim) { this.emailClaim = emailClaim; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder uniqueIdClaim(String uniqueIdClaim) { this.uniqueIdClaim = uniqueIdClaim; return this; }
    public Builder usernameClaim(String usernameClaim) { this.usernameClaim = usernameClaim; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public NintendoApplicationConfiguration build() { return new NintendoApplicationConfiguration(buttonText, client_id, client_secret, emailClaim, scope, uniqueIdClaim, usernameClaim, data, createRegistration); }
  }
}
