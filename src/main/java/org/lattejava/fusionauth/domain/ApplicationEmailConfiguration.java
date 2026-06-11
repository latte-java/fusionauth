/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationEmailConfigurationJSON;

@JSON
public record ApplicationEmailConfiguration(
    UUID emailUpdateEmailTemplateId,
    UUID emailVerificationEmailTemplateId,
    UUID emailVerifiedEmailTemplateId,
    UUID forgotPasswordEmailTemplateId,
    UUID loginIdInUseOnCreateEmailTemplateId,
    UUID loginIdInUseOnUpdateEmailTemplateId,
    UUID loginNewDeviceEmailTemplateId,
    UUID loginSuspiciousEmailTemplateId,
    UUID passwordResetSuccessEmailTemplateId,
    UUID passwordUpdateEmailTemplateId,
    UUID passwordlessEmailTemplateId,
    UUID setPasswordEmailTemplateId,
    UUID twoFactorMethodAddEmailTemplateId,
    UUID twoFactorMethodRemoveEmailTemplateId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationEmailConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationEmailConfigurationJSON.toJSONBytes(this);
  }

  public static ApplicationEmailConfiguration fromJSON(String json) {
    return ApplicationEmailConfigurationJSON.fromJSON(json);
  }

  public static ApplicationEmailConfiguration fromJSONBytes(byte[] json) {
    return ApplicationEmailConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID emailUpdateEmailTemplateId;
    private UUID emailVerificationEmailTemplateId;
    private UUID emailVerifiedEmailTemplateId;
    private UUID forgotPasswordEmailTemplateId;
    private UUID loginIdInUseOnCreateEmailTemplateId;
    private UUID loginIdInUseOnUpdateEmailTemplateId;
    private UUID loginNewDeviceEmailTemplateId;
    private UUID loginSuspiciousEmailTemplateId;
    private UUID passwordResetSuccessEmailTemplateId;
    private UUID passwordUpdateEmailTemplateId;
    private UUID passwordlessEmailTemplateId;
    private UUID setPasswordEmailTemplateId;
    private UUID twoFactorMethodAddEmailTemplateId;
    private UUID twoFactorMethodRemoveEmailTemplateId;
    public Builder emailUpdateEmailTemplateId(UUID emailUpdateEmailTemplateId) { this.emailUpdateEmailTemplateId = emailUpdateEmailTemplateId; return this; }
    public Builder emailVerificationEmailTemplateId(UUID emailVerificationEmailTemplateId) { this.emailVerificationEmailTemplateId = emailVerificationEmailTemplateId; return this; }
    public Builder emailVerifiedEmailTemplateId(UUID emailVerifiedEmailTemplateId) { this.emailVerifiedEmailTemplateId = emailVerifiedEmailTemplateId; return this; }
    public Builder forgotPasswordEmailTemplateId(UUID forgotPasswordEmailTemplateId) { this.forgotPasswordEmailTemplateId = forgotPasswordEmailTemplateId; return this; }
    public Builder loginIdInUseOnCreateEmailTemplateId(UUID loginIdInUseOnCreateEmailTemplateId) { this.loginIdInUseOnCreateEmailTemplateId = loginIdInUseOnCreateEmailTemplateId; return this; }
    public Builder loginIdInUseOnUpdateEmailTemplateId(UUID loginIdInUseOnUpdateEmailTemplateId) { this.loginIdInUseOnUpdateEmailTemplateId = loginIdInUseOnUpdateEmailTemplateId; return this; }
    public Builder loginNewDeviceEmailTemplateId(UUID loginNewDeviceEmailTemplateId) { this.loginNewDeviceEmailTemplateId = loginNewDeviceEmailTemplateId; return this; }
    public Builder loginSuspiciousEmailTemplateId(UUID loginSuspiciousEmailTemplateId) { this.loginSuspiciousEmailTemplateId = loginSuspiciousEmailTemplateId; return this; }
    public Builder passwordResetSuccessEmailTemplateId(UUID passwordResetSuccessEmailTemplateId) { this.passwordResetSuccessEmailTemplateId = passwordResetSuccessEmailTemplateId; return this; }
    public Builder passwordUpdateEmailTemplateId(UUID passwordUpdateEmailTemplateId) { this.passwordUpdateEmailTemplateId = passwordUpdateEmailTemplateId; return this; }
    public Builder passwordlessEmailTemplateId(UUID passwordlessEmailTemplateId) { this.passwordlessEmailTemplateId = passwordlessEmailTemplateId; return this; }
    public Builder setPasswordEmailTemplateId(UUID setPasswordEmailTemplateId) { this.setPasswordEmailTemplateId = setPasswordEmailTemplateId; return this; }
    public Builder twoFactorMethodAddEmailTemplateId(UUID twoFactorMethodAddEmailTemplateId) { this.twoFactorMethodAddEmailTemplateId = twoFactorMethodAddEmailTemplateId; return this; }
    public Builder twoFactorMethodRemoveEmailTemplateId(UUID twoFactorMethodRemoveEmailTemplateId) { this.twoFactorMethodRemoveEmailTemplateId = twoFactorMethodRemoveEmailTemplateId; return this; }
    public ApplicationEmailConfiguration build() { return new ApplicationEmailConfiguration(emailUpdateEmailTemplateId, emailVerificationEmailTemplateId, emailVerifiedEmailTemplateId, forgotPasswordEmailTemplateId, loginIdInUseOnCreateEmailTemplateId, loginIdInUseOnUpdateEmailTemplateId, loginNewDeviceEmailTemplateId, loginSuspiciousEmailTemplateId, passwordResetSuccessEmailTemplateId, passwordUpdateEmailTemplateId, passwordlessEmailTemplateId, setPasswordEmailTemplateId, twoFactorMethodAddEmailTemplateId, twoFactorMethodRemoveEmailTemplateId); }
  }
}
