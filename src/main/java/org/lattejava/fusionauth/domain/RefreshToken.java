/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshTokenJSON;

@JSON
public record RefreshToken(
    UUID applicationId,
    Map<String, Object> data,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    MetaData metaData,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant startInstant,
    UUID tenantId,
    String token,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshTokenJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RefreshTokenJSON.toJSONBytes(this);
  }

  public static RefreshToken fromJSON(String json) {
    return RefreshTokenJSON.fromJSON(json);
  }

  public static RefreshToken fromJSONBytes(byte[] json) {
    return RefreshTokenJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private Map<String, Object> data;
    private UUID id;
    private Instant insertInstant;
    private MetaData metaData;
    private Instant startInstant;
    private UUID tenantId;
    private String token;
    private UUID userId;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder startInstant(Instant startInstant) { this.startInstant = startInstant; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public RefreshToken build() { return new RefreshToken(applicationId, data, id, insertInstant, metaData, startInstant, tenantId, token, userId); }
  }
}
