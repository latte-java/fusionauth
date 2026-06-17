/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookEventLogJSON;

@JSON
public record WebhookEventLog(
    List<WebhookAttemptLog> attempts,
    Map<String, Object> data,
    EventRequest event,
    WebhookEventResult eventResult,
    EventType eventType,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastAttemptInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    UUID linkedObjectId,
    Long sequence,
    Integer failedAttempts,
    Integer successfulAttempts) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookEventLogJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebhookEventLogJSON.toJSONBytes(this);
  }
  
  public static WebhookEventLog fromJSON(String json) {
    return WebhookEventLogJSON.fromJSON(json);
  }
  
  public static WebhookEventLog fromJSONBytes(byte[] json) {
    return WebhookEventLogJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<WebhookAttemptLog> attempts;
    private Map<String, Object> data;
    private EventRequest event;
    private WebhookEventResult eventResult;
    private EventType eventType;
    private UUID id;
    private Instant insertInstant;
    private Instant lastAttemptInstant;
    private Instant lastUpdateInstant;
    private UUID linkedObjectId;
    private Long sequence;
    private Integer failedAttempts;
    private Integer successfulAttempts;
    public Builder attempts(List<WebhookAttemptLog> attempts) { this.attempts = attempts; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder event(EventRequest event) { this.event = event; return this; }
    public Builder eventResult(WebhookEventResult eventResult) { this.eventResult = eventResult; return this; }
    public Builder eventType(EventType eventType) { this.eventType = eventType; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastAttemptInstant(Instant lastAttemptInstant) { this.lastAttemptInstant = lastAttemptInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder linkedObjectId(UUID linkedObjectId) { this.linkedObjectId = linkedObjectId; return this; }
    public Builder sequence(Long sequence) { this.sequence = sequence; return this; }
    public Builder failedAttempts(Integer failedAttempts) { this.failedAttempts = failedAttempts; return this; }
    public Builder successfulAttempts(Integer successfulAttempts) { this.successfulAttempts = successfulAttempts; return this; }
    public WebhookEventLog build() { return new WebhookEventLog(attempts, data, event, eventResult, eventType, id, insertInstant, lastAttemptInstant, lastUpdateInstant, linkedObjectId, sequence, failedAttempts, successfulAttempts); }
  }
}
