/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ThemeSearchRequestJSON;

@JSON
public record ThemeSearchRequest(
    ThemeSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ThemeSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ThemeSearchRequestJSON.toJSONBytes(this);
  }
  
  public static ThemeSearchRequest fromJSON(String json) {
    return ThemeSearchRequestJSON.fromJSON(json);
  }
  
  public static ThemeSearchRequest fromJSONBytes(byte[] json) {
    return ThemeSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private ThemeSearchCriteria search;
    public Builder search(ThemeSearchCriteria search) { this.search = search; return this; }
    public ThemeSearchRequest build() { return new ThemeSearchRequest(search); }
  }
}
