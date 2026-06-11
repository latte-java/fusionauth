/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OAuth2ConfigurationJSON;

@JSON
public record OAuth2Configuration(
    List<String> authorizedOriginURLs,
    List<String> authorizedRedirectURLs,
    List<String> authorizedResourceUris,
    Oauth2AuthorizedURLValidationPolicy authorizedURLValidationPolicy,
    ClientAuthenticationPolicy clientAuthenticationPolicy,
    String clientId,
    String clientSecret,
    OAuthScopeConsentMode consentMode,
    Boolean debug,
    String deviceVerificationURL,
    Set<String> enabledGrants,
    Boolean generateRefreshTokens,
    LogoutBehavior logoutBehavior,
    String logoutURL,
    ProofKeyForCodeExchangePolicy proofKeyForCodeExchangePolicy,
    ProvidedScopePolicy providedScopePolicy,
    OAuthApplicationRelationship relationship,
    Boolean requireClientAuthentication,
    Boolean requireRegistration,
    OAuthScopeHandlingPolicy scopeHandlingPolicy,
    UnknownScopePolicy unknownScopePolicy) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return OAuth2ConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return OAuth2ConfigurationJSON.toJSONBytes(this);
  }

  public static OAuth2Configuration fromJSON(String json) {
    return OAuth2ConfigurationJSON.fromJSON(json);
  }

  public static OAuth2Configuration fromJSONBytes(byte[] json) {
    return OAuth2ConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<String> authorizedOriginURLs;
    private List<String> authorizedRedirectURLs;
    private List<String> authorizedResourceUris;
    private Oauth2AuthorizedURLValidationPolicy authorizedURLValidationPolicy;
    private ClientAuthenticationPolicy clientAuthenticationPolicy;
    private String clientId;
    private String clientSecret;
    private OAuthScopeConsentMode consentMode;
    private Boolean debug;
    private String deviceVerificationURL;
    private Set<String> enabledGrants;
    private Boolean generateRefreshTokens;
    private LogoutBehavior logoutBehavior;
    private String logoutURL;
    private ProofKeyForCodeExchangePolicy proofKeyForCodeExchangePolicy;
    private ProvidedScopePolicy providedScopePolicy;
    private OAuthApplicationRelationship relationship;
    private Boolean requireClientAuthentication;
    private Boolean requireRegistration;
    private OAuthScopeHandlingPolicy scopeHandlingPolicy;
    private UnknownScopePolicy unknownScopePolicy;
    public Builder authorizedOriginURLs(List<String> authorizedOriginURLs) { this.authorizedOriginURLs = authorizedOriginURLs; return this; }
    public Builder authorizedRedirectURLs(List<String> authorizedRedirectURLs) { this.authorizedRedirectURLs = authorizedRedirectURLs; return this; }
    public Builder authorizedResourceUris(List<String> authorizedResourceUris) { this.authorizedResourceUris = authorizedResourceUris; return this; }
    public Builder authorizedURLValidationPolicy(Oauth2AuthorizedURLValidationPolicy authorizedURLValidationPolicy) { this.authorizedURLValidationPolicy = authorizedURLValidationPolicy; return this; }
    public Builder clientAuthenticationPolicy(ClientAuthenticationPolicy clientAuthenticationPolicy) { this.clientAuthenticationPolicy = clientAuthenticationPolicy; return this; }
    public Builder clientId(String clientId) { this.clientId = clientId; return this; }
    public Builder clientSecret(String clientSecret) { this.clientSecret = clientSecret; return this; }
    public Builder consentMode(OAuthScopeConsentMode consentMode) { this.consentMode = consentMode; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder deviceVerificationURL(String deviceVerificationURL) { this.deviceVerificationURL = deviceVerificationURL; return this; }
    public Builder enabledGrants(Set<String> enabledGrants) { this.enabledGrants = enabledGrants; return this; }
    public Builder generateRefreshTokens(Boolean generateRefreshTokens) { this.generateRefreshTokens = generateRefreshTokens; return this; }
    public Builder logoutBehavior(LogoutBehavior logoutBehavior) { this.logoutBehavior = logoutBehavior; return this; }
    public Builder logoutURL(String logoutURL) { this.logoutURL = logoutURL; return this; }
    public Builder proofKeyForCodeExchangePolicy(ProofKeyForCodeExchangePolicy proofKeyForCodeExchangePolicy) { this.proofKeyForCodeExchangePolicy = proofKeyForCodeExchangePolicy; return this; }
    public Builder providedScopePolicy(ProvidedScopePolicy providedScopePolicy) { this.providedScopePolicy = providedScopePolicy; return this; }
    public Builder relationship(OAuthApplicationRelationship relationship) { this.relationship = relationship; return this; }
    public Builder requireClientAuthentication(Boolean requireClientAuthentication) { this.requireClientAuthentication = requireClientAuthentication; return this; }
    public Builder requireRegistration(Boolean requireRegistration) { this.requireRegistration = requireRegistration; return this; }
    public Builder scopeHandlingPolicy(OAuthScopeHandlingPolicy scopeHandlingPolicy) { this.scopeHandlingPolicy = scopeHandlingPolicy; return this; }
    public Builder unknownScopePolicy(UnknownScopePolicy unknownScopePolicy) { this.unknownScopePolicy = unknownScopePolicy; return this; }
    public OAuth2Configuration build() { return new OAuth2Configuration(authorizedOriginURLs, authorizedRedirectURLs, authorizedResourceUris, authorizedURLValidationPolicy, clientAuthenticationPolicy, clientId, clientSecret, consentMode, debug, deviceVerificationURL, enabledGrants, generateRefreshTokens, logoutBehavior, logoutURL, proofKeyForCodeExchangePolicy, providedScopePolicy, relationship, requireClientAuthentication, requireRegistration, scopeHandlingPolicy, unknownScopePolicy); }
  }
}
