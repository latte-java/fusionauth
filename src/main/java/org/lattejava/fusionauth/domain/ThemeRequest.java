/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ThemeRequestJSON;

@JSON
public record ThemeRequest(
    UUID sourceThemeId,
    Theme theme) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ThemeRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ThemeRequestJSON.toJSONBytes(this);
  }

  public static ThemeRequest fromJSON(String json) {
    return ThemeRequestJSON.fromJSON(json);
  }

  public static ThemeRequest fromJSONBytes(byte[] json) {
    return ThemeRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID sourceThemeId;
    private Theme theme;
    public Builder sourceThemeId(UUID sourceThemeId) { this.sourceThemeId = sourceThemeId; return this; }
    public Builder theme(Theme theme) { this.theme = theme; return this; }
    public ThemeRequest build() { return new ThemeRequest(sourceThemeId, theme); }
  }
}
