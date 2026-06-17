/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SearchRequestJSON;

@JSON
public record SearchRequest(
    UserSearchCriteria search,
    List<String> expand) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SearchRequestJSON.toJSONBytes(this);
  }
  
  public static SearchRequest fromJSON(String json) {
    return SearchRequestJSON.fromJSON(json);
  }
  
  public static SearchRequest fromJSONBytes(byte[] json) {
    return SearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserSearchCriteria search;
    private List<String> expand;
    public Builder search(UserSearchCriteria search) { this.search = search; return this; }
    public Builder expand(List<String> expand) { this.expand = expand; return this; }
    public SearchRequest build() { return new SearchRequest(search, expand); }
  }
}
