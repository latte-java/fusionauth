/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventLogCreateEventJSON;

@JSON
public record EventLogCreateEvent(
    EventLog eventLog,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventLogCreateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EventLogCreateEventJSON.toJSONBytes(this);
  }

  public static EventLogCreateEvent fromJSON(String json) {
    return EventLogCreateEventJSON.fromJSON(json);
  }

  public static EventLogCreateEvent fromJSONBytes(byte[] json) {
    return EventLogCreateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private EventLog eventLog;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder eventLog(EventLog eventLog) { this.eventLog = eventLog; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public EventLogCreateEvent build() { return new EventLogCreateEvent(eventLog, createInstant, id, info, tenantId, type); }
  }
}
