/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantPhoneConfigurationJSON;

@JSON
public record TenantPhoneConfiguration(
    UUID forgotPasswordTemplateId,
    UUID identityUpdateTemplateId,
    Boolean implicitPhoneVerificationAllowed,
    UUID loginIdInUseOnCreateTemplateId,
    UUID loginIdInUseOnUpdateTemplateId,
    UUID loginNewDeviceTemplateId,
    UUID loginSuspiciousTemplateId,
    UUID messengerId,
    UUID passwordResetSuccessTemplateId,
    UUID passwordUpdateTemplateId,
    UUID passwordlessTemplateId,
    UUID setPasswordTemplateId,
    UUID twoFactorMethodAddTemplateId,
    UUID twoFactorMethodRemoveTemplateId,
    PhoneUnverifiedOptions unverified,
    UUID verificationCompleteTemplateId,
    VerificationStrategy verificationStrategy,
    UUID verificationTemplateId,
    Boolean verifyPhoneNumber) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantPhoneConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantPhoneConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantPhoneConfiguration fromJSON(String json) {
    return TenantPhoneConfigurationJSON.fromJSON(json);
  }
  
  public static TenantPhoneConfiguration fromJSONBytes(byte[] json) {
    return TenantPhoneConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID forgotPasswordTemplateId;
    private UUID identityUpdateTemplateId;
    private Boolean implicitPhoneVerificationAllowed;
    private UUID loginIdInUseOnCreateTemplateId;
    private UUID loginIdInUseOnUpdateTemplateId;
    private UUID loginNewDeviceTemplateId;
    private UUID loginSuspiciousTemplateId;
    private UUID messengerId;
    private UUID passwordResetSuccessTemplateId;
    private UUID passwordUpdateTemplateId;
    private UUID passwordlessTemplateId;
    private UUID setPasswordTemplateId;
    private UUID twoFactorMethodAddTemplateId;
    private UUID twoFactorMethodRemoveTemplateId;
    private PhoneUnverifiedOptions unverified;
    private UUID verificationCompleteTemplateId;
    private VerificationStrategy verificationStrategy;
    private UUID verificationTemplateId;
    private Boolean verifyPhoneNumber;
    public Builder forgotPasswordTemplateId(UUID forgotPasswordTemplateId) { this.forgotPasswordTemplateId = forgotPasswordTemplateId; return this; }
    public Builder identityUpdateTemplateId(UUID identityUpdateTemplateId) { this.identityUpdateTemplateId = identityUpdateTemplateId; return this; }
    public Builder implicitPhoneVerificationAllowed(Boolean implicitPhoneVerificationAllowed) { this.implicitPhoneVerificationAllowed = implicitPhoneVerificationAllowed; return this; }
    public Builder loginIdInUseOnCreateTemplateId(UUID loginIdInUseOnCreateTemplateId) { this.loginIdInUseOnCreateTemplateId = loginIdInUseOnCreateTemplateId; return this; }
    public Builder loginIdInUseOnUpdateTemplateId(UUID loginIdInUseOnUpdateTemplateId) { this.loginIdInUseOnUpdateTemplateId = loginIdInUseOnUpdateTemplateId; return this; }
    public Builder loginNewDeviceTemplateId(UUID loginNewDeviceTemplateId) { this.loginNewDeviceTemplateId = loginNewDeviceTemplateId; return this; }
    public Builder loginSuspiciousTemplateId(UUID loginSuspiciousTemplateId) { this.loginSuspiciousTemplateId = loginSuspiciousTemplateId; return this; }
    public Builder messengerId(UUID messengerId) { this.messengerId = messengerId; return this; }
    public Builder passwordResetSuccessTemplateId(UUID passwordResetSuccessTemplateId) { this.passwordResetSuccessTemplateId = passwordResetSuccessTemplateId; return this; }
    public Builder passwordUpdateTemplateId(UUID passwordUpdateTemplateId) { this.passwordUpdateTemplateId = passwordUpdateTemplateId; return this; }
    public Builder passwordlessTemplateId(UUID passwordlessTemplateId) { this.passwordlessTemplateId = passwordlessTemplateId; return this; }
    public Builder setPasswordTemplateId(UUID setPasswordTemplateId) { this.setPasswordTemplateId = setPasswordTemplateId; return this; }
    public Builder twoFactorMethodAddTemplateId(UUID twoFactorMethodAddTemplateId) { this.twoFactorMethodAddTemplateId = twoFactorMethodAddTemplateId; return this; }
    public Builder twoFactorMethodRemoveTemplateId(UUID twoFactorMethodRemoveTemplateId) { this.twoFactorMethodRemoveTemplateId = twoFactorMethodRemoveTemplateId; return this; }
    public Builder unverified(PhoneUnverifiedOptions unverified) { this.unverified = unverified; return this; }
    public Builder verificationCompleteTemplateId(UUID verificationCompleteTemplateId) { this.verificationCompleteTemplateId = verificationCompleteTemplateId; return this; }
    public Builder verificationStrategy(VerificationStrategy verificationStrategy) { this.verificationStrategy = verificationStrategy; return this; }
    public Builder verificationTemplateId(UUID verificationTemplateId) { this.verificationTemplateId = verificationTemplateId; return this; }
    public Builder verifyPhoneNumber(Boolean verifyPhoneNumber) { this.verifyPhoneNumber = verifyPhoneNumber; return this; }
    public TenantPhoneConfiguration build() { return new TenantPhoneConfiguration(forgotPasswordTemplateId, identityUpdateTemplateId, implicitPhoneVerificationAllowed, loginIdInUseOnCreateTemplateId, loginIdInUseOnUpdateTemplateId, loginNewDeviceTemplateId, loginSuspiciousTemplateId, messengerId, passwordResetSuccessTemplateId, passwordUpdateTemplateId, passwordlessTemplateId, setPasswordTemplateId, twoFactorMethodAddTemplateId, twoFactorMethodRemoveTemplateId, unverified, verificationCompleteTemplateId, verificationStrategy, verificationTemplateId, verifyPhoneNumber); }
  }
}
