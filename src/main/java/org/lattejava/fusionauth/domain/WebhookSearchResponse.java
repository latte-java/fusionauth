/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookSearchResponseJSON;

@JSON
public record WebhookSearchResponse(
    Long total,
    List<Webhook> webhooks) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookSearchResponseJSON.toJSONBytes(this);
  }

  public static WebhookSearchResponse fromJSON(String json) {
    return WebhookSearchResponseJSON.fromJSON(json);
  }

  public static WebhookSearchResponse fromJSONBytes(byte[] json) {
    return WebhookSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Long total;
    private List<Webhook> webhooks;
    public Builder total(Long total) { this.total = total; return this; }
    public Builder webhooks(List<Webhook> webhooks) { this.webhooks = webhooks; return this; }
    public WebhookSearchResponse build() { return new WebhookSearchResponse(total, webhooks); }
  }
}
