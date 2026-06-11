/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserSearchCriteriaJSON;

@JSON
public record UserSearchCriteria(
    Boolean accurateTotal,
    List<UUID> ids,
    String nextResults,
    String query,
    String queryString,
    List<SortField> sortFields) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserSearchCriteriaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserSearchCriteriaJSON.toJSONBytes(this);
  }

  public static UserSearchCriteria fromJSON(String json) {
    return UserSearchCriteriaJSON.fromJSON(json);
  }

  public static UserSearchCriteria fromJSONBytes(byte[] json) {
    return UserSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean accurateTotal;
    private List<UUID> ids;
    private String nextResults;
    private String query;
    private String queryString;
    private List<SortField> sortFields;
    public Builder accurateTotal(Boolean accurateTotal) { this.accurateTotal = accurateTotal; return this; }
    public Builder ids(List<UUID> ids) { this.ids = ids; return this; }
    public Builder nextResults(String nextResults) { this.nextResults = nextResults; return this; }
    public Builder query(String query) { this.query = query; return this; }
    public Builder queryString(String queryString) { this.queryString = queryString; return this; }
    public Builder sortFields(List<SortField> sortFields) { this.sortFields = sortFields; return this; }
    public UserSearchCriteria build() { return new UserSearchCriteria(accurateTotal, ids, nextResults, query, queryString, sortFields); }
  }
}
