/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UIConfigurationJSON;

@JSON
public record UIConfiguration(
    String headerColor,
    String logoURL,
    String menuFontColor) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UIConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UIConfigurationJSON.toJSONBytes(this);
  }

  public static UIConfiguration fromJSON(String json) {
    return UIConfigurationJSON.fromJSON(json);
  }

  public static UIConfiguration fromJSONBytes(byte[] json) {
    return UIConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String headerColor;
    private String logoURL;
    private String menuFontColor;
    public Builder headerColor(String headerColor) { this.headerColor = headerColor; return this; }
    public Builder logoURL(String logoURL) { this.logoURL = logoURL; return this; }
    public Builder menuFontColor(String menuFontColor) { this.menuFontColor = menuFontColor; return this; }
    public UIConfiguration build() { return new UIConfiguration(headerColor, logoURL, menuFontColor); }
  }
}
