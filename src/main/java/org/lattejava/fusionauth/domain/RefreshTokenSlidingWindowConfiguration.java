/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshTokenSlidingWindowConfigurationJSON;

@JSON
public record RefreshTokenSlidingWindowConfiguration(
    Integer maximumTimeToLiveInMinutes) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshTokenSlidingWindowConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RefreshTokenSlidingWindowConfigurationJSON.toJSONBytes(this);
  }
  
  public static RefreshTokenSlidingWindowConfiguration fromJSON(String json) {
    return RefreshTokenSlidingWindowConfigurationJSON.fromJSON(json);
  }
  
  public static RefreshTokenSlidingWindowConfiguration fromJSONBytes(byte[] json) {
    return RefreshTokenSlidingWindowConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer maximumTimeToLiveInMinutes;
    public Builder maximumTimeToLiveInMinutes(Integer maximumTimeToLiveInMinutes) { this.maximumTimeToLiveInMinutes = maximumTimeToLiveInMinutes; return this; }
    public RefreshTokenSlidingWindowConfiguration build() { return new RefreshTokenSlidingWindowConfiguration(maximumTimeToLiveInMinutes); }
  }
}
