/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SearchResultsJSON;

@JSON
public record SearchResults(
    String nextResults,
    List<String> results,
    Long total,
    Boolean totalEqualToActual) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SearchResultsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SearchResultsJSON.toJSONBytes(this);
  }

  public static SearchResults fromJSON(String json) {
    return SearchResultsJSON.fromJSON(json);
  }

  public static SearchResults fromJSONBytes(byte[] json) {
    return SearchResultsJSON.fromJSON(json);
  }

  public static final class Builder {
    private String nextResults;
    private List<String> results;
    private Long total;
    private Boolean totalEqualToActual;
    public Builder nextResults(String nextResults) { this.nextResults = nextResults; return this; }
    public Builder results(List<String> results) { this.results = results; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public Builder totalEqualToActual(Boolean totalEqualToActual) { this.totalEqualToActual = totalEqualToActual; return this; }
    public SearchResults build() { return new SearchResults(nextResults, results, total, totalEqualToActual); }
  }
}
