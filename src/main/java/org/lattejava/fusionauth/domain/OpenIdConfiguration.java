/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OpenIdConfigurationJSON;

@JSON
public record OpenIdConfiguration(
    String authorization_endpoint,
    Boolean backchannel_logout_supported,
    List<String> claims_supported,
    String device_authorization_endpoint,
    List<String> dpop_signing_alg_values_supported,
    String end_session_endpoint,
    Boolean frontchannel_logout_supported,
    List<String> grant_types_supported,
    List<String> id_token_signing_alg_values_supported,
    String issuer,
    String jwks_uri,
    List<String> response_modes_supported,
    List<String> response_types_supported,
    List<String> scopes_supported,
    List<String> subject_types_supported,
    String token_endpoint,
    List<String> token_endpoint_auth_methods_supported,
    String userinfo_endpoint,
    List<String> userinfo_signing_alg_values_supported,
    List<String> code_challenge_methods_supported) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return OpenIdConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return OpenIdConfigurationJSON.toJSONBytes(this);
  }
  
  public static OpenIdConfiguration fromJSON(String json) {
    return OpenIdConfigurationJSON.fromJSON(json);
  }
  
  public static OpenIdConfiguration fromJSONBytes(byte[] json) {
    return OpenIdConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String authorization_endpoint;
    private Boolean backchannel_logout_supported;
    private List<String> claims_supported;
    private String device_authorization_endpoint;
    private List<String> dpop_signing_alg_values_supported;
    private String end_session_endpoint;
    private Boolean frontchannel_logout_supported;
    private List<String> grant_types_supported;
    private List<String> id_token_signing_alg_values_supported;
    private String issuer;
    private String jwks_uri;
    private List<String> response_modes_supported;
    private List<String> response_types_supported;
    private List<String> scopes_supported;
    private List<String> subject_types_supported;
    private String token_endpoint;
    private List<String> token_endpoint_auth_methods_supported;
    private String userinfo_endpoint;
    private List<String> userinfo_signing_alg_values_supported;
    private List<String> code_challenge_methods_supported;
    public Builder authorization_endpoint(String authorization_endpoint) { this.authorization_endpoint = authorization_endpoint; return this; }
    public Builder backchannel_logout_supported(Boolean backchannel_logout_supported) { this.backchannel_logout_supported = backchannel_logout_supported; return this; }
    public Builder claims_supported(List<String> claims_supported) { this.claims_supported = claims_supported; return this; }
    public Builder device_authorization_endpoint(String device_authorization_endpoint) { this.device_authorization_endpoint = device_authorization_endpoint; return this; }
    public Builder dpop_signing_alg_values_supported(List<String> dpop_signing_alg_values_supported) { this.dpop_signing_alg_values_supported = dpop_signing_alg_values_supported; return this; }
    public Builder end_session_endpoint(String end_session_endpoint) { this.end_session_endpoint = end_session_endpoint; return this; }
    public Builder frontchannel_logout_supported(Boolean frontchannel_logout_supported) { this.frontchannel_logout_supported = frontchannel_logout_supported; return this; }
    public Builder grant_types_supported(List<String> grant_types_supported) { this.grant_types_supported = grant_types_supported; return this; }
    public Builder id_token_signing_alg_values_supported(List<String> id_token_signing_alg_values_supported) { this.id_token_signing_alg_values_supported = id_token_signing_alg_values_supported; return this; }
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder jwks_uri(String jwks_uri) { this.jwks_uri = jwks_uri; return this; }
    public Builder response_modes_supported(List<String> response_modes_supported) { this.response_modes_supported = response_modes_supported; return this; }
    public Builder response_types_supported(List<String> response_types_supported) { this.response_types_supported = response_types_supported; return this; }
    public Builder scopes_supported(List<String> scopes_supported) { this.scopes_supported = scopes_supported; return this; }
    public Builder subject_types_supported(List<String> subject_types_supported) { this.subject_types_supported = subject_types_supported; return this; }
    public Builder token_endpoint(String token_endpoint) { this.token_endpoint = token_endpoint; return this; }
    public Builder token_endpoint_auth_methods_supported(List<String> token_endpoint_auth_methods_supported) { this.token_endpoint_auth_methods_supported = token_endpoint_auth_methods_supported; return this; }
    public Builder userinfo_endpoint(String userinfo_endpoint) { this.userinfo_endpoint = userinfo_endpoint; return this; }
    public Builder userinfo_signing_alg_values_supported(List<String> userinfo_signing_alg_values_supported) { this.userinfo_signing_alg_values_supported = userinfo_signing_alg_values_supported; return this; }
    public Builder code_challenge_methods_supported(List<String> code_challenge_methods_supported) { this.code_challenge_methods_supported = code_challenge_methods_supported; return this; }
    public OpenIdConfiguration build() { return new OpenIdConfiguration(authorization_endpoint, backchannel_logout_supported, claims_supported, device_authorization_endpoint, dpop_signing_alg_values_supported, end_session_endpoint, frontchannel_logout_supported, grant_types_supported, id_token_signing_alg_values_supported, issuer, jwks_uri, response_modes_supported, response_types_supported, scopes_supported, subject_types_supported, token_endpoint, token_endpoint_auth_methods_supported, userinfo_endpoint, userinfo_signing_alg_values_supported, code_challenge_methods_supported); }
  }
}
