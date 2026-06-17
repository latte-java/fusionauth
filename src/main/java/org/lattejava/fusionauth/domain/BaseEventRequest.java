/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseEventRequestJSON;

@JSON
public record BaseEventRequest(
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseEventRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return BaseEventRequestJSON.toJSONBytes(this);
  }
  
  public static BaseEventRequest fromJSON(String json) {
    return BaseEventRequestJSON.fromJSON(json);
  }
  
  public static BaseEventRequest fromJSONBytes(byte[] json) {
    return BaseEventRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EventInfo eventInfo;
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public BaseEventRequest build() { return new BaseEventRequest(eventInfo); }
  }
}
