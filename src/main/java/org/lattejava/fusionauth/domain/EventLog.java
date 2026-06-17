/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventLogJSON;

@JSON
public record EventLog(
    Long id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    String message,
    EventLogType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventLogJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EventLogJSON.toJSONBytes(this);
  }
  
  public static EventLog fromJSON(String json) {
    return EventLogJSON.fromJSON(json);
  }
  
  public static EventLog fromJSONBytes(byte[] json) {
    return EventLogJSON.fromJSON(json);
  }

  public static final class Builder {
    private Long id;
    private Instant insertInstant;
    private String message;
    private EventLogType type;
    public Builder id(Long id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder message(String message) { this.message = message; return this; }
    public Builder type(EventLogType type) { this.type = type; return this; }
    public EventLog build() { return new EventLog(id, insertInstant, message, type); }
  }
}
