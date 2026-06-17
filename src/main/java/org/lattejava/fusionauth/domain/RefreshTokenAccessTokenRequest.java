/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshTokenAccessTokenRequestJSON;

@JSON
public record RefreshTokenAccessTokenRequest(
    String client_id,
    String client_secret,
    String grant_type,
    String refresh_token,
    String scope,
    UUID tenantId,
    String user_code) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshTokenAccessTokenRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RefreshTokenAccessTokenRequestJSON.toJSONBytes(this);
  }
  
  public static RefreshTokenAccessTokenRequest fromJSON(String json) {
    return RefreshTokenAccessTokenRequestJSON.fromJSON(json);
  }
  
  public static RefreshTokenAccessTokenRequest fromJSONBytes(byte[] json) {
    return RefreshTokenAccessTokenRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String refresh_token;
    private String scope;
    private UUID tenantId;
    private String user_code;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder grant_type(String grant_type) { this.grant_type = grant_type; return this; }
    public Builder refresh_token(String refresh_token) { this.refresh_token = refresh_token; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder user_code(String user_code) { this.user_code = user_code; return this; }
    public RefreshTokenAccessTokenRequest build() { return new RefreshTokenAccessTokenRequest(client_id, client_secret, grant_type, refresh_token, scope, tenantId, user_code); }
  }
}
