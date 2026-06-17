/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseUserEventJSON;

@JSON
public record BaseUserEvent(
    User user,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseUserEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return BaseUserEventJSON.toJSONBytes(this);
  }
  
  public static BaseUserEvent fromJSON(String json) {
    return BaseUserEventJSON.fromJSON(json);
  }
  
  public static BaseUserEvent fromJSONBytes(byte[] json) {
    return BaseUserEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder user(User user) { this.user = user; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public BaseUserEvent build() { return new BaseUserEvent(user, createInstant, id, info, tenantId, type); }
  }
}
