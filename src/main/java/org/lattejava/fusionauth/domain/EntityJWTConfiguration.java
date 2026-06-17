/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityJWTConfigurationJSON;

@JSON
public record EntityJWTConfiguration(
    UUID accessTokenKeyId,
    Integer timeToLiveInSeconds,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityJWTConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityJWTConfigurationJSON.toJSONBytes(this);
  }
  
  public static EntityJWTConfiguration fromJSON(String json) {
    return EntityJWTConfigurationJSON.fromJSON(json);
  }
  
  public static EntityJWTConfiguration fromJSONBytes(byte[] json) {
    return EntityJWTConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID accessTokenKeyId;
    private Integer timeToLiveInSeconds;
    private Boolean enabled;
    public Builder accessTokenKeyId(UUID accessTokenKeyId) { this.accessTokenKeyId = accessTokenKeyId; return this; }
    public Builder timeToLiveInSeconds(Integer timeToLiveInSeconds) { this.timeToLiveInSeconds = timeToLiveInSeconds; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public EntityJWTConfiguration build() { return new EntityJWTConfiguration(accessTokenKeyId, timeToLiveInSeconds, enabled); }
  }
}
