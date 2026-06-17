/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KickstartSuccessEventJSON;

@JSON
public record KickstartSuccessEvent(
    UUID instanceId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return KickstartSuccessEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return KickstartSuccessEventJSON.toJSONBytes(this);
  }
  
  public static KickstartSuccessEvent fromJSON(String json) {
    return KickstartSuccessEventJSON.fromJSON(json);
  }
  
  public static KickstartSuccessEvent fromJSONBytes(byte[] json) {
    return KickstartSuccessEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID instanceId;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder instanceId(UUID instanceId) { this.instanceId = instanceId; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public KickstartSuccessEvent build() { return new KickstartSuccessEvent(instanceId, createInstant, id, info, tenantId, type); }
  }
}
