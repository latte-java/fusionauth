/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookAttemptLogResponseJSON;

@JSON
public record WebhookAttemptLogResponse(
    WebhookAttemptLog webhookAttemptLog) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookAttemptLogResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebhookAttemptLogResponseJSON.toJSONBytes(this);
  }
  
  public static WebhookAttemptLogResponse fromJSON(String json) {
    return WebhookAttemptLogResponseJSON.fromJSON(json);
  }
  
  public static WebhookAttemptLogResponse fromJSONBytes(byte[] json) {
    return WebhookAttemptLogResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebhookAttemptLog webhookAttemptLog;
    public Builder webhookAttemptLog(WebhookAttemptLog webhookAttemptLog) { this.webhookAttemptLog = webhookAttemptLog; return this; }
    public WebhookAttemptLogResponse build() { return new WebhookAttemptLogResponse(webhookAttemptLog); }
  }
}
