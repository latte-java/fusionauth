/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantJSON;

@JSON
public record Tenant(
    Map<String, Object> data,
    TenantAccessControlConfiguration accessControlConfiguration,
    TenantCaptchaConfiguration captchaConfiguration,
    Boolean configured,
    List<ConnectorPolicy> connectorPolicies,
    EmailConfiguration emailConfiguration,
    EventConfiguration eventConfiguration,
    ExternalIdentifierConfiguration externalIdentifierConfiguration,
    FailedAuthenticationConfiguration failedAuthenticationConfiguration,
    FamilyConfiguration familyConfiguration,
    TenantFormConfiguration formConfiguration,
    Integer httpSessionMaxInactiveInterval,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    String issuer,
    JWTConfiguration jwtConfiguration,
    TenantLambdaConfiguration lambdaConfiguration,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    TenantLoginConfiguration loginConfiguration,
    String logoutURL,
    MaximumPasswordAge maximumPasswordAge,
    MinimumPasswordAge minimumPasswordAge,
    TenantMultiFactorConfiguration multiFactorConfiguration,
    String name,
    TenantOAuth2Configuration oauthConfiguration,
    PasswordEncryptionConfiguration passwordEncryptionConfiguration,
    PasswordValidationRules passwordValidationRules,
    TenantPhoneConfiguration phoneConfiguration,
    TenantRateLimitConfiguration rateLimitConfiguration,
    TenantRegistrationConfiguration registrationConfiguration,
    TenantSCIMServerConfiguration scimServerConfiguration,
    TenantSSOConfiguration ssoConfiguration,
    ObjectState state,
    UUID themeId,
    TenantUserDeletePolicy userDeletePolicy,
    TenantUsernameConfiguration usernameConfiguration,
    TenantWebAuthnConfiguration webAuthnConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantJSON.toJSONBytes(this);
  }

  public static Tenant fromJSON(String json) {
    return TenantJSON.fromJSON(json);
  }

  public static Tenant fromJSONBytes(byte[] json) {
    return TenantJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private TenantAccessControlConfiguration accessControlConfiguration;
    private TenantCaptchaConfiguration captchaConfiguration;
    private Boolean configured;
    private List<ConnectorPolicy> connectorPolicies;
    private EmailConfiguration emailConfiguration;
    private EventConfiguration eventConfiguration;
    private ExternalIdentifierConfiguration externalIdentifierConfiguration;
    private FailedAuthenticationConfiguration failedAuthenticationConfiguration;
    private FamilyConfiguration familyConfiguration;
    private TenantFormConfiguration formConfiguration;
    private Integer httpSessionMaxInactiveInterval;
    private UUID id;
    private Instant insertInstant;
    private String issuer;
    private JWTConfiguration jwtConfiguration;
    private TenantLambdaConfiguration lambdaConfiguration;
    private Instant lastUpdateInstant;
    private TenantLoginConfiguration loginConfiguration;
    private String logoutURL;
    private MaximumPasswordAge maximumPasswordAge;
    private MinimumPasswordAge minimumPasswordAge;
    private TenantMultiFactorConfiguration multiFactorConfiguration;
    private String name;
    private TenantOAuth2Configuration oauthConfiguration;
    private PasswordEncryptionConfiguration passwordEncryptionConfiguration;
    private PasswordValidationRules passwordValidationRules;
    private TenantPhoneConfiguration phoneConfiguration;
    private TenantRateLimitConfiguration rateLimitConfiguration;
    private TenantRegistrationConfiguration registrationConfiguration;
    private TenantSCIMServerConfiguration scimServerConfiguration;
    private TenantSSOConfiguration ssoConfiguration;
    private ObjectState state;
    private UUID themeId;
    private TenantUserDeletePolicy userDeletePolicy;
    private TenantUsernameConfiguration usernameConfiguration;
    private TenantWebAuthnConfiguration webAuthnConfiguration;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder accessControlConfiguration(TenantAccessControlConfiguration accessControlConfiguration) { this.accessControlConfiguration = accessControlConfiguration; return this; }
    public Builder captchaConfiguration(TenantCaptchaConfiguration captchaConfiguration) { this.captchaConfiguration = captchaConfiguration; return this; }
    public Builder configured(Boolean configured) { this.configured = configured; return this; }
    public Builder connectorPolicies(List<ConnectorPolicy> connectorPolicies) { this.connectorPolicies = connectorPolicies; return this; }
    public Builder emailConfiguration(EmailConfiguration emailConfiguration) { this.emailConfiguration = emailConfiguration; return this; }
    public Builder eventConfiguration(EventConfiguration eventConfiguration) { this.eventConfiguration = eventConfiguration; return this; }
    public Builder externalIdentifierConfiguration(ExternalIdentifierConfiguration externalIdentifierConfiguration) { this.externalIdentifierConfiguration = externalIdentifierConfiguration; return this; }
    public Builder failedAuthenticationConfiguration(FailedAuthenticationConfiguration failedAuthenticationConfiguration) { this.failedAuthenticationConfiguration = failedAuthenticationConfiguration; return this; }
    public Builder familyConfiguration(FamilyConfiguration familyConfiguration) { this.familyConfiguration = familyConfiguration; return this; }
    public Builder formConfiguration(TenantFormConfiguration formConfiguration) { this.formConfiguration = formConfiguration; return this; }
    public Builder httpSessionMaxInactiveInterval(Integer httpSessionMaxInactiveInterval) { this.httpSessionMaxInactiveInterval = httpSessionMaxInactiveInterval; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder jwtConfiguration(JWTConfiguration jwtConfiguration) { this.jwtConfiguration = jwtConfiguration; return this; }
    public Builder lambdaConfiguration(TenantLambdaConfiguration lambdaConfiguration) { this.lambdaConfiguration = lambdaConfiguration; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder loginConfiguration(TenantLoginConfiguration loginConfiguration) { this.loginConfiguration = loginConfiguration; return this; }
    public Builder logoutURL(String logoutURL) { this.logoutURL = logoutURL; return this; }
    public Builder maximumPasswordAge(MaximumPasswordAge maximumPasswordAge) { this.maximumPasswordAge = maximumPasswordAge; return this; }
    public Builder minimumPasswordAge(MinimumPasswordAge minimumPasswordAge) { this.minimumPasswordAge = minimumPasswordAge; return this; }
    public Builder multiFactorConfiguration(TenantMultiFactorConfiguration multiFactorConfiguration) { this.multiFactorConfiguration = multiFactorConfiguration; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder oauthConfiguration(TenantOAuth2Configuration oauthConfiguration) { this.oauthConfiguration = oauthConfiguration; return this; }
    public Builder passwordEncryptionConfiguration(PasswordEncryptionConfiguration passwordEncryptionConfiguration) { this.passwordEncryptionConfiguration = passwordEncryptionConfiguration; return this; }
    public Builder passwordValidationRules(PasswordValidationRules passwordValidationRules) { this.passwordValidationRules = passwordValidationRules; return this; }
    public Builder phoneConfiguration(TenantPhoneConfiguration phoneConfiguration) { this.phoneConfiguration = phoneConfiguration; return this; }
    public Builder rateLimitConfiguration(TenantRateLimitConfiguration rateLimitConfiguration) { this.rateLimitConfiguration = rateLimitConfiguration; return this; }
    public Builder registrationConfiguration(TenantRegistrationConfiguration registrationConfiguration) { this.registrationConfiguration = registrationConfiguration; return this; }
    public Builder scimServerConfiguration(TenantSCIMServerConfiguration scimServerConfiguration) { this.scimServerConfiguration = scimServerConfiguration; return this; }
    public Builder ssoConfiguration(TenantSSOConfiguration ssoConfiguration) { this.ssoConfiguration = ssoConfiguration; return this; }
    public Builder state(ObjectState state) { this.state = state; return this; }
    public Builder themeId(UUID themeId) { this.themeId = themeId; return this; }
    public Builder userDeletePolicy(TenantUserDeletePolicy userDeletePolicy) { this.userDeletePolicy = userDeletePolicy; return this; }
    public Builder usernameConfiguration(TenantUsernameConfiguration usernameConfiguration) { this.usernameConfiguration = usernameConfiguration; return this; }
    public Builder webAuthnConfiguration(TenantWebAuthnConfiguration webAuthnConfiguration) { this.webAuthnConfiguration = webAuthnConfiguration; return this; }
    public Tenant build() { return new Tenant(data, accessControlConfiguration, captchaConfiguration, configured, connectorPolicies, emailConfiguration, eventConfiguration, externalIdentifierConfiguration, failedAuthenticationConfiguration, familyConfiguration, formConfiguration, httpSessionMaxInactiveInterval, id, insertInstant, issuer, jwtConfiguration, lambdaConfiguration, lastUpdateInstant, loginConfiguration, logoutURL, maximumPasswordAge, minimumPasswordAge, multiFactorConfiguration, name, oauthConfiguration, passwordEncryptionConfiguration, passwordValidationRules, phoneConfiguration, rateLimitConfiguration, registrationConfiguration, scimServerConfiguration, ssoConfiguration, state, themeId, userDeletePolicy, usernameConfiguration, webAuthnConfiguration); }
  }
}
