/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWTPublicKeyUpdateEventJSON;

@JSON
public record JWTPublicKeyUpdateEvent(
    Set<String> applicationIds,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWTPublicKeyUpdateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JWTPublicKeyUpdateEventJSON.toJSONBytes(this);
  }

  public static JWTPublicKeyUpdateEvent fromJSON(String json) {
    return JWTPublicKeyUpdateEventJSON.fromJSON(json);
  }

  public static JWTPublicKeyUpdateEvent fromJSONBytes(byte[] json) {
    return JWTPublicKeyUpdateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private Set<String> applicationIds;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder applicationIds(Set<String> applicationIds) { this.applicationIds = applicationIds; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public JWTPublicKeyUpdateEvent build() { return new JWTPublicKeyUpdateEvent(applicationIds, createInstant, id, info, tenantId, type); }
  }
}
