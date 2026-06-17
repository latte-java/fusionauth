/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AccessTokenJSON;

@JSON
public record AccessToken(
    Integer expires_in,
    String id_token,
    String refresh_token,
    UUID refresh_token_id,
    String scope,
    String access_token,
    TokenType token_type,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AccessTokenJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return AccessTokenJSON.toJSONBytes(this);
  }
  
  public static AccessToken fromJSON(String json) {
    return AccessTokenJSON.fromJSON(json);
  }
  
  public static AccessToken fromJSONBytes(byte[] json) {
    return AccessTokenJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer expires_in;
    private String id_token;
    private String refresh_token;
    private UUID refresh_token_id;
    private String scope;
    private String access_token;
    private TokenType token_type;
    private UUID userId;
    public Builder expires_in(Integer expires_in) { this.expires_in = expires_in; return this; }
    public Builder id_token(String id_token) { this.id_token = id_token; return this; }
    public Builder refresh_token(String refresh_token) { this.refresh_token = refresh_token; return this; }
    public Builder refresh_token_id(UUID refresh_token_id) { this.refresh_token_id = refresh_token_id; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder access_token(String access_token) { this.access_token = access_token; return this; }
    public Builder token_type(TokenType token_type) { this.token_type = token_type; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public AccessToken build() { return new AccessToken(expires_in, id_token, refresh_token, refresh_token_id, scope, access_token, token_type, userId); }
  }
}
