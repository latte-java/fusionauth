/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserBulkCreateEventJSON;

@JSON
public record UserBulkCreateEvent(
    List<User> users,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserBulkCreateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserBulkCreateEventJSON.toJSONBytes(this);
  }
  
  public static UserBulkCreateEvent fromJSON(String json) {
    return UserBulkCreateEventJSON.fromJSON(json);
  }
  
  public static UserBulkCreateEvent fromJSONBytes(byte[] json) {
    return UserBulkCreateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<User> users;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder users(List<User> users) { this.users = users; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public UserBulkCreateEvent build() { return new UserBulkCreateEvent(users, createInstant, id, info, tenantId, type); }
  }
}
