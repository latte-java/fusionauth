/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ExternalIdentifierConfigurationJSON;

@JSON
public record ExternalIdentifierConfiguration(
    Integer authorizationGrantIdTimeToLiveInSeconds,
    SecureGeneratorConfiguration changePasswordIdGenerator,
    Integer changePasswordIdTimeToLiveInSeconds,
    Integer deviceCodeTimeToLiveInSeconds,
    SecureGeneratorConfiguration deviceUserCodeIdGenerator,
    SecureGeneratorConfiguration emailVerificationIdGenerator,
    Integer emailVerificationIdTimeToLiveInSeconds,
    SecureGeneratorConfiguration emailVerificationOneTimeCodeGenerator,
    Integer externalAuthenticationIdTimeToLiveInSeconds,
    Integer identityProviderConnectionTestTimeToLiveInSeconds,
    Integer loginIntentTimeToLiveInSeconds,
    Integer oneTimePasswordTimeToLiveInSeconds,
    SecureGeneratorConfiguration passwordlessLoginGenerator,
    SecureGeneratorConfiguration passwordlessLoginOneTimeCodeGenerator,
    Integer passwordlessLoginTimeToLiveInSeconds,
    Integer pendingAccountLinkTimeToLiveInSeconds,
    SecureGeneratorConfiguration phoneVerificationIdGenerator,
    Integer phoneVerificationIdTimeToLiveInSeconds,
    SecureGeneratorConfiguration phoneVerificationOneTimeCodeGenerator,
    SecureGeneratorConfiguration registrationVerificationIdGenerator,
    Integer registrationVerificationIdTimeToLiveInSeconds,
    SecureGeneratorConfiguration registrationVerificationOneTimeCodeGenerator,
    Integer rememberOAuthScopeConsentChoiceTimeToLiveInSeconds,
    Integer samlv2AuthNRequestIdTimeToLiveInSeconds,
    SecureGeneratorConfiguration setupPasswordIdGenerator,
    Integer setupPasswordIdTimeToLiveInSeconds,
    Integer trustTokenTimeToLiveInSeconds,
    Integer twoFactorIdTimeToLiveInSeconds,
    SecureGeneratorConfiguration twoFactorOneTimeCodeIdGenerator,
    Integer twoFactorOneTimeCodeIdTimeToLiveInSeconds,
    Integer twoFactorTrustIdTimeToLiveInSeconds,
    Integer webAuthnAuthenticationChallengeTimeToLiveInSeconds,
    Integer webAuthnRegistrationChallengeTimeToLiveInSeconds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ExternalIdentifierConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ExternalIdentifierConfigurationJSON.toJSONBytes(this);
  }
  
  public static ExternalIdentifierConfiguration fromJSON(String json) {
    return ExternalIdentifierConfigurationJSON.fromJSON(json);
  }
  
  public static ExternalIdentifierConfiguration fromJSONBytes(byte[] json) {
    return ExternalIdentifierConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer authorizationGrantIdTimeToLiveInSeconds;
    private SecureGeneratorConfiguration changePasswordIdGenerator;
    private Integer changePasswordIdTimeToLiveInSeconds;
    private Integer deviceCodeTimeToLiveInSeconds;
    private SecureGeneratorConfiguration deviceUserCodeIdGenerator;
    private SecureGeneratorConfiguration emailVerificationIdGenerator;
    private Integer emailVerificationIdTimeToLiveInSeconds;
    private SecureGeneratorConfiguration emailVerificationOneTimeCodeGenerator;
    private Integer externalAuthenticationIdTimeToLiveInSeconds;
    private Integer identityProviderConnectionTestTimeToLiveInSeconds;
    private Integer loginIntentTimeToLiveInSeconds;
    private Integer oneTimePasswordTimeToLiveInSeconds;
    private SecureGeneratorConfiguration passwordlessLoginGenerator;
    private SecureGeneratorConfiguration passwordlessLoginOneTimeCodeGenerator;
    private Integer passwordlessLoginTimeToLiveInSeconds;
    private Integer pendingAccountLinkTimeToLiveInSeconds;
    private SecureGeneratorConfiguration phoneVerificationIdGenerator;
    private Integer phoneVerificationIdTimeToLiveInSeconds;
    private SecureGeneratorConfiguration phoneVerificationOneTimeCodeGenerator;
    private SecureGeneratorConfiguration registrationVerificationIdGenerator;
    private Integer registrationVerificationIdTimeToLiveInSeconds;
    private SecureGeneratorConfiguration registrationVerificationOneTimeCodeGenerator;
    private Integer rememberOAuthScopeConsentChoiceTimeToLiveInSeconds;
    private Integer samlv2AuthNRequestIdTimeToLiveInSeconds;
    private SecureGeneratorConfiguration setupPasswordIdGenerator;
    private Integer setupPasswordIdTimeToLiveInSeconds;
    private Integer trustTokenTimeToLiveInSeconds;
    private Integer twoFactorIdTimeToLiveInSeconds;
    private SecureGeneratorConfiguration twoFactorOneTimeCodeIdGenerator;
    private Integer twoFactorOneTimeCodeIdTimeToLiveInSeconds;
    private Integer twoFactorTrustIdTimeToLiveInSeconds;
    private Integer webAuthnAuthenticationChallengeTimeToLiveInSeconds;
    private Integer webAuthnRegistrationChallengeTimeToLiveInSeconds;
    public Builder authorizationGrantIdTimeToLiveInSeconds(Integer authorizationGrantIdTimeToLiveInSeconds) { this.authorizationGrantIdTimeToLiveInSeconds = authorizationGrantIdTimeToLiveInSeconds; return this; }
    public Builder changePasswordIdGenerator(SecureGeneratorConfiguration changePasswordIdGenerator) { this.changePasswordIdGenerator = changePasswordIdGenerator; return this; }
    public Builder changePasswordIdTimeToLiveInSeconds(Integer changePasswordIdTimeToLiveInSeconds) { this.changePasswordIdTimeToLiveInSeconds = changePasswordIdTimeToLiveInSeconds; return this; }
    public Builder deviceCodeTimeToLiveInSeconds(Integer deviceCodeTimeToLiveInSeconds) { this.deviceCodeTimeToLiveInSeconds = deviceCodeTimeToLiveInSeconds; return this; }
    public Builder deviceUserCodeIdGenerator(SecureGeneratorConfiguration deviceUserCodeIdGenerator) { this.deviceUserCodeIdGenerator = deviceUserCodeIdGenerator; return this; }
    public Builder emailVerificationIdGenerator(SecureGeneratorConfiguration emailVerificationIdGenerator) { this.emailVerificationIdGenerator = emailVerificationIdGenerator; return this; }
    public Builder emailVerificationIdTimeToLiveInSeconds(Integer emailVerificationIdTimeToLiveInSeconds) { this.emailVerificationIdTimeToLiveInSeconds = emailVerificationIdTimeToLiveInSeconds; return this; }
    public Builder emailVerificationOneTimeCodeGenerator(SecureGeneratorConfiguration emailVerificationOneTimeCodeGenerator) { this.emailVerificationOneTimeCodeGenerator = emailVerificationOneTimeCodeGenerator; return this; }
    public Builder externalAuthenticationIdTimeToLiveInSeconds(Integer externalAuthenticationIdTimeToLiveInSeconds) { this.externalAuthenticationIdTimeToLiveInSeconds = externalAuthenticationIdTimeToLiveInSeconds; return this; }
    public Builder identityProviderConnectionTestTimeToLiveInSeconds(Integer identityProviderConnectionTestTimeToLiveInSeconds) { this.identityProviderConnectionTestTimeToLiveInSeconds = identityProviderConnectionTestTimeToLiveInSeconds; return this; }
    public Builder loginIntentTimeToLiveInSeconds(Integer loginIntentTimeToLiveInSeconds) { this.loginIntentTimeToLiveInSeconds = loginIntentTimeToLiveInSeconds; return this; }
    public Builder oneTimePasswordTimeToLiveInSeconds(Integer oneTimePasswordTimeToLiveInSeconds) { this.oneTimePasswordTimeToLiveInSeconds = oneTimePasswordTimeToLiveInSeconds; return this; }
    public Builder passwordlessLoginGenerator(SecureGeneratorConfiguration passwordlessLoginGenerator) { this.passwordlessLoginGenerator = passwordlessLoginGenerator; return this; }
    public Builder passwordlessLoginOneTimeCodeGenerator(SecureGeneratorConfiguration passwordlessLoginOneTimeCodeGenerator) { this.passwordlessLoginOneTimeCodeGenerator = passwordlessLoginOneTimeCodeGenerator; return this; }
    public Builder passwordlessLoginTimeToLiveInSeconds(Integer passwordlessLoginTimeToLiveInSeconds) { this.passwordlessLoginTimeToLiveInSeconds = passwordlessLoginTimeToLiveInSeconds; return this; }
    public Builder pendingAccountLinkTimeToLiveInSeconds(Integer pendingAccountLinkTimeToLiveInSeconds) { this.pendingAccountLinkTimeToLiveInSeconds = pendingAccountLinkTimeToLiveInSeconds; return this; }
    public Builder phoneVerificationIdGenerator(SecureGeneratorConfiguration phoneVerificationIdGenerator) { this.phoneVerificationIdGenerator = phoneVerificationIdGenerator; return this; }
    public Builder phoneVerificationIdTimeToLiveInSeconds(Integer phoneVerificationIdTimeToLiveInSeconds) { this.phoneVerificationIdTimeToLiveInSeconds = phoneVerificationIdTimeToLiveInSeconds; return this; }
    public Builder phoneVerificationOneTimeCodeGenerator(SecureGeneratorConfiguration phoneVerificationOneTimeCodeGenerator) { this.phoneVerificationOneTimeCodeGenerator = phoneVerificationOneTimeCodeGenerator; return this; }
    public Builder registrationVerificationIdGenerator(SecureGeneratorConfiguration registrationVerificationIdGenerator) { this.registrationVerificationIdGenerator = registrationVerificationIdGenerator; return this; }
    public Builder registrationVerificationIdTimeToLiveInSeconds(Integer registrationVerificationIdTimeToLiveInSeconds) { this.registrationVerificationIdTimeToLiveInSeconds = registrationVerificationIdTimeToLiveInSeconds; return this; }
    public Builder registrationVerificationOneTimeCodeGenerator(SecureGeneratorConfiguration registrationVerificationOneTimeCodeGenerator) { this.registrationVerificationOneTimeCodeGenerator = registrationVerificationOneTimeCodeGenerator; return this; }
    public Builder rememberOAuthScopeConsentChoiceTimeToLiveInSeconds(Integer rememberOAuthScopeConsentChoiceTimeToLiveInSeconds) { this.rememberOAuthScopeConsentChoiceTimeToLiveInSeconds = rememberOAuthScopeConsentChoiceTimeToLiveInSeconds; return this; }
    public Builder samlv2AuthNRequestIdTimeToLiveInSeconds(Integer samlv2AuthNRequestIdTimeToLiveInSeconds) { this.samlv2AuthNRequestIdTimeToLiveInSeconds = samlv2AuthNRequestIdTimeToLiveInSeconds; return this; }
    public Builder setupPasswordIdGenerator(SecureGeneratorConfiguration setupPasswordIdGenerator) { this.setupPasswordIdGenerator = setupPasswordIdGenerator; return this; }
    public Builder setupPasswordIdTimeToLiveInSeconds(Integer setupPasswordIdTimeToLiveInSeconds) { this.setupPasswordIdTimeToLiveInSeconds = setupPasswordIdTimeToLiveInSeconds; return this; }
    public Builder trustTokenTimeToLiveInSeconds(Integer trustTokenTimeToLiveInSeconds) { this.trustTokenTimeToLiveInSeconds = trustTokenTimeToLiveInSeconds; return this; }
    public Builder twoFactorIdTimeToLiveInSeconds(Integer twoFactorIdTimeToLiveInSeconds) { this.twoFactorIdTimeToLiveInSeconds = twoFactorIdTimeToLiveInSeconds; return this; }
    public Builder twoFactorOneTimeCodeIdGenerator(SecureGeneratorConfiguration twoFactorOneTimeCodeIdGenerator) { this.twoFactorOneTimeCodeIdGenerator = twoFactorOneTimeCodeIdGenerator; return this; }
    public Builder twoFactorOneTimeCodeIdTimeToLiveInSeconds(Integer twoFactorOneTimeCodeIdTimeToLiveInSeconds) { this.twoFactorOneTimeCodeIdTimeToLiveInSeconds = twoFactorOneTimeCodeIdTimeToLiveInSeconds; return this; }
    public Builder twoFactorTrustIdTimeToLiveInSeconds(Integer twoFactorTrustIdTimeToLiveInSeconds) { this.twoFactorTrustIdTimeToLiveInSeconds = twoFactorTrustIdTimeToLiveInSeconds; return this; }
    public Builder webAuthnAuthenticationChallengeTimeToLiveInSeconds(Integer webAuthnAuthenticationChallengeTimeToLiveInSeconds) { this.webAuthnAuthenticationChallengeTimeToLiveInSeconds = webAuthnAuthenticationChallengeTimeToLiveInSeconds; return this; }
    public Builder webAuthnRegistrationChallengeTimeToLiveInSeconds(Integer webAuthnRegistrationChallengeTimeToLiveInSeconds) { this.webAuthnRegistrationChallengeTimeToLiveInSeconds = webAuthnRegistrationChallengeTimeToLiveInSeconds; return this; }
    public ExternalIdentifierConfiguration build() { return new ExternalIdentifierConfiguration(authorizationGrantIdTimeToLiveInSeconds, changePasswordIdGenerator, changePasswordIdTimeToLiveInSeconds, deviceCodeTimeToLiveInSeconds, deviceUserCodeIdGenerator, emailVerificationIdGenerator, emailVerificationIdTimeToLiveInSeconds, emailVerificationOneTimeCodeGenerator, externalAuthenticationIdTimeToLiveInSeconds, identityProviderConnectionTestTimeToLiveInSeconds, loginIntentTimeToLiveInSeconds, oneTimePasswordTimeToLiveInSeconds, passwordlessLoginGenerator, passwordlessLoginOneTimeCodeGenerator, passwordlessLoginTimeToLiveInSeconds, pendingAccountLinkTimeToLiveInSeconds, phoneVerificationIdGenerator, phoneVerificationIdTimeToLiveInSeconds, phoneVerificationOneTimeCodeGenerator, registrationVerificationIdGenerator, registrationVerificationIdTimeToLiveInSeconds, registrationVerificationOneTimeCodeGenerator, rememberOAuthScopeConsentChoiceTimeToLiveInSeconds, samlv2AuthNRequestIdTimeToLiveInSeconds, setupPasswordIdGenerator, setupPasswordIdTimeToLiveInSeconds, trustTokenTimeToLiveInSeconds, twoFactorIdTimeToLiveInSeconds, twoFactorOneTimeCodeIdGenerator, twoFactorOneTimeCodeIdTimeToLiveInSeconds, twoFactorTrustIdTimeToLiveInSeconds, webAuthnAuthenticationChallengeTimeToLiveInSeconds, webAuthnRegistrationChallengeTimeToLiveInSeconds); }
  }
}
