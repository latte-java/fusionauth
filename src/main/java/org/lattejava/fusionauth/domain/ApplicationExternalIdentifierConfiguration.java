/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationExternalIdentifierConfigurationJSON;

@JSON
public record ApplicationExternalIdentifierConfiguration(
    Integer twoFactorTrustIdTimeToLiveInSeconds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationExternalIdentifierConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationExternalIdentifierConfigurationJSON.toJSONBytes(this);
  }

  public static ApplicationExternalIdentifierConfiguration fromJSON(String json) {
    return ApplicationExternalIdentifierConfigurationJSON.fromJSON(json);
  }

  public static ApplicationExternalIdentifierConfiguration fromJSONBytes(byte[] json) {
    return ApplicationExternalIdentifierConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer twoFactorTrustIdTimeToLiveInSeconds;
    public Builder twoFactorTrustIdTimeToLiveInSeconds(Integer twoFactorTrustIdTimeToLiveInSeconds) { this.twoFactorTrustIdTimeToLiveInSeconds = twoFactorTrustIdTimeToLiveInSeconds; return this; }
    public ApplicationExternalIdentifierConfiguration build() { return new ApplicationExternalIdentifierConfiguration(twoFactorTrustIdTimeToLiveInSeconds); }
  }
}
