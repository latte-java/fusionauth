/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshTokenRevokeRequestJSON;

@JSON
public record RefreshTokenRevokeRequest(
    UUID applicationId,
    String token,
    UUID userId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshTokenRevokeRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RefreshTokenRevokeRequestJSON.toJSONBytes(this);
  }

  public static RefreshTokenRevokeRequest fromJSON(String json) {
    return RefreshTokenRevokeRequestJSON.fromJSON(json);
  }

  public static RefreshTokenRevokeRequest fromJSONBytes(byte[] json) {
    return RefreshTokenRevokeRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String token;
    private UUID userId;
    private EventInfo eventInfo;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public RefreshTokenRevokeRequest build() { return new RefreshTokenRevokeRequest(applicationId, token, userId, eventInfo); }
  }
}
