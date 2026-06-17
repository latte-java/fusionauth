/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RateLimitedRequestConfigurationJSON;

@JSON
public record RateLimitedRequestConfiguration(
    Integer limit,
    Integer timePeriodInSeconds,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RateLimitedRequestConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RateLimitedRequestConfigurationJSON.toJSONBytes(this);
  }
  
  public static RateLimitedRequestConfiguration fromJSON(String json) {
    return RateLimitedRequestConfigurationJSON.fromJSON(json);
  }
  
  public static RateLimitedRequestConfiguration fromJSONBytes(byte[] json) {
    return RateLimitedRequestConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer limit;
    private Integer timePeriodInSeconds;
    private Boolean enabled;
    public Builder limit(Integer limit) { this.limit = limit; return this; }
    public Builder timePeriodInSeconds(Integer timePeriodInSeconds) { this.timePeriodInSeconds = timePeriodInSeconds; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public RateLimitedRequestConfiguration build() { return new RateLimitedRequestConfiguration(limit, timePeriodInSeconds, enabled); }
  }
}
