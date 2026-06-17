/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookEventLogResponseJSON;

@JSON
public record WebhookEventLogResponse(
    WebhookEventLog webhookEventLog) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookEventLogResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebhookEventLogResponseJSON.toJSONBytes(this);
  }
  
  public static WebhookEventLogResponse fromJSON(String json) {
    return WebhookEventLogResponseJSON.fromJSON(json);
  }
  
  public static WebhookEventLogResponse fromJSONBytes(byte[] json) {
    return WebhookEventLogResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebhookEventLog webhookEventLog;
    public Builder webhookEventLog(WebhookEventLog webhookEventLog) { this.webhookEventLog = webhookEventLog; return this; }
    public WebhookEventLogResponse build() { return new WebhookEventLogResponse(webhookEventLog); }
  }
}
