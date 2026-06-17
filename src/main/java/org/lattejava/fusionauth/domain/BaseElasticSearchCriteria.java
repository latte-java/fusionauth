/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseElasticSearchCriteriaJSON;

@JSON
public record BaseElasticSearchCriteria(
    Boolean accurateTotal,
    List<UUID> ids,
    String nextResults,
    String query,
    String queryString,
    List<SortField> sortFields,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseElasticSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return BaseElasticSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static BaseElasticSearchCriteria fromJSON(String json) {
    return BaseElasticSearchCriteriaJSON.fromJSON(json);
  }
  
  public static BaseElasticSearchCriteria fromJSONBytes(byte[] json) {
    return BaseElasticSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean accurateTotal;
    private List<UUID> ids;
    private String nextResults;
    private String query;
    private String queryString;
    private List<SortField> sortFields;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder accurateTotal(Boolean accurateTotal) { this.accurateTotal = accurateTotal; return this; }
    public Builder ids(List<UUID> ids) { this.ids = ids; return this; }
    public Builder nextResults(String nextResults) { this.nextResults = nextResults; return this; }
    public Builder query(String query) { this.query = query; return this; }
    public Builder queryString(String queryString) { this.queryString = queryString; return this; }
    public Builder sortFields(List<SortField> sortFields) { this.sortFields = sortFields; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public BaseElasticSearchCriteria build() { return new BaseElasticSearchCriteria(accurateTotal, ids, nextResults, query, queryString, sortFields, numberOfResults, orderBy, startRow); }
  }
}
