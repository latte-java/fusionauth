/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshRequestJSON;

@JSON
public record RefreshRequest(
    String refreshToken,
    Integer timeToLiveInSeconds,
    String token,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RefreshRequestJSON.toJSONBytes(this);
  }

  public static RefreshRequest fromJSON(String json) {
    return RefreshRequestJSON.fromJSON(json);
  }

  public static RefreshRequest fromJSONBytes(byte[] json) {
    return RefreshRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String refreshToken;
    private Integer timeToLiveInSeconds;
    private String token;
    private EventInfo eventInfo;
    public Builder refreshToken(String refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder timeToLiveInSeconds(Integer timeToLiveInSeconds) { this.timeToLiveInSeconds = timeToLiveInSeconds; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public RefreshRequest build() { return new RefreshRequest(refreshToken, timeToLiveInSeconds, token, eventInfo); }
  }
}
