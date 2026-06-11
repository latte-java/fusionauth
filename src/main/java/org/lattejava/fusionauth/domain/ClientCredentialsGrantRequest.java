/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ClientCredentialsGrantRequestJSON;

@JSON
public record ClientCredentialsGrantRequest(
    String client_id,
    String client_secret,
    String grant_type,
    String scope,
    String tenantId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ClientCredentialsGrantRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ClientCredentialsGrantRequestJSON.toJSONBytes(this);
  }

  public static ClientCredentialsGrantRequest fromJSON(String json) {
    return ClientCredentialsGrantRequestJSON.fromJSON(json);
  }

  public static ClientCredentialsGrantRequest fromJSONBytes(byte[] json) {
    return ClientCredentialsGrantRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String scope;
    private String tenantId;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder grant_type(String grant_type) { this.grant_type = grant_type; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder tenantId(String tenantId) { this.tenantId = tenantId; return this; }
    public ClientCredentialsGrantRequest build() { return new ClientCredentialsGrantRequest(client_id, client_secret, grant_type, scope, tenantId); }
  }
}
