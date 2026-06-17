/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventConfigurationJSON;

@JSON
public record EventConfiguration(
    Map<String, EventConfigurationData> events) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EventConfigurationJSON.toJSONBytes(this);
  }
  
  public static EventConfiguration fromJSON(String json) {
    return EventConfigurationJSON.fromJSON(json);
  }
  
  public static EventConfiguration fromJSONBytes(byte[] json) {
    return EventConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, EventConfigurationData> events;
    public Builder events(Map<String, EventConfigurationData> events) { this.events = events; return this; }
    public EventConfiguration build() { return new EventConfiguration(events); }
  }
}
