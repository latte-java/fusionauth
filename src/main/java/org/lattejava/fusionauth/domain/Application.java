/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationJSON;

@JSON
public record Application(
    ApplicationAccessControlConfiguration accessControlConfiguration,
    Boolean active,
    AuthenticationTokenConfiguration authenticationTokenConfiguration,
    CleanSpeakConfiguration cleanSpeakConfiguration,
    Map<String, Object> data,
    ApplicationEmailConfiguration emailConfiguration,
    ApplicationExternalIdentifierConfiguration externalIdentifierConfiguration,
    ApplicationFormConfiguration formConfiguration,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    JWTConfiguration jwtConfiguration,
    LambdaConfiguration lambdaConfiguration,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    LoginConfiguration loginConfiguration,
    ApplicationMultiFactorConfiguration multiFactorConfiguration,
    String name,
    OAuth2Configuration oauthConfiguration,
    PasswordlessConfiguration passwordlessConfiguration,
    ApplicationPhoneConfiguration phoneConfiguration,
    RegistrationConfiguration registrationConfiguration,
    ApplicationRegistrationDeletePolicy registrationDeletePolicy,
    List<ApplicationRole> roles,
    SAMLv2Configuration samlv2Configuration,
    List<ApplicationOAuthScope> scopes,
    ObjectState state,
    UUID tenantId,
    UUID themeId,
    UniversalApplicationConfiguration universalConfiguration,
    RegistrationUnverifiedOptions unverified,
    UUID verificationEmailTemplateId,
    VerificationStrategy verificationStrategy,
    Boolean verifyRegistration,
    ApplicationWebAuthnConfiguration webAuthnConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationJSON.toJSONBytes(this);
  }
  
  public static Application fromJSON(String json) {
    return ApplicationJSON.fromJSON(json);
  }
  
  public static Application fromJSONBytes(byte[] json) {
    return ApplicationJSON.fromJSON(json);
  }

  public static final class Builder {
    private ApplicationAccessControlConfiguration accessControlConfiguration;
    private Boolean active;
    private AuthenticationTokenConfiguration authenticationTokenConfiguration;
    private CleanSpeakConfiguration cleanSpeakConfiguration;
    private Map<String, Object> data;
    private ApplicationEmailConfiguration emailConfiguration;
    private ApplicationExternalIdentifierConfiguration externalIdentifierConfiguration;
    private ApplicationFormConfiguration formConfiguration;
    private UUID id;
    private Instant insertInstant;
    private JWTConfiguration jwtConfiguration;
    private LambdaConfiguration lambdaConfiguration;
    private Instant lastUpdateInstant;
    private LoginConfiguration loginConfiguration;
    private ApplicationMultiFactorConfiguration multiFactorConfiguration;
    private String name;
    private OAuth2Configuration oauthConfiguration;
    private PasswordlessConfiguration passwordlessConfiguration;
    private ApplicationPhoneConfiguration phoneConfiguration;
    private RegistrationConfiguration registrationConfiguration;
    private ApplicationRegistrationDeletePolicy registrationDeletePolicy;
    private List<ApplicationRole> roles;
    private SAMLv2Configuration samlv2Configuration;
    private List<ApplicationOAuthScope> scopes;
    private ObjectState state;
    private UUID tenantId;
    private UUID themeId;
    private UniversalApplicationConfiguration universalConfiguration;
    private RegistrationUnverifiedOptions unverified;
    private UUID verificationEmailTemplateId;
    private VerificationStrategy verificationStrategy;
    private Boolean verifyRegistration;
    private ApplicationWebAuthnConfiguration webAuthnConfiguration;
    public Builder accessControlConfiguration(ApplicationAccessControlConfiguration accessControlConfiguration) { this.accessControlConfiguration = accessControlConfiguration; return this; }
    public Builder active(Boolean active) { this.active = active; return this; }
    public Builder authenticationTokenConfiguration(AuthenticationTokenConfiguration authenticationTokenConfiguration) { this.authenticationTokenConfiguration = authenticationTokenConfiguration; return this; }
    public Builder cleanSpeakConfiguration(CleanSpeakConfiguration cleanSpeakConfiguration) { this.cleanSpeakConfiguration = cleanSpeakConfiguration; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder emailConfiguration(ApplicationEmailConfiguration emailConfiguration) { this.emailConfiguration = emailConfiguration; return this; }
    public Builder externalIdentifierConfiguration(ApplicationExternalIdentifierConfiguration externalIdentifierConfiguration) { this.externalIdentifierConfiguration = externalIdentifierConfiguration; return this; }
    public Builder formConfiguration(ApplicationFormConfiguration formConfiguration) { this.formConfiguration = formConfiguration; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder jwtConfiguration(JWTConfiguration jwtConfiguration) { this.jwtConfiguration = jwtConfiguration; return this; }
    public Builder lambdaConfiguration(LambdaConfiguration lambdaConfiguration) { this.lambdaConfiguration = lambdaConfiguration; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder loginConfiguration(LoginConfiguration loginConfiguration) { this.loginConfiguration = loginConfiguration; return this; }
    public Builder multiFactorConfiguration(ApplicationMultiFactorConfiguration multiFactorConfiguration) { this.multiFactorConfiguration = multiFactorConfiguration; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder oauthConfiguration(OAuth2Configuration oauthConfiguration) { this.oauthConfiguration = oauthConfiguration; return this; }
    public Builder passwordlessConfiguration(PasswordlessConfiguration passwordlessConfiguration) { this.passwordlessConfiguration = passwordlessConfiguration; return this; }
    public Builder phoneConfiguration(ApplicationPhoneConfiguration phoneConfiguration) { this.phoneConfiguration = phoneConfiguration; return this; }
    public Builder registrationConfiguration(RegistrationConfiguration registrationConfiguration) { this.registrationConfiguration = registrationConfiguration; return this; }
    public Builder registrationDeletePolicy(ApplicationRegistrationDeletePolicy registrationDeletePolicy) { this.registrationDeletePolicy = registrationDeletePolicy; return this; }
    public Builder roles(List<ApplicationRole> roles) { this.roles = roles; return this; }
    public Builder samlv2Configuration(SAMLv2Configuration samlv2Configuration) { this.samlv2Configuration = samlv2Configuration; return this; }
    public Builder scopes(List<ApplicationOAuthScope> scopes) { this.scopes = scopes; return this; }
    public Builder state(ObjectState state) { this.state = state; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder themeId(UUID themeId) { this.themeId = themeId; return this; }
    public Builder universalConfiguration(UniversalApplicationConfiguration universalConfiguration) { this.universalConfiguration = universalConfiguration; return this; }
    public Builder unverified(RegistrationUnverifiedOptions unverified) { this.unverified = unverified; return this; }
    public Builder verificationEmailTemplateId(UUID verificationEmailTemplateId) { this.verificationEmailTemplateId = verificationEmailTemplateId; return this; }
    public Builder verificationStrategy(VerificationStrategy verificationStrategy) { this.verificationStrategy = verificationStrategy; return this; }
    public Builder verifyRegistration(Boolean verifyRegistration) { this.verifyRegistration = verifyRegistration; return this; }
    public Builder webAuthnConfiguration(ApplicationWebAuthnConfiguration webAuthnConfiguration) { this.webAuthnConfiguration = webAuthnConfiguration; return this; }
    public Application build() { return new Application(accessControlConfiguration, active, authenticationTokenConfiguration, cleanSpeakConfiguration, data, emailConfiguration, externalIdentifierConfiguration, formConfiguration, id, insertInstant, jwtConfiguration, lambdaConfiguration, lastUpdateInstant, loginConfiguration, multiFactorConfiguration, name, oauthConfiguration, passwordlessConfiguration, phoneConfiguration, registrationConfiguration, registrationDeletePolicy, roles, samlv2Configuration, scopes, state, tenantId, themeId, universalConfiguration, unverified, verificationEmailTemplateId, verificationStrategy, verifyRegistration, webAuthnConfiguration); }
  }
}
