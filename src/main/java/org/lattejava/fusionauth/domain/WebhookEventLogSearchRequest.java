/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookEventLogSearchRequestJSON;

@JSON
public record WebhookEventLogSearchRequest(
    WebhookEventLogSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookEventLogSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebhookEventLogSearchRequestJSON.toJSONBytes(this);
  }
  
  public static WebhookEventLogSearchRequest fromJSON(String json) {
    return WebhookEventLogSearchRequestJSON.fromJSON(json);
  }
  
  public static WebhookEventLogSearchRequest fromJSONBytes(byte[] json) {
    return WebhookEventLogSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebhookEventLogSearchCriteria search;
    public Builder search(WebhookEventLogSearchCriteria search) { this.search = search; return this; }
    public WebhookEventLogSearchRequest build() { return new WebhookEventLogSearchRequest(search); }
  }
}
