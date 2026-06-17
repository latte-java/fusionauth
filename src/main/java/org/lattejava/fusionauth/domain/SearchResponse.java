/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SearchResponseJSON;

@JSON
public record SearchResponse(
    Long total,
    String nextResults,
    List<User> users,
    List<String> expandable) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SearchResponseJSON.toJSONBytes(this);
  }
  
  public static SearchResponse fromJSON(String json) {
    return SearchResponseJSON.fromJSON(json);
  }
  
  public static SearchResponse fromJSONBytes(byte[] json) {
    return SearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Long total;
    private String nextResults;
    private List<User> users;
    private List<String> expandable;
    public Builder total(Long total) { this.total = total; return this; }
    public Builder nextResults(String nextResults) { this.nextResults = nextResults; return this; }
    public Builder users(List<User> users) { this.users = users; return this; }
    public Builder expandable(List<String> expandable) { this.expandable = expandable; return this; }
    public SearchResponse build() { return new SearchResponse(total, nextResults, users, expandable); }
  }
}
