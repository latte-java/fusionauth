/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventLogConfigurationJSON;

@JSON
public record EventLogConfiguration(
    Integer numberToRetain) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventLogConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EventLogConfigurationJSON.toJSONBytes(this);
  }
  
  public static EventLogConfiguration fromJSON(String json) {
    return EventLogConfigurationJSON.fromJSON(json);
  }
  
  public static EventLogConfiguration fromJSONBytes(byte[] json) {
    return EventLogConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer numberToRetain;
    public Builder numberToRetain(Integer numberToRetain) { this.numberToRetain = numberToRetain; return this; }
    public EventLogConfiguration build() { return new EventLogConfiguration(numberToRetain); }
  }
}
