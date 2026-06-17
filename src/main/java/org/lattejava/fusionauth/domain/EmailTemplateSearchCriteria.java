/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailTemplateSearchCriteriaJSON;

@JSON
public record EmailTemplateSearchCriteria(
    String name,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailTemplateSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EmailTemplateSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static EmailTemplateSearchCriteria fromJSON(String json) {
    return EmailTemplateSearchCriteriaJSON.fromJSON(json);
  }
  
  public static EmailTemplateSearchCriteria fromJSONBytes(byte[] json) {
    return EmailTemplateSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private String name;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder name(String name) { this.name = name; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public EmailTemplateSearchCriteria build() { return new EmailTemplateSearchCriteria(name, numberOfResults, orderBy, startRow); }
  }
}
