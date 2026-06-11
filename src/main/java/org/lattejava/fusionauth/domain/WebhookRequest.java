/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookRequestJSON;

@JSON
public record WebhookRequest(
    Webhook webhook) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookRequestJSON.toJSONBytes(this);
  }

  public static WebhookRequest fromJSON(String json) {
    return WebhookRequestJSON.fromJSON(json);
  }

  public static WebhookRequest fromJSONBytes(byte[] json) {
    return WebhookRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Webhook webhook;
    public Builder webhook(Webhook webhook) { this.webhook = webhook; return this; }
    public WebhookRequest build() { return new WebhookRequest(webhook); }
  }
}
