/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWTConfigurationJSON;

@JSON
public record JWTConfiguration(
    UUID accessTokenKeyId,
    UUID idTokenKeyId,
    RefreshTokenExpirationPolicy refreshTokenExpirationPolicy,
    RefreshTokenOneTimeUseConfiguration refreshTokenOneTimeUseConfiguration,
    RefreshTokenRevocationPolicy refreshTokenRevocationPolicy,
    RefreshTokenSlidingWindowConfiguration refreshTokenSlidingWindowConfiguration,
    Integer refreshTokenTimeToLiveInMinutes,
    RefreshTokenUsagePolicy refreshTokenUsagePolicy,
    Integer timeToLiveInSeconds,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWTConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JWTConfigurationJSON.toJSONBytes(this);
  }

  public static JWTConfiguration fromJSON(String json) {
    return JWTConfigurationJSON.fromJSON(json);
  }

  public static JWTConfiguration fromJSONBytes(byte[] json) {
    return JWTConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID accessTokenKeyId;
    private UUID idTokenKeyId;
    private RefreshTokenExpirationPolicy refreshTokenExpirationPolicy;
    private RefreshTokenOneTimeUseConfiguration refreshTokenOneTimeUseConfiguration;
    private RefreshTokenRevocationPolicy refreshTokenRevocationPolicy;
    private RefreshTokenSlidingWindowConfiguration refreshTokenSlidingWindowConfiguration;
    private Integer refreshTokenTimeToLiveInMinutes;
    private RefreshTokenUsagePolicy refreshTokenUsagePolicy;
    private Integer timeToLiveInSeconds;
    private Boolean enabled;
    public Builder accessTokenKeyId(UUID accessTokenKeyId) { this.accessTokenKeyId = accessTokenKeyId; return this; }
    public Builder idTokenKeyId(UUID idTokenKeyId) { this.idTokenKeyId = idTokenKeyId; return this; }
    public Builder refreshTokenExpirationPolicy(RefreshTokenExpirationPolicy refreshTokenExpirationPolicy) { this.refreshTokenExpirationPolicy = refreshTokenExpirationPolicy; return this; }
    public Builder refreshTokenOneTimeUseConfiguration(RefreshTokenOneTimeUseConfiguration refreshTokenOneTimeUseConfiguration) { this.refreshTokenOneTimeUseConfiguration = refreshTokenOneTimeUseConfiguration; return this; }
    public Builder refreshTokenRevocationPolicy(RefreshTokenRevocationPolicy refreshTokenRevocationPolicy) { this.refreshTokenRevocationPolicy = refreshTokenRevocationPolicy; return this; }
    public Builder refreshTokenSlidingWindowConfiguration(RefreshTokenSlidingWindowConfiguration refreshTokenSlidingWindowConfiguration) { this.refreshTokenSlidingWindowConfiguration = refreshTokenSlidingWindowConfiguration; return this; }
    public Builder refreshTokenTimeToLiveInMinutes(Integer refreshTokenTimeToLiveInMinutes) { this.refreshTokenTimeToLiveInMinutes = refreshTokenTimeToLiveInMinutes; return this; }
    public Builder refreshTokenUsagePolicy(RefreshTokenUsagePolicy refreshTokenUsagePolicy) { this.refreshTokenUsagePolicy = refreshTokenUsagePolicy; return this; }
    public Builder timeToLiveInSeconds(Integer timeToLiveInSeconds) { this.timeToLiveInSeconds = timeToLiveInSeconds; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public JWTConfiguration build() { return new JWTConfiguration(accessTokenKeyId, idTokenKeyId, refreshTokenExpirationPolicy, refreshTokenOneTimeUseConfiguration, refreshTokenRevocationPolicy, refreshTokenSlidingWindowConfiguration, refreshTokenTimeToLiveInMinutes, refreshTokenUsagePolicy, timeToLiveInSeconds, enabled); }
  }
}
