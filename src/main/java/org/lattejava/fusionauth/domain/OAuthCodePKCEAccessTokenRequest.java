/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OAuthCodePKCEAccessTokenRequestJSON;

@JSON
public record OAuthCodePKCEAccessTokenRequest(
    String client_id,
    String client_secret,
    String code,
    String code_verifier,
    String grant_type,
    String redirect_uri,
    UUID tenantId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return OAuthCodePKCEAccessTokenRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return OAuthCodePKCEAccessTokenRequestJSON.toJSONBytes(this);
  }

  public static OAuthCodePKCEAccessTokenRequest fromJSON(String json) {
    return OAuthCodePKCEAccessTokenRequestJSON.fromJSON(json);
  }

  public static OAuthCodePKCEAccessTokenRequest fromJSONBytes(byte[] json) {
    return OAuthCodePKCEAccessTokenRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String client_secret;
    private String code;
    private String code_verifier;
    private String grant_type;
    private String redirect_uri;
    private UUID tenantId;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder code(String code) { this.code = code; return this; }
    public Builder code_verifier(String code_verifier) { this.code_verifier = code_verifier; return this; }
    public Builder grant_type(String grant_type) { this.grant_type = grant_type; return this; }
    public Builder redirect_uri(String redirect_uri) { this.redirect_uri = redirect_uri; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public OAuthCodePKCEAccessTokenRequest build() { return new OAuthCodePKCEAccessTokenRequest(client_id, client_secret, code, code_verifier, grant_type, redirect_uri, tenantId); }
  }
}
