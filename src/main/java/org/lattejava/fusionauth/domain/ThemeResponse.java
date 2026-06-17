/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ThemeResponseJSON;

@JSON
public record ThemeResponse(
    Theme theme,
    List<Theme> themes) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ThemeResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ThemeResponseJSON.toJSONBytes(this);
  }
  
  public static ThemeResponse fromJSON(String json) {
    return ThemeResponseJSON.fromJSON(json);
  }
  
  public static ThemeResponse fromJSONBytes(byte[] json) {
    return ThemeResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Theme theme;
    private List<Theme> themes;
    public Builder theme(Theme theme) { this.theme = theme; return this; }
    public Builder themes(List<Theme> themes) { this.themes = themes; return this; }
    public ThemeResponse build() { return new ThemeResponse(theme, themes); }
  }
}
