/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailConfigurationJSON;

@JSON
public record EmailConfiguration(
    List<EmailHeader> additionalHeaders,
    Boolean debug,
    String defaultFromEmail,
    String defaultFromName,
    UUID emailUpdateEmailTemplateId,
    UUID emailVerifiedEmailTemplateId,
    UUID forgotPasswordEmailTemplateId,
    String host,
    Boolean implicitEmailVerificationAllowed,
    UUID loginIdInUseOnCreateEmailTemplateId,
    UUID loginIdInUseOnUpdateEmailTemplateId,
    UUID loginNewDeviceEmailTemplateId,
    UUID loginSuspiciousEmailTemplateId,
    String password,
    UUID passwordResetSuccessEmailTemplateId,
    UUID passwordUpdateEmailTemplateId,
    UUID passwordlessEmailTemplateId,
    Integer port,
    String properties,
    EmailSecurityType security,
    UUID setPasswordEmailTemplateId,
    UUID twoFactorMethodAddEmailTemplateId,
    UUID twoFactorMethodRemoveEmailTemplateId,
    EmailUnverifiedOptions unverified,
    String username,
    UUID verificationEmailTemplateId,
    VerificationStrategy verificationStrategy,
    Boolean verifyEmail,
    Boolean verifyEmailWhenChanged) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EmailConfigurationJSON.toJSONBytes(this);
  }

  public static EmailConfiguration fromJSON(String json) {
    return EmailConfigurationJSON.fromJSON(json);
  }

  public static EmailConfiguration fromJSONBytes(byte[] json) {
    return EmailConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<EmailHeader> additionalHeaders;
    private Boolean debug;
    private String defaultFromEmail;
    private String defaultFromName;
    private UUID emailUpdateEmailTemplateId;
    private UUID emailVerifiedEmailTemplateId;
    private UUID forgotPasswordEmailTemplateId;
    private String host;
    private Boolean implicitEmailVerificationAllowed;
    private UUID loginIdInUseOnCreateEmailTemplateId;
    private UUID loginIdInUseOnUpdateEmailTemplateId;
    private UUID loginNewDeviceEmailTemplateId;
    private UUID loginSuspiciousEmailTemplateId;
    private String password;
    private UUID passwordResetSuccessEmailTemplateId;
    private UUID passwordUpdateEmailTemplateId;
    private UUID passwordlessEmailTemplateId;
    private Integer port;
    private String properties;
    private EmailSecurityType security;
    private UUID setPasswordEmailTemplateId;
    private UUID twoFactorMethodAddEmailTemplateId;
    private UUID twoFactorMethodRemoveEmailTemplateId;
    private EmailUnverifiedOptions unverified;
    private String username;
    private UUID verificationEmailTemplateId;
    private VerificationStrategy verificationStrategy;
    private Boolean verifyEmail;
    private Boolean verifyEmailWhenChanged;
    public Builder additionalHeaders(List<EmailHeader> additionalHeaders) { this.additionalHeaders = additionalHeaders; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder defaultFromEmail(String defaultFromEmail) { this.defaultFromEmail = defaultFromEmail; return this; }
    public Builder defaultFromName(String defaultFromName) { this.defaultFromName = defaultFromName; return this; }
    public Builder emailUpdateEmailTemplateId(UUID emailUpdateEmailTemplateId) { this.emailUpdateEmailTemplateId = emailUpdateEmailTemplateId; return this; }
    public Builder emailVerifiedEmailTemplateId(UUID emailVerifiedEmailTemplateId) { this.emailVerifiedEmailTemplateId = emailVerifiedEmailTemplateId; return this; }
    public Builder forgotPasswordEmailTemplateId(UUID forgotPasswordEmailTemplateId) { this.forgotPasswordEmailTemplateId = forgotPasswordEmailTemplateId; return this; }
    public Builder host(String host) { this.host = host; return this; }
    public Builder implicitEmailVerificationAllowed(Boolean implicitEmailVerificationAllowed) { this.implicitEmailVerificationAllowed = implicitEmailVerificationAllowed; return this; }
    public Builder loginIdInUseOnCreateEmailTemplateId(UUID loginIdInUseOnCreateEmailTemplateId) { this.loginIdInUseOnCreateEmailTemplateId = loginIdInUseOnCreateEmailTemplateId; return this; }
    public Builder loginIdInUseOnUpdateEmailTemplateId(UUID loginIdInUseOnUpdateEmailTemplateId) { this.loginIdInUseOnUpdateEmailTemplateId = loginIdInUseOnUpdateEmailTemplateId; return this; }
    public Builder loginNewDeviceEmailTemplateId(UUID loginNewDeviceEmailTemplateId) { this.loginNewDeviceEmailTemplateId = loginNewDeviceEmailTemplateId; return this; }
    public Builder loginSuspiciousEmailTemplateId(UUID loginSuspiciousEmailTemplateId) { this.loginSuspiciousEmailTemplateId = loginSuspiciousEmailTemplateId; return this; }
    public Builder password(String password) { this.password = password; return this; }
    public Builder passwordResetSuccessEmailTemplateId(UUID passwordResetSuccessEmailTemplateId) { this.passwordResetSuccessEmailTemplateId = passwordResetSuccessEmailTemplateId; return this; }
    public Builder passwordUpdateEmailTemplateId(UUID passwordUpdateEmailTemplateId) { this.passwordUpdateEmailTemplateId = passwordUpdateEmailTemplateId; return this; }
    public Builder passwordlessEmailTemplateId(UUID passwordlessEmailTemplateId) { this.passwordlessEmailTemplateId = passwordlessEmailTemplateId; return this; }
    public Builder port(Integer port) { this.port = port; return this; }
    public Builder properties(String properties) { this.properties = properties; return this; }
    public Builder security(EmailSecurityType security) { this.security = security; return this; }
    public Builder setPasswordEmailTemplateId(UUID setPasswordEmailTemplateId) { this.setPasswordEmailTemplateId = setPasswordEmailTemplateId; return this; }
    public Builder twoFactorMethodAddEmailTemplateId(UUID twoFactorMethodAddEmailTemplateId) { this.twoFactorMethodAddEmailTemplateId = twoFactorMethodAddEmailTemplateId; return this; }
    public Builder twoFactorMethodRemoveEmailTemplateId(UUID twoFactorMethodRemoveEmailTemplateId) { this.twoFactorMethodRemoveEmailTemplateId = twoFactorMethodRemoveEmailTemplateId; return this; }
    public Builder unverified(EmailUnverifiedOptions unverified) { this.unverified = unverified; return this; }
    public Builder username(String username) { this.username = username; return this; }
    public Builder verificationEmailTemplateId(UUID verificationEmailTemplateId) { this.verificationEmailTemplateId = verificationEmailTemplateId; return this; }
    public Builder verificationStrategy(VerificationStrategy verificationStrategy) { this.verificationStrategy = verificationStrategy; return this; }
    public Builder verifyEmail(Boolean verifyEmail) { this.verifyEmail = verifyEmail; return this; }
    public Builder verifyEmailWhenChanged(Boolean verifyEmailWhenChanged) { this.verifyEmailWhenChanged = verifyEmailWhenChanged; return this; }
    public EmailConfiguration build() { return new EmailConfiguration(additionalHeaders, debug, defaultFromEmail, defaultFromName, emailUpdateEmailTemplateId, emailVerifiedEmailTemplateId, forgotPasswordEmailTemplateId, host, implicitEmailVerificationAllowed, loginIdInUseOnCreateEmailTemplateId, loginIdInUseOnUpdateEmailTemplateId, loginNewDeviceEmailTemplateId, loginSuspiciousEmailTemplateId, password, passwordResetSuccessEmailTemplateId, passwordUpdateEmailTemplateId, passwordlessEmailTemplateId, port, properties, security, setPasswordEmailTemplateId, twoFactorMethodAddEmailTemplateId, twoFactorMethodRemoveEmailTemplateId, unverified, username, verificationEmailTemplateId, verificationStrategy, verifyEmail, verifyEmailWhenChanged); }
  }
}
