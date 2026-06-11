/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookSearchCriteriaJSON;

@JSON
public record WebhookSearchCriteria(
    String description,
    UUID tenantId,
    String url,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookSearchCriteriaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookSearchCriteriaJSON.toJSONBytes(this);
  }

  public static WebhookSearchCriteria fromJSON(String json) {
    return WebhookSearchCriteriaJSON.fromJSON(json);
  }

  public static WebhookSearchCriteria fromJSONBytes(byte[] json) {
    return WebhookSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private String description;
    private UUID tenantId;
    private String url;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder description(String description) { this.description = description; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder url(String url) { this.url = url; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public WebhookSearchCriteria build() { return new WebhookSearchCriteria(description, tenantId, url, numberOfResults, orderBy, startRow); }
  }
}
