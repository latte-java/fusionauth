/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookAttemptLogJSON;

@JSON
public record WebhookAttemptLog(
    Map<String, Object> data,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant endInstant,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant startInstant,
    WebhookCallResponse webhookCallResponse,
    UUID webhookEventLogId,
    UUID webhookId,
    WebhookAttemptResult attemptResult) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookAttemptLogJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookAttemptLogJSON.toJSONBytes(this);
  }

  public static WebhookAttemptLog fromJSON(String json) {
    return WebhookAttemptLogJSON.fromJSON(json);
  }

  public static WebhookAttemptLog fromJSONBytes(byte[] json) {
    return WebhookAttemptLogJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Instant endInstant;
    private UUID id;
    private Instant startInstant;
    private WebhookCallResponse webhookCallResponse;
    private UUID webhookEventLogId;
    private UUID webhookId;
    private WebhookAttemptResult attemptResult;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder endInstant(Instant endInstant) { this.endInstant = endInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder startInstant(Instant startInstant) { this.startInstant = startInstant; return this; }
    public Builder webhookCallResponse(WebhookCallResponse webhookCallResponse) { this.webhookCallResponse = webhookCallResponse; return this; }
    public Builder webhookEventLogId(UUID webhookEventLogId) { this.webhookEventLogId = webhookEventLogId; return this; }
    public Builder webhookId(UUID webhookId) { this.webhookId = webhookId; return this; }
    public Builder attemptResult(WebhookAttemptResult attemptResult) { this.attemptResult = attemptResult; return this; }
    public WebhookAttemptLog build() { return new WebhookAttemptLog(data, endInstant, id, startInstant, webhookCallResponse, webhookEventLogId, webhookId, attemptResult); }
  }
}
