/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshTokenOneTimeUseConfigurationJSON;

@JSON
public record RefreshTokenOneTimeUseConfiguration(
    Integer gracePeriodInSeconds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshTokenOneTimeUseConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RefreshTokenOneTimeUseConfigurationJSON.toJSONBytes(this);
  }

  public static RefreshTokenOneTimeUseConfiguration fromJSON(String json) {
    return RefreshTokenOneTimeUseConfigurationJSON.fromJSON(json);
  }

  public static RefreshTokenOneTimeUseConfiguration fromJSONBytes(byte[] json) {
    return RefreshTokenOneTimeUseConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer gracePeriodInSeconds;
    public Builder gracePeriodInSeconds(Integer gracePeriodInSeconds) { this.gracePeriodInSeconds = gracePeriodInSeconds; return this; }
    public RefreshTokenOneTimeUseConfiguration build() { return new RefreshTokenOneTimeUseConfiguration(gracePeriodInSeconds); }
  }
}
