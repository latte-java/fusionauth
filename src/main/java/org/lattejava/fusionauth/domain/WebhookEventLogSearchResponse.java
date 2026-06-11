/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookEventLogSearchResponseJSON;

@JSON
public record WebhookEventLogSearchResponse(
    Long total,
    List<WebhookEventLog> webhookEventLogs) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookEventLogSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookEventLogSearchResponseJSON.toJSONBytes(this);
  }

  public static WebhookEventLogSearchResponse fromJSON(String json) {
    return WebhookEventLogSearchResponseJSON.fromJSON(json);
  }

  public static WebhookEventLogSearchResponse fromJSONBytes(byte[] json) {
    return WebhookEventLogSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Long total;
    private List<WebhookEventLog> webhookEventLogs;
    public Builder total(Long total) { this.total = total; return this; }
    public Builder webhookEventLogs(List<WebhookEventLog> webhookEventLogs) { this.webhookEventLogs = webhookEventLogs; return this; }
    public WebhookEventLogSearchResponse build() { return new WebhookEventLogSearchResponse(total, webhookEventLogs); }
  }
}
