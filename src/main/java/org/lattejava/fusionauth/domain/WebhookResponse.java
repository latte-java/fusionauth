/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookResponseJSON;

@JSON
public record WebhookResponse(
    Webhook webhook,
    List<Webhook> webhooks) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebhookResponseJSON.toJSONBytes(this);
  }
  
  public static WebhookResponse fromJSON(String json) {
    return WebhookResponseJSON.fromJSON(json);
  }
  
  public static WebhookResponse fromJSONBytes(byte[] json) {
    return WebhookResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Webhook webhook;
    private List<Webhook> webhooks;
    public Builder webhook(Webhook webhook) { this.webhook = webhook; return this; }
    public Builder webhooks(List<Webhook> webhooks) { this.webhooks = webhooks; return this; }
    public WebhookResponse build() { return new WebhookResponse(webhook, webhooks); }
  }
}
