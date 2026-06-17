/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookSearchRequestJSON;

@JSON
public record WebhookSearchRequest(
    WebhookSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebhookSearchRequestJSON.toJSONBytes(this);
  }
  
  public static WebhookSearchRequest fromJSON(String json) {
    return WebhookSearchRequestJSON.fromJSON(json);
  }
  
  public static WebhookSearchRequest fromJSONBytes(byte[] json) {
    return WebhookSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebhookSearchCriteria search;
    public Builder search(WebhookSearchCriteria search) { this.search = search; return this; }
    public WebhookSearchRequest build() { return new WebhookSearchRequest(search); }
  }
}
