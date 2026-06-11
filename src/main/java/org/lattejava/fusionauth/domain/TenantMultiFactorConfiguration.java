/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantMultiFactorConfigurationJSON;

@JSON
public record TenantMultiFactorConfiguration(
    MultiFactorAuthenticatorMethod authenticator,
    MultiFactorEmailMethod email,
    MultiFactorLoginPolicy loginPolicy,
    MultiFactorSMSMethod sms,
    MultiFactorVoiceMethod voice) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantMultiFactorConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantMultiFactorConfigurationJSON.toJSONBytes(this);
  }

  public static TenantMultiFactorConfiguration fromJSON(String json) {
    return TenantMultiFactorConfigurationJSON.fromJSON(json);
  }

  public static TenantMultiFactorConfiguration fromJSONBytes(byte[] json) {
    return TenantMultiFactorConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private MultiFactorAuthenticatorMethod authenticator;
    private MultiFactorEmailMethod email;
    private MultiFactorLoginPolicy loginPolicy;
    private MultiFactorSMSMethod sms;
    private MultiFactorVoiceMethod voice;
    public Builder authenticator(MultiFactorAuthenticatorMethod authenticator) { this.authenticator = authenticator; return this; }
    public Builder email(MultiFactorEmailMethod email) { this.email = email; return this; }
    public Builder loginPolicy(MultiFactorLoginPolicy loginPolicy) { this.loginPolicy = loginPolicy; return this; }
    public Builder sms(MultiFactorSMSMethod sms) { this.sms = sms; return this; }
    public Builder voice(MultiFactorVoiceMethod voice) { this.voice = voice; return this; }
    public TenantMultiFactorConfiguration build() { return new TenantMultiFactorConfiguration(authenticator, email, loginPolicy, sms, voice); }
  }
}
