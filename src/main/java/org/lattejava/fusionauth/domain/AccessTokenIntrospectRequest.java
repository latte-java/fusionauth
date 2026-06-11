/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AccessTokenIntrospectRequestJSON;

@JSON
public record AccessTokenIntrospectRequest(
    String client_id,
    String tenantId,
    String token,
    String token_type_hint) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AccessTokenIntrospectRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AccessTokenIntrospectRequestJSON.toJSONBytes(this);
  }

  public static AccessTokenIntrospectRequest fromJSON(String json) {
    return AccessTokenIntrospectRequestJSON.fromJSON(json);
  }

  public static AccessTokenIntrospectRequest fromJSONBytes(byte[] json) {
    return AccessTokenIntrospectRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String tenantId;
    private String token;
    private String token_type_hint;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder tenantId(String tenantId) { this.tenantId = tenantId; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder token_type_hint(String token_type_hint) { this.token_type_hint = token_type_hint; return this; }
    public AccessTokenIntrospectRequest build() { return new AccessTokenIntrospectRequest(client_id, tenantId, token, token_type_hint); }
  }
}
