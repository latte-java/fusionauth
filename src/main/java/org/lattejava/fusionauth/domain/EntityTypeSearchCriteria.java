/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityTypeSearchCriteriaJSON;

@JSON
public record EntityTypeSearchCriteria(
    String name,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityTypeSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityTypeSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static EntityTypeSearchCriteria fromJSON(String json) {
    return EntityTypeSearchCriteriaJSON.fromJSON(json);
  }
  
  public static EntityTypeSearchCriteria fromJSONBytes(byte[] json) {
    return EntityTypeSearchCriteriaJSON.fromJSON(json);
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
    public EntityTypeSearchCriteria build() { return new EntityTypeSearchCriteria(name, numberOfResults, orderBy, startRow); }
  }
}
