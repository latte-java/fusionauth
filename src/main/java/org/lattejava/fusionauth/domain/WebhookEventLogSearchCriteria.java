/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookEventLogSearchCriteriaJSON;

@JSON
public record WebhookEventLogSearchCriteria(
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant end,
    String event,
    WebhookEventResult eventResult,
    EventType eventType,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant start,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookEventLogSearchCriteriaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookEventLogSearchCriteriaJSON.toJSONBytes(this);
  }

  public static WebhookEventLogSearchCriteria fromJSON(String json) {
    return WebhookEventLogSearchCriteriaJSON.fromJSON(json);
  }

  public static WebhookEventLogSearchCriteria fromJSONBytes(byte[] json) {
    return WebhookEventLogSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private Instant end;
    private String event;
    private WebhookEventResult eventResult;
    private EventType eventType;
    private Instant start;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder end(Instant end) { this.end = end; return this; }
    public Builder event(String event) { this.event = event; return this; }
    public Builder eventResult(WebhookEventResult eventResult) { this.eventResult = eventResult; return this; }
    public Builder eventType(EventType eventType) { this.eventType = eventType; return this; }
    public Builder start(Instant start) { this.start = start; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public WebhookEventLogSearchCriteria build() { return new WebhookEventLogSearchCriteria(end, event, eventResult, eventType, start, numberOfResults, orderBy, startRow); }
  }
}
