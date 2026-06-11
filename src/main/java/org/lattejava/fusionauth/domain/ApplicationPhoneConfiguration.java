/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationPhoneConfigurationJSON;

@JSON
public record ApplicationPhoneConfiguration(
    UUID forgotPasswordTemplateId,
    UUID identityUpdateTemplateId,
    UUID loginIdInUseOnCreateTemplateId,
    UUID loginIdInUseOnUpdateTemplateId,
    UUID loginNewDeviceTemplateId,
    UUID loginSuspiciousTemplateId,
    UUID passwordResetSuccessTemplateId,
    UUID passwordUpdateTemplateId,
    UUID passwordlessTemplateId,
    UUID setPasswordTemplateId,
    UUID twoFactorMethodAddTemplateId,
    UUID twoFactorMethodRemoveTemplateId,
    UUID verificationCompleteTemplateId,
    UUID verificationTemplateId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationPhoneConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationPhoneConfigurationJSON.toJSONBytes(this);
  }

  public static ApplicationPhoneConfiguration fromJSON(String json) {
    return ApplicationPhoneConfigurationJSON.fromJSON(json);
  }

  public static ApplicationPhoneConfiguration fromJSONBytes(byte[] json) {
    return ApplicationPhoneConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID forgotPasswordTemplateId;
    private UUID identityUpdateTemplateId;
    private UUID loginIdInUseOnCreateTemplateId;
    private UUID loginIdInUseOnUpdateTemplateId;
    private UUID loginNewDeviceTemplateId;
    private UUID loginSuspiciousTemplateId;
    private UUID passwordResetSuccessTemplateId;
    private UUID passwordUpdateTemplateId;
    private UUID passwordlessTemplateId;
    private UUID setPasswordTemplateId;
    private UUID twoFactorMethodAddTemplateId;
    private UUID twoFactorMethodRemoveTemplateId;
    private UUID verificationCompleteTemplateId;
    private UUID verificationTemplateId;
    public Builder forgotPasswordTemplateId(UUID forgotPasswordTemplateId) { this.forgotPasswordTemplateId = forgotPasswordTemplateId; return this; }
    public Builder identityUpdateTemplateId(UUID identityUpdateTemplateId) { this.identityUpdateTemplateId = identityUpdateTemplateId; return this; }
    public Builder loginIdInUseOnCreateTemplateId(UUID loginIdInUseOnCreateTemplateId) { this.loginIdInUseOnCreateTemplateId = loginIdInUseOnCreateTemplateId; return this; }
    public Builder loginIdInUseOnUpdateTemplateId(UUID loginIdInUseOnUpdateTemplateId) { this.loginIdInUseOnUpdateTemplateId = loginIdInUseOnUpdateTemplateId; return this; }
    public Builder loginNewDeviceTemplateId(UUID loginNewDeviceTemplateId) { this.loginNewDeviceTemplateId = loginNewDeviceTemplateId; return this; }
    public Builder loginSuspiciousTemplateId(UUID loginSuspiciousTemplateId) { this.loginSuspiciousTemplateId = loginSuspiciousTemplateId; return this; }
    public Builder passwordResetSuccessTemplateId(UUID passwordResetSuccessTemplateId) { this.passwordResetSuccessTemplateId = passwordResetSuccessTemplateId; return this; }
    public Builder passwordUpdateTemplateId(UUID passwordUpdateTemplateId) { this.passwordUpdateTemplateId = passwordUpdateTemplateId; return this; }
    public Builder passwordlessTemplateId(UUID passwordlessTemplateId) { this.passwordlessTemplateId = passwordlessTemplateId; return this; }
    public Builder setPasswordTemplateId(UUID setPasswordTemplateId) { this.setPasswordTemplateId = setPasswordTemplateId; return this; }
    public Builder twoFactorMethodAddTemplateId(UUID twoFactorMethodAddTemplateId) { this.twoFactorMethodAddTemplateId = twoFactorMethodAddTemplateId; return this; }
    public Builder twoFactorMethodRemoveTemplateId(UUID twoFactorMethodRemoveTemplateId) { this.twoFactorMethodRemoveTemplateId = twoFactorMethodRemoveTemplateId; return this; }
    public Builder verificationCompleteTemplateId(UUID verificationCompleteTemplateId) { this.verificationCompleteTemplateId = verificationCompleteTemplateId; return this; }
    public Builder verificationTemplateId(UUID verificationTemplateId) { this.verificationTemplateId = verificationTemplateId; return this; }
    public ApplicationPhoneConfiguration build() { return new ApplicationPhoneConfiguration(forgotPasswordTemplateId, identityUpdateTemplateId, loginIdInUseOnCreateTemplateId, loginIdInUseOnUpdateTemplateId, loginNewDeviceTemplateId, loginSuspiciousTemplateId, passwordResetSuccessTemplateId, passwordUpdateTemplateId, passwordlessTemplateId, setPasswordTemplateId, twoFactorMethodAddTemplateId, twoFactorMethodRemoveTemplateId, verificationCompleteTemplateId, verificationTemplateId); }
  }
}
