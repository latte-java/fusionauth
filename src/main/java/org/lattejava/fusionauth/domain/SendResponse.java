/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SendResponseJSON;

@JSON
public record SendResponse(
    Map<String, EmailTemplateErrors> anonymousResults,
    Map<String, EmailTemplateErrors> results) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SendResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SendResponseJSON.toJSONBytes(this);
  }

  public static SendResponse fromJSON(String json) {
    return SendResponseJSON.fromJSON(json);
  }

  public static SendResponse fromJSONBytes(byte[] json) {
    return SendResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, EmailTemplateErrors> anonymousResults;
    private Map<String, EmailTemplateErrors> results;
    public Builder anonymousResults(Map<String, EmailTemplateErrors> anonymousResults) { this.anonymousResults = anonymousResults; return this; }
    public Builder results(Map<String, EmailTemplateErrors> results) { this.results = results; return this; }
    public SendResponse build() { return new SendResponse(anonymousResults, results); }
  }
}
