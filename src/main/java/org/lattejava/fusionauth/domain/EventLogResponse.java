/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventLogResponseJSON;

@JSON
public record EventLogResponse(
    EventLog eventLog) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventLogResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EventLogResponseJSON.toJSONBytes(this);
  }
  
  public static EventLogResponse fromJSON(String json) {
    return EventLogResponseJSON.fromJSON(json);
  }
  
  public static EventLogResponse fromJSONBytes(byte[] json) {
    return EventLogResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private EventLog eventLog;
    public Builder eventLog(EventLog eventLog) { this.eventLog = eventLog; return this; }
    public EventLogResponse build() { return new EventLogResponse(eventLog); }
  }
}
