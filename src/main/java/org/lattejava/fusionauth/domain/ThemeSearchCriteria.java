/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ThemeSearchCriteriaJSON;

@JSON
public record ThemeSearchCriteria(
    String name,
    ThemeType type,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ThemeSearchCriteriaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ThemeSearchCriteriaJSON.toJSONBytes(this);
  }

  public static ThemeSearchCriteria fromJSON(String json) {
    return ThemeSearchCriteriaJSON.fromJSON(json);
  }

  public static ThemeSearchCriteria fromJSONBytes(byte[] json) {
    return ThemeSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private String name;
    private ThemeType type;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(ThemeType type) { this.type = type; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public ThemeSearchCriteria build() { return new ThemeSearchCriteria(name, type, numberOfResults, orderBy, startRow); }
  }
}
