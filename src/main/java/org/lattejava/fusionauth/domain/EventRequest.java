/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventRequestJSON;

@JSON
public record EventRequest(
    BaseEvent event) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EventRequestJSON.toJSONBytes(this);
  }
  
  public static EventRequest fromJSON(String json) {
    return EventRequestJSON.fromJSON(json);
  }
  
  public static EventRequest fromJSONBytes(byte[] json) {
    return EventRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private BaseEvent event;
    public Builder event(BaseEvent event) { this.event = event; return this; }
    public EventRequest build() { return new EventRequest(event); }
  }
}
