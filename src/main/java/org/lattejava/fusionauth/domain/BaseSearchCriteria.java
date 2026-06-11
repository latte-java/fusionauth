/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseSearchCriteriaJSON;

@JSON
public record BaseSearchCriteria(
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseSearchCriteriaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return BaseSearchCriteriaJSON.toJSONBytes(this);
  }

  public static BaseSearchCriteria fromJSON(String json) {
    return BaseSearchCriteriaJSON.fromJSON(json);
  }

  public static BaseSearchCriteria fromJSONBytes(byte[] json) {
    return BaseSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public BaseSearchCriteria build() { return new BaseSearchCriteria(numberOfResults, orderBy, startRow); }
  }
}
