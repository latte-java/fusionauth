/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderOauth2ConfigurationJSON;

@JSON
public record IdentityProviderOauth2Configuration(
    String authorization_endpoint,
    ClientAuthenticationMethod clientAuthenticationMethod,
    String client_id,
    String client_secret,
    String emailClaim,
    String emailVerifiedClaim,
    String issuer,
    String scope,
    String token_endpoint,
    String uniqueIdClaim,
    String userinfo_endpoint,
    String usernameClaim) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderOauth2ConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderOauth2ConfigurationJSON.toJSONBytes(this);
  }

  public static IdentityProviderOauth2Configuration fromJSON(String json) {
    return IdentityProviderOauth2ConfigurationJSON.fromJSON(json);
  }

  public static IdentityProviderOauth2Configuration fromJSONBytes(byte[] json) {
    return IdentityProviderOauth2ConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String authorization_endpoint;
    private ClientAuthenticationMethod clientAuthenticationMethod;
    private String client_id;
    private String client_secret;
    private String emailClaim;
    private String emailVerifiedClaim;
    private String issuer;
    private String scope;
    private String token_endpoint;
    private String uniqueIdClaim;
    private String userinfo_endpoint;
    private String usernameClaim;
    public Builder authorization_endpoint(String authorization_endpoint) { this.authorization_endpoint = authorization_endpoint; return this; }
    public Builder clientAuthenticationMethod(ClientAuthenticationMethod clientAuthenticationMethod) { this.clientAuthenticationMethod = clientAuthenticationMethod; return this; }
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder emailClaim(String emailClaim) { this.emailClaim = emailClaim; return this; }
    public Builder emailVerifiedClaim(String emailVerifiedClaim) { this.emailVerifiedClaim = emailVerifiedClaim; return this; }
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder token_endpoint(String token_endpoint) { this.token_endpoint = token_endpoint; return this; }
    public Builder uniqueIdClaim(String uniqueIdClaim) { this.uniqueIdClaim = uniqueIdClaim; return this; }
    public Builder userinfo_endpoint(String userinfo_endpoint) { this.userinfo_endpoint = userinfo_endpoint; return this; }
    public Builder usernameClaim(String usernameClaim) { this.usernameClaim = usernameClaim; return this; }
    public IdentityProviderOauth2Configuration build() { return new IdentityProviderOauth2Configuration(authorization_endpoint, clientAuthenticationMethod, client_id, client_secret, emailClaim, emailVerifiedClaim, issuer, scope, token_endpoint, uniqueIdClaim, userinfo_endpoint, usernameClaim); }
  }
}
