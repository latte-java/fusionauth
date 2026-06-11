/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OAuthConfigurationResponseJSON;

@JSON
public record OAuthConfigurationResponse(
    Integer httpSessionMaxInactiveInterval,
    String logoutURL,
    OAuth2Configuration oauthConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return OAuthConfigurationResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return OAuthConfigurationResponseJSON.toJSONBytes(this);
  }

  public static OAuthConfigurationResponse fromJSON(String json) {
    return OAuthConfigurationResponseJSON.fromJSON(json);
  }

  public static OAuthConfigurationResponse fromJSONBytes(byte[] json) {
    return OAuthConfigurationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer httpSessionMaxInactiveInterval;
    private String logoutURL;
    private OAuth2Configuration oauthConfiguration;
    public Builder httpSessionMaxInactiveInterval(Integer httpSessionMaxInactiveInterval) { this.httpSessionMaxInactiveInterval = httpSessionMaxInactiveInterval; return this; }
    public Builder logoutURL(String logoutURL) { this.logoutURL = logoutURL; return this; }
    public Builder oauthConfiguration(OAuth2Configuration oauthConfiguration) { this.oauthConfiguration = oauthConfiguration; return this; }
    public OAuthConfigurationResponse build() { return new OAuthConfigurationResponse(httpSessionMaxInactiveInterval, logoutURL, oauthConfiguration); }
  }
}
