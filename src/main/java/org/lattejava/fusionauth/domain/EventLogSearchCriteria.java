/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventLogSearchCriteriaJSON;

@JSON
public record EventLogSearchCriteria(
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant end,
    String message,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant start,
    EventLogType type,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventLogSearchCriteriaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EventLogSearchCriteriaJSON.toJSONBytes(this);
  }

  public static EventLogSearchCriteria fromJSON(String json) {
    return EventLogSearchCriteriaJSON.fromJSON(json);
  }

  public static EventLogSearchCriteria fromJSONBytes(byte[] json) {
    return EventLogSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private Instant end;
    private String message;
    private Instant start;
    private EventLogType type;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder end(Instant end) { this.end = end; return this; }
    public Builder message(String message) { this.message = message; return this; }
    public Builder start(Instant start) { this.start = start; return this; }
    public Builder type(EventLogType type) { this.type = type; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public EventLogSearchCriteria build() { return new EventLogSearchCriteria(end, message, start, type, numberOfResults, orderBy, startRow); }
  }
}
