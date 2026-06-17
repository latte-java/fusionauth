/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWTVendRequestJSON;

@JSON
public record JWTVendRequest(
    Map<String, Object> claims,
    UUID keyId,
    Integer timeToLiveInSeconds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWTVendRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return JWTVendRequestJSON.toJSONBytes(this);
  }
  
  public static JWTVendRequest fromJSON(String json) {
    return JWTVendRequestJSON.fromJSON(json);
  }
  
  public static JWTVendRequest fromJSONBytes(byte[] json) {
    return JWTVendRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> claims;
    private UUID keyId;
    private Integer timeToLiveInSeconds;
    public Builder claims(Map<String, Object> claims) { this.claims = claims; return this; }
    public Builder keyId(UUID keyId) { this.keyId = keyId; return this; }
    public Builder timeToLiveInSeconds(Integer timeToLiveInSeconds) { this.timeToLiveInSeconds = timeToLiveInSeconds; return this; }
    public JWTVendRequest build() { return new JWTVendRequest(claims, keyId, timeToLiveInSeconds); }
  }
}
