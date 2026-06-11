/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookCallResponseJSON;

@JSON
public record WebhookCallResponse(
    String exception,
    Integer statusCode,
    String url) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookCallResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookCallResponseJSON.toJSONBytes(this);
  }

  public static WebhookCallResponse fromJSON(String json) {
    return WebhookCallResponseJSON.fromJSON(json);
  }

  public static WebhookCallResponse fromJSONBytes(byte[] json) {
    return WebhookCallResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String exception;
    private Integer statusCode;
    private String url;
    public Builder exception(String exception) { this.exception = exception; return this; }
    public Builder statusCode(Integer statusCode) { this.statusCode = statusCode; return this; }
    public Builder url(String url) { this.url = url; return this; }
    public WebhookCallResponse build() { return new WebhookCallResponse(exception, statusCode, url); }
  }
}
