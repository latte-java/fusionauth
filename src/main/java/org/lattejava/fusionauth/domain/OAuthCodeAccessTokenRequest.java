/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OAuthCodeAccessTokenRequestJSON;

@JSON
public record OAuthCodeAccessTokenRequest(
    String client_id,
    String client_secret,
    String code,
    String grant_type,
    String redirect_uri,
    String tenantId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return OAuthCodeAccessTokenRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return OAuthCodeAccessTokenRequestJSON.toJSONBytes(this);
  }

  public static OAuthCodeAccessTokenRequest fromJSON(String json) {
    return OAuthCodeAccessTokenRequestJSON.fromJSON(json);
  }

  public static OAuthCodeAccessTokenRequest fromJSONBytes(byte[] json) {
    return OAuthCodeAccessTokenRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String client_secret;
    private String code;
    private String grant_type;
    private String redirect_uri;
    private String tenantId;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder code(String code) { this.code = code; return this; }
    public Builder grant_type(String grant_type) { this.grant_type = grant_type; return this; }
    public Builder redirect_uri(String redirect_uri) { this.redirect_uri = redirect_uri; return this; }
    public Builder tenantId(String tenantId) { this.tenantId = tenantId; return this; }
    public OAuthCodeAccessTokenRequest build() { return new OAuthCodeAccessTokenRequest(client_id, client_secret, code, grant_type, redirect_uri, tenantId); }
  }
}
