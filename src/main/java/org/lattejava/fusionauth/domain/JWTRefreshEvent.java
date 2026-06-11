/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWTRefreshEventJSON;

@JSON
public record JWTRefreshEvent(
    UUID applicationId,
    String original,
    String refreshToken,
    String token,
    UUID userId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWTRefreshEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JWTRefreshEventJSON.toJSONBytes(this);
  }

  public static JWTRefreshEvent fromJSON(String json) {
    return JWTRefreshEventJSON.fromJSON(json);
  }

  public static JWTRefreshEvent fromJSONBytes(byte[] json) {
    return JWTRefreshEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String original;
    private String refreshToken;
    private String token;
    private UUID userId;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder original(String original) { this.original = original; return this; }
    public Builder refreshToken(String refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public JWTRefreshEvent build() { return new JWTRefreshEvent(applicationId, original, refreshToken, token, userId, createInstant, id, info, tenantId, type); }
  }
}
