/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TemplatesJSON;

@JSON
public record Templates(
    String accountEdit,
    String accountIndex,
    String accountTwoFactorDisable,
    String accountTwoFactorEnable,
    String accountTwoFactorIndex,
    String accountWebAuthnAdd,
    String accountWebAuthnDelete,
    String accountWebAuthnIndex,
    String confirmationRequired,
    String emailComplete,
    String emailSent,
    String emailVerificationRequired,
    String emailVerify,
    String helpers,
    String index,
    String oauth2Authorize,
    String oauth2AuthorizedNotRegistered,
    String oauth2ChildRegistrationNotAllowed,
    String oauth2ChildRegistrationNotAllowedComplete,
    String oauth2CompleteRegistration,
    String oauth2Consent,
    String oauth2Device,
    String oauth2DeviceComplete,
    String oauth2Error,
    String oauth2Logout,
    String oauth2Passwordless,
    String oauth2Register,
    String oauth2StartIdPLink,
    String oauth2TwoFactor,
    String oauth2TwoFactorEnable,
    String oauth2TwoFactorEnableComplete,
    String oauth2TwoFactorMethods,
    String oauth2Wait,
    String oauth2WebAuthn,
    String oauth2WebAuthnReauth,
    String oauth2WebAuthnReauthEnable,
    String passwordChange,
    String passwordComplete,
    String passwordForgot,
    String passwordSent,
    String phoneComplete,
    String phoneSent,
    String phoneVerificationRequired,
    String phoneVerify,
    String registrationComplete,
    String registrationSent,
    String registrationVerificationRequired,
    String registrationVerify,
    String samlv2Logout,
    String unauthorized,
    String emailSend,
    String registrationSend) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TemplatesJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TemplatesJSON.toJSONBytes(this);
  }

  public static Templates fromJSON(String json) {
    return TemplatesJSON.fromJSON(json);
  }

  public static Templates fromJSONBytes(byte[] json) {
    return TemplatesJSON.fromJSON(json);
  }

  public static final class Builder {
    private String accountEdit;
    private String accountIndex;
    private String accountTwoFactorDisable;
    private String accountTwoFactorEnable;
    private String accountTwoFactorIndex;
    private String accountWebAuthnAdd;
    private String accountWebAuthnDelete;
    private String accountWebAuthnIndex;
    private String confirmationRequired;
    private String emailComplete;
    private String emailSent;
    private String emailVerificationRequired;
    private String emailVerify;
    private String helpers;
    private String index;
    private String oauth2Authorize;
    private String oauth2AuthorizedNotRegistered;
    private String oauth2ChildRegistrationNotAllowed;
    private String oauth2ChildRegistrationNotAllowedComplete;
    private String oauth2CompleteRegistration;
    private String oauth2Consent;
    private String oauth2Device;
    private String oauth2DeviceComplete;
    private String oauth2Error;
    private String oauth2Logout;
    private String oauth2Passwordless;
    private String oauth2Register;
    private String oauth2StartIdPLink;
    private String oauth2TwoFactor;
    private String oauth2TwoFactorEnable;
    private String oauth2TwoFactorEnableComplete;
    private String oauth2TwoFactorMethods;
    private String oauth2Wait;
    private String oauth2WebAuthn;
    private String oauth2WebAuthnReauth;
    private String oauth2WebAuthnReauthEnable;
    private String passwordChange;
    private String passwordComplete;
    private String passwordForgot;
    private String passwordSent;
    private String phoneComplete;
    private String phoneSent;
    private String phoneVerificationRequired;
    private String phoneVerify;
    private String registrationComplete;
    private String registrationSent;
    private String registrationVerificationRequired;
    private String registrationVerify;
    private String samlv2Logout;
    private String unauthorized;
    private String emailSend;
    private String registrationSend;
    public Builder accountEdit(String accountEdit) { this.accountEdit = accountEdit; return this; }
    public Builder accountIndex(String accountIndex) { this.accountIndex = accountIndex; return this; }
    public Builder accountTwoFactorDisable(String accountTwoFactorDisable) { this.accountTwoFactorDisable = accountTwoFactorDisable; return this; }
    public Builder accountTwoFactorEnable(String accountTwoFactorEnable) { this.accountTwoFactorEnable = accountTwoFactorEnable; return this; }
    public Builder accountTwoFactorIndex(String accountTwoFactorIndex) { this.accountTwoFactorIndex = accountTwoFactorIndex; return this; }
    public Builder accountWebAuthnAdd(String accountWebAuthnAdd) { this.accountWebAuthnAdd = accountWebAuthnAdd; return this; }
    public Builder accountWebAuthnDelete(String accountWebAuthnDelete) { this.accountWebAuthnDelete = accountWebAuthnDelete; return this; }
    public Builder accountWebAuthnIndex(String accountWebAuthnIndex) { this.accountWebAuthnIndex = accountWebAuthnIndex; return this; }
    public Builder confirmationRequired(String confirmationRequired) { this.confirmationRequired = confirmationRequired; return this; }
    public Builder emailComplete(String emailComplete) { this.emailComplete = emailComplete; return this; }
    public Builder emailSent(String emailSent) { this.emailSent = emailSent; return this; }
    public Builder emailVerificationRequired(String emailVerificationRequired) { this.emailVerificationRequired = emailVerificationRequired; return this; }
    public Builder emailVerify(String emailVerify) { this.emailVerify = emailVerify; return this; }
    public Builder helpers(String helpers) { this.helpers = helpers; return this; }
    public Builder index(String index) { this.index = index; return this; }
    public Builder oauth2Authorize(String oauth2Authorize) { this.oauth2Authorize = oauth2Authorize; return this; }
    public Builder oauth2AuthorizedNotRegistered(String oauth2AuthorizedNotRegistered) { this.oauth2AuthorizedNotRegistered = oauth2AuthorizedNotRegistered; return this; }
    public Builder oauth2ChildRegistrationNotAllowed(String oauth2ChildRegistrationNotAllowed) { this.oauth2ChildRegistrationNotAllowed = oauth2ChildRegistrationNotAllowed; return this; }
    public Builder oauth2ChildRegistrationNotAllowedComplete(String oauth2ChildRegistrationNotAllowedComplete) { this.oauth2ChildRegistrationNotAllowedComplete = oauth2ChildRegistrationNotAllowedComplete; return this; }
    public Builder oauth2CompleteRegistration(String oauth2CompleteRegistration) { this.oauth2CompleteRegistration = oauth2CompleteRegistration; return this; }
    public Builder oauth2Consent(String oauth2Consent) { this.oauth2Consent = oauth2Consent; return this; }
    public Builder oauth2Device(String oauth2Device) { this.oauth2Device = oauth2Device; return this; }
    public Builder oauth2DeviceComplete(String oauth2DeviceComplete) { this.oauth2DeviceComplete = oauth2DeviceComplete; return this; }
    public Builder oauth2Error(String oauth2Error) { this.oauth2Error = oauth2Error; return this; }
    public Builder oauth2Logout(String oauth2Logout) { this.oauth2Logout = oauth2Logout; return this; }
    public Builder oauth2Passwordless(String oauth2Passwordless) { this.oauth2Passwordless = oauth2Passwordless; return this; }
    public Builder oauth2Register(String oauth2Register) { this.oauth2Register = oauth2Register; return this; }
    public Builder oauth2StartIdPLink(String oauth2StartIdPLink) { this.oauth2StartIdPLink = oauth2StartIdPLink; return this; }
    public Builder oauth2TwoFactor(String oauth2TwoFactor) { this.oauth2TwoFactor = oauth2TwoFactor; return this; }
    public Builder oauth2TwoFactorEnable(String oauth2TwoFactorEnable) { this.oauth2TwoFactorEnable = oauth2TwoFactorEnable; return this; }
    public Builder oauth2TwoFactorEnableComplete(String oauth2TwoFactorEnableComplete) { this.oauth2TwoFactorEnableComplete = oauth2TwoFactorEnableComplete; return this; }
    public Builder oauth2TwoFactorMethods(String oauth2TwoFactorMethods) { this.oauth2TwoFactorMethods = oauth2TwoFactorMethods; return this; }
    public Builder oauth2Wait(String oauth2Wait) { this.oauth2Wait = oauth2Wait; return this; }
    public Builder oauth2WebAuthn(String oauth2WebAuthn) { this.oauth2WebAuthn = oauth2WebAuthn; return this; }
    public Builder oauth2WebAuthnReauth(String oauth2WebAuthnReauth) { this.oauth2WebAuthnReauth = oauth2WebAuthnReauth; return this; }
    public Builder oauth2WebAuthnReauthEnable(String oauth2WebAuthnReauthEnable) { this.oauth2WebAuthnReauthEnable = oauth2WebAuthnReauthEnable; return this; }
    public Builder passwordChange(String passwordChange) { this.passwordChange = passwordChange; return this; }
    public Builder passwordComplete(String passwordComplete) { this.passwordComplete = passwordComplete; return this; }
    public Builder passwordForgot(String passwordForgot) { this.passwordForgot = passwordForgot; return this; }
    public Builder passwordSent(String passwordSent) { this.passwordSent = passwordSent; return this; }
    public Builder phoneComplete(String phoneComplete) { this.phoneComplete = phoneComplete; return this; }
    public Builder phoneSent(String phoneSent) { this.phoneSent = phoneSent; return this; }
    public Builder phoneVerificationRequired(String phoneVerificationRequired) { this.phoneVerificationRequired = phoneVerificationRequired; return this; }
    public Builder phoneVerify(String phoneVerify) { this.phoneVerify = phoneVerify; return this; }
    public Builder registrationComplete(String registrationComplete) { this.registrationComplete = registrationComplete; return this; }
    public Builder registrationSent(String registrationSent) { this.registrationSent = registrationSent; return this; }
    public Builder registrationVerificationRequired(String registrationVerificationRequired) { this.registrationVerificationRequired = registrationVerificationRequired; return this; }
    public Builder registrationVerify(String registrationVerify) { this.registrationVerify = registrationVerify; return this; }
    public Builder samlv2Logout(String samlv2Logout) { this.samlv2Logout = samlv2Logout; return this; }
    public Builder unauthorized(String unauthorized) { this.unauthorized = unauthorized; return this; }
    public Builder emailSend(String emailSend) { this.emailSend = emailSend; return this; }
    public Builder registrationSend(String registrationSend) { this.registrationSend = registrationSend; return this; }
    public Templates build() { return new Templates(accountEdit, accountIndex, accountTwoFactorDisable, accountTwoFactorEnable, accountTwoFactorIndex, accountWebAuthnAdd, accountWebAuthnDelete, accountWebAuthnIndex, confirmationRequired, emailComplete, emailSent, emailVerificationRequired, emailVerify, helpers, index, oauth2Authorize, oauth2AuthorizedNotRegistered, oauth2ChildRegistrationNotAllowed, oauth2ChildRegistrationNotAllowedComplete, oauth2CompleteRegistration, oauth2Consent, oauth2Device, oauth2DeviceComplete, oauth2Error, oauth2Logout, oauth2Passwordless, oauth2Register, oauth2StartIdPLink, oauth2TwoFactor, oauth2TwoFactorEnable, oauth2TwoFactorEnableComplete, oauth2TwoFactorMethods, oauth2Wait, oauth2WebAuthn, oauth2WebAuthnReauth, oauth2WebAuthnReauthEnable, passwordChange, passwordComplete, passwordForgot, passwordSent, phoneComplete, phoneSent, phoneVerificationRequired, phoneVerify, registrationComplete, registrationSent, registrationVerificationRequired, registrationVerify, samlv2Logout, unauthorized, emailSend, registrationSend); }
  }
}
