/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantRateLimitConfigurationJSON;

@JSON
public record TenantRateLimitConfiguration(
    RateLimitedRequestConfiguration failedLogin,
    RateLimitedRequestConfiguration forgotPassword,
    RateLimitedRequestConfiguration sendEmailVerification,
    RateLimitedRequestConfiguration sendPasswordless,
    RateLimitedRequestConfiguration sendPasswordlessPhone,
    RateLimitedRequestConfiguration sendPhoneVerification,
    RateLimitedRequestConfiguration sendRegistrationVerification,
    RateLimitedRequestConfiguration sendTwoFactor) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantRateLimitConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantRateLimitConfigurationJSON.toJSONBytes(this);
  }

  public static TenantRateLimitConfiguration fromJSON(String json) {
    return TenantRateLimitConfigurationJSON.fromJSON(json);
  }

  public static TenantRateLimitConfiguration fromJSONBytes(byte[] json) {
    return TenantRateLimitConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private RateLimitedRequestConfiguration failedLogin;
    private RateLimitedRequestConfiguration forgotPassword;
    private RateLimitedRequestConfiguration sendEmailVerification;
    private RateLimitedRequestConfiguration sendPasswordless;
    private RateLimitedRequestConfiguration sendPasswordlessPhone;
    private RateLimitedRequestConfiguration sendPhoneVerification;
    private RateLimitedRequestConfiguration sendRegistrationVerification;
    private RateLimitedRequestConfiguration sendTwoFactor;
    public Builder failedLogin(RateLimitedRequestConfiguration failedLogin) { this.failedLogin = failedLogin; return this; }
    public Builder forgotPassword(RateLimitedRequestConfiguration forgotPassword) { this.forgotPassword = forgotPassword; return this; }
    public Builder sendEmailVerification(RateLimitedRequestConfiguration sendEmailVerification) { this.sendEmailVerification = sendEmailVerification; return this; }
    public Builder sendPasswordless(RateLimitedRequestConfiguration sendPasswordless) { this.sendPasswordless = sendPasswordless; return this; }
    public Builder sendPasswordlessPhone(RateLimitedRequestConfiguration sendPasswordlessPhone) { this.sendPasswordlessPhone = sendPasswordlessPhone; return this; }
    public Builder sendPhoneVerification(RateLimitedRequestConfiguration sendPhoneVerification) { this.sendPhoneVerification = sendPhoneVerification; return this; }
    public Builder sendRegistrationVerification(RateLimitedRequestConfiguration sendRegistrationVerification) { this.sendRegistrationVerification = sendRegistrationVerification; return this; }
    public Builder sendTwoFactor(RateLimitedRequestConfiguration sendTwoFactor) { this.sendTwoFactor = sendTwoFactor; return this; }
    public TenantRateLimitConfiguration build() { return new TenantRateLimitConfiguration(failedLogin, forgotPassword, sendEmailVerification, sendPasswordless, sendPasswordlessPhone, sendPhoneVerification, sendRegistrationVerification, sendTwoFactor); }
  }
}
