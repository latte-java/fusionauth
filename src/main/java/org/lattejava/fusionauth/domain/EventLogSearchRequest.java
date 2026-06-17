/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventLogSearchRequestJSON;

@JSON
public record EventLogSearchRequest(
    EventLogSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventLogSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EventLogSearchRequestJSON.toJSONBytes(this);
  }
  
  public static EventLogSearchRequest fromJSON(String json) {
    return EventLogSearchRequestJSON.fromJSON(json);
  }
  
  public static EventLogSearchRequest fromJSONBytes(byte[] json) {
    return EventLogSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EventLogSearchCriteria search;
    public Builder search(EventLogSearchCriteria search) { this.search = search; return this; }
    public EventLogSearchRequest build() { return new EventLogSearchRequest(search); }
  }
}
