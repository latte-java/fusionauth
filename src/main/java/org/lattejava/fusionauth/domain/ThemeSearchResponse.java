/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ThemeSearchResponseJSON;

@JSON
public record ThemeSearchResponse(
    List<Theme> themes,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ThemeSearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ThemeSearchResponseJSON.toJSONBytes(this);
  }
  
  public static ThemeSearchResponse fromJSON(String json) {
    return ThemeSearchResponseJSON.fromJSON(json);
  }
  
  public static ThemeSearchResponse fromJSONBytes(byte[] json) {
    return ThemeSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Theme> themes;
    private Long total;
    public Builder themes(List<Theme> themes) { this.themes = themes; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public ThemeSearchResponse build() { return new ThemeSearchResponse(themes, total); }
  }
}
