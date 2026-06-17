/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCredentialsAccessTokenRequestJSON;

@JSON
public record UserCredentialsAccessTokenRequest(
    String client_id,
    String client_secret,
    String grant_type,
    String password,
    String scope,
    UUID tenantId,
    String user_code,
    String username) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCredentialsAccessTokenRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserCredentialsAccessTokenRequestJSON.toJSONBytes(this);
  }
  
  public static UserCredentialsAccessTokenRequest fromJSON(String json) {
    return UserCredentialsAccessTokenRequestJSON.fromJSON(json);
  }
  
  public static UserCredentialsAccessTokenRequest fromJSONBytes(byte[] json) {
    return UserCredentialsAccessTokenRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String password;
    private String scope;
    private UUID tenantId;
    private String user_code;
    private String username;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder grant_type(String grant_type) { this.grant_type = grant_type; return this; }
    public Builder password(String password) { this.password = password; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder user_code(String user_code) { this.user_code = user_code; return this; }
    public Builder username(String username) { this.username = username; return this; }
    public UserCredentialsAccessTokenRequest build() { return new UserCredentialsAccessTokenRequest(client_id, client_secret, grant_type, password, scope, tenantId, user_code, username); }
  }
}
