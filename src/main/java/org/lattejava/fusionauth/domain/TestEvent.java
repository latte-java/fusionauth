/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TestEventJSON;

@JSON
public record TestEvent(
    String message,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TestEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TestEventJSON.toJSONBytes(this);
  }

  public static TestEvent fromJSON(String json) {
    return TestEventJSON.fromJSON(json);
  }

  public static TestEvent fromJSONBytes(byte[] json) {
    return TestEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private String message;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder message(String message) { this.message = message; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public TestEvent build() { return new TestEvent(message, createInstant, id, info, tenantId, type); }
  }
}
