/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LambdaSearchCriteriaJSON;

@JSON
public record LambdaSearchCriteria(
    String body,
    String name,
    LambdaType type,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LambdaSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LambdaSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static LambdaSearchCriteria fromJSON(String json) {
    return LambdaSearchCriteriaJSON.fromJSON(json);
  }
  
  public static LambdaSearchCriteria fromJSONBytes(byte[] json) {
    return LambdaSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private String body;
    private String name;
    private LambdaType type;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder body(String body) { this.body = body; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(LambdaType type) { this.type = type; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public LambdaSearchCriteria build() { return new LambdaSearchCriteria(body, name, type, numberOfResults, orderBy, startRow); }
  }
}
