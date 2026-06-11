/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWTRefreshTokenRevokeEventJSON;

@JSON
public record JWTRefreshTokenRevokeEvent(
    User user,
    UUID applicationId,
    Map<String, Integer> applicationTimeToLiveInSeconds,
    RefreshToken refreshToken,
    UUID userId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWTRefreshTokenRevokeEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JWTRefreshTokenRevokeEventJSON.toJSONBytes(this);
  }

  public static JWTRefreshTokenRevokeEvent fromJSON(String json) {
    return JWTRefreshTokenRevokeEventJSON.fromJSON(json);
  }

  public static JWTRefreshTokenRevokeEvent fromJSONBytes(byte[] json) {
    return JWTRefreshTokenRevokeEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    private UUID applicationId;
    private Map<String, Integer> applicationTimeToLiveInSeconds;
    private RefreshToken refreshToken;
    private UUID userId;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder user(User user) { this.user = user; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder applicationTimeToLiveInSeconds(Map<String, Integer> applicationTimeToLiveInSeconds) { this.applicationTimeToLiveInSeconds = applicationTimeToLiveInSeconds; return this; }
    public Builder refreshToken(RefreshToken refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public JWTRefreshTokenRevokeEvent build() { return new JWTRefreshTokenRevokeEvent(user, applicationId, applicationTimeToLiveInSeconds, refreshToken, userId, createInstant, id, info, tenantId, type); }
  }
}
