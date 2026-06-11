/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ClientCredentialsAccessTokenIntrospectRequestJSON;

@JSON
public record ClientCredentialsAccessTokenIntrospectRequest(
    String tenantId,
    String token) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ClientCredentialsAccessTokenIntrospectRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ClientCredentialsAccessTokenIntrospectRequestJSON.toJSONBytes(this);
  }

  public static ClientCredentialsAccessTokenIntrospectRequest fromJSON(String json) {
    return ClientCredentialsAccessTokenIntrospectRequestJSON.fromJSON(json);
  }

  public static ClientCredentialsAccessTokenIntrospectRequest fromJSONBytes(byte[] json) {
    return ClientCredentialsAccessTokenIntrospectRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String tenantId;
    private String token;
    public Builder tenantId(String tenantId) { this.tenantId = tenantId; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public ClientCredentialsAccessTokenIntrospectRequest build() { return new ClientCredentialsAccessTokenIntrospectRequest(tenantId, token); }
  }
}
