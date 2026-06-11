/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ReactorStatusJSON;

@JSON
public record ReactorStatus(
    ReactorFeatureStatus advancedIdentityProviders,
    ReactorFeatureStatus advancedLambdas,
    ReactorFeatureStatus advancedMultiFactorAuthentication,
    ReactorFeatureStatus advancedOAuthScopes,
    ReactorFeatureStatus advancedOAuthScopesCustomScopes,
    ReactorFeatureStatus advancedOAuthScopesThirdPartyApplications,
    ReactorFeatureStatus advancedRegistration,
    ReactorFeatureStatus applicationMultiFactorAuthentication,
    ReactorFeatureStatus applicationThemes,
    ReactorFeatureStatus breachedPasswordDetection,
    ReactorFeatureStatus connectors,
    ReactorFeatureStatus dPoP,
    ReactorFeatureStatus entityManagement,
    ReactorFeatureStatus legacyAdapter,
    LocalDate expiration,
    ReactorFeatureStatus ipGeoLocation,
    Map<String, String> licenseAttributes,
    Boolean licensed,
    ReactorFeatureStatus multiFactorLambdas,
    ReactorFeatureStatus scimServer,
    ReactorFeatureStatus tenantManagerApplication,
    ReactorFeatureStatus threatDetection,
    ReactorFeatureStatus universalApplication,
    ReactorFeatureStatus webAuthn,
    ReactorFeatureStatus webAuthnPlatformAuthenticators,
    ReactorFeatureStatus webAuthnRoamingAuthenticators) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ReactorStatusJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ReactorStatusJSON.toJSONBytes(this);
  }

  public static ReactorStatus fromJSON(String json) {
    return ReactorStatusJSON.fromJSON(json);
  }

  public static ReactorStatus fromJSONBytes(byte[] json) {
    return ReactorStatusJSON.fromJSON(json);
  }

  public static final class Builder {
    private ReactorFeatureStatus advancedIdentityProviders;
    private ReactorFeatureStatus advancedLambdas;
    private ReactorFeatureStatus advancedMultiFactorAuthentication;
    private ReactorFeatureStatus advancedOAuthScopes;
    private ReactorFeatureStatus advancedOAuthScopesCustomScopes;
    private ReactorFeatureStatus advancedOAuthScopesThirdPartyApplications;
    private ReactorFeatureStatus advancedRegistration;
    private ReactorFeatureStatus applicationMultiFactorAuthentication;
    private ReactorFeatureStatus applicationThemes;
    private ReactorFeatureStatus breachedPasswordDetection;
    private ReactorFeatureStatus connectors;
    private ReactorFeatureStatus dPoP;
    private ReactorFeatureStatus entityManagement;
    private ReactorFeatureStatus legacyAdapter;
    private LocalDate expiration;
    private ReactorFeatureStatus ipGeoLocation;
    private Map<String, String> licenseAttributes;
    private Boolean licensed;
    private ReactorFeatureStatus multiFactorLambdas;
    private ReactorFeatureStatus scimServer;
    private ReactorFeatureStatus tenantManagerApplication;
    private ReactorFeatureStatus threatDetection;
    private ReactorFeatureStatus universalApplication;
    private ReactorFeatureStatus webAuthn;
    private ReactorFeatureStatus webAuthnPlatformAuthenticators;
    private ReactorFeatureStatus webAuthnRoamingAuthenticators;
    public Builder advancedIdentityProviders(ReactorFeatureStatus advancedIdentityProviders) { this.advancedIdentityProviders = advancedIdentityProviders; return this; }
    public Builder advancedLambdas(ReactorFeatureStatus advancedLambdas) { this.advancedLambdas = advancedLambdas; return this; }
    public Builder advancedMultiFactorAuthentication(ReactorFeatureStatus advancedMultiFactorAuthentication) { this.advancedMultiFactorAuthentication = advancedMultiFactorAuthentication; return this; }
    public Builder advancedOAuthScopes(ReactorFeatureStatus advancedOAuthScopes) { this.advancedOAuthScopes = advancedOAuthScopes; return this; }
    public Builder advancedOAuthScopesCustomScopes(ReactorFeatureStatus advancedOAuthScopesCustomScopes) { this.advancedOAuthScopesCustomScopes = advancedOAuthScopesCustomScopes; return this; }
    public Builder advancedOAuthScopesThirdPartyApplications(ReactorFeatureStatus advancedOAuthScopesThirdPartyApplications) { this.advancedOAuthScopesThirdPartyApplications = advancedOAuthScopesThirdPartyApplications; return this; }
    public Builder advancedRegistration(ReactorFeatureStatus advancedRegistration) { this.advancedRegistration = advancedRegistration; return this; }
    public Builder applicationMultiFactorAuthentication(ReactorFeatureStatus applicationMultiFactorAuthentication) { this.applicationMultiFactorAuthentication = applicationMultiFactorAuthentication; return this; }
    public Builder applicationThemes(ReactorFeatureStatus applicationThemes) { this.applicationThemes = applicationThemes; return this; }
    public Builder breachedPasswordDetection(ReactorFeatureStatus breachedPasswordDetection) { this.breachedPasswordDetection = breachedPasswordDetection; return this; }
    public Builder connectors(ReactorFeatureStatus connectors) { this.connectors = connectors; return this; }
    public Builder dPoP(ReactorFeatureStatus dPoP) { this.dPoP = dPoP; return this; }
    public Builder entityManagement(ReactorFeatureStatus entityManagement) { this.entityManagement = entityManagement; return this; }
    public Builder legacyAdapter(ReactorFeatureStatus legacyAdapter) { this.legacyAdapter = legacyAdapter; return this; }
    public Builder expiration(LocalDate expiration) { this.expiration = expiration; return this; }
    public Builder ipGeoLocation(ReactorFeatureStatus ipGeoLocation) { this.ipGeoLocation = ipGeoLocation; return this; }
    public Builder licenseAttributes(Map<String, String> licenseAttributes) { this.licenseAttributes = licenseAttributes; return this; }
    public Builder licensed(Boolean licensed) { this.licensed = licensed; return this; }
    public Builder multiFactorLambdas(ReactorFeatureStatus multiFactorLambdas) { this.multiFactorLambdas = multiFactorLambdas; return this; }
    public Builder scimServer(ReactorFeatureStatus scimServer) { this.scimServer = scimServer; return this; }
    public Builder tenantManagerApplication(ReactorFeatureStatus tenantManagerApplication) { this.tenantManagerApplication = tenantManagerApplication; return this; }
    public Builder threatDetection(ReactorFeatureStatus threatDetection) { this.threatDetection = threatDetection; return this; }
    public Builder universalApplication(ReactorFeatureStatus universalApplication) { this.universalApplication = universalApplication; return this; }
    public Builder webAuthn(ReactorFeatureStatus webAuthn) { this.webAuthn = webAuthn; return this; }
    public Builder webAuthnPlatformAuthenticators(ReactorFeatureStatus webAuthnPlatformAuthenticators) { this.webAuthnPlatformAuthenticators = webAuthnPlatformAuthenticators; return this; }
    public Builder webAuthnRoamingAuthenticators(ReactorFeatureStatus webAuthnRoamingAuthenticators) { this.webAuthnRoamingAuthenticators = webAuthnRoamingAuthenticators; return this; }
    public ReactorStatus build() { return new ReactorStatus(advancedIdentityProviders, advancedLambdas, advancedMultiFactorAuthentication, advancedOAuthScopes, advancedOAuthScopesCustomScopes, advancedOAuthScopesThirdPartyApplications, advancedRegistration, applicationMultiFactorAuthentication, applicationThemes, breachedPasswordDetection, connectors, dPoP, entityManagement, legacyAdapter, expiration, ipGeoLocation, licenseAttributes, licensed, multiFactorLambdas, scimServer, tenantManagerApplication, threatDetection, universalApplication, webAuthn, webAuthnPlatformAuthenticators, webAuthnRoamingAuthenticators); }
  }
}
