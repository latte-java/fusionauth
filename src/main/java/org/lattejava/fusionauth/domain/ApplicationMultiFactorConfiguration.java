/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationMultiFactorConfigurationJSON;

@JSON
public record ApplicationMultiFactorConfiguration(
    MultiFactorEmailTemplate email,
    MultiFactorLoginPolicy loginPolicy,
    MultiFactorSMSTemplate sms,
    ApplicationMultiFactorTrustPolicy trustPolicy,
    MultiFactorVoiceTemplate voice) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationMultiFactorConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationMultiFactorConfigurationJSON.toJSONBytes(this);
  }
  
  public static ApplicationMultiFactorConfiguration fromJSON(String json) {
    return ApplicationMultiFactorConfigurationJSON.fromJSON(json);
  }
  
  public static ApplicationMultiFactorConfiguration fromJSONBytes(byte[] json) {
    return ApplicationMultiFactorConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private MultiFactorEmailTemplate email;
    private MultiFactorLoginPolicy loginPolicy;
    private MultiFactorSMSTemplate sms;
    private ApplicationMultiFactorTrustPolicy trustPolicy;
    private MultiFactorVoiceTemplate voice;
    public Builder email(MultiFactorEmailTemplate email) { this.email = email; return this; }
    public Builder loginPolicy(MultiFactorLoginPolicy loginPolicy) { this.loginPolicy = loginPolicy; return this; }
    public Builder sms(MultiFactorSMSTemplate sms) { this.sms = sms; return this; }
    public Builder trustPolicy(ApplicationMultiFactorTrustPolicy trustPolicy) { this.trustPolicy = trustPolicy; return this; }
    public Builder voice(MultiFactorVoiceTemplate voice) { this.voice = voice; return this; }
    public ApplicationMultiFactorConfiguration build() { return new ApplicationMultiFactorConfiguration(email, loginPolicy, sms, trustPolicy, voice); }
  }
}
