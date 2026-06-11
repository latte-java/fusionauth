/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SimpleThemeVariablesJSON;

@JSON
public record SimpleThemeVariables(
    String alertBackgroundColor,
    String alertFontColor,
    String backgroundImageURL,
    String backgroundSize,
    String borderRadius,
    String deleteButtonColor,
    String deleteButtonFocusColor,
    String deleteButtonTextColor,
    String deleteButtonTextFocusColor,
    String errorFontColor,
    String errorIconColor,
    List<Favicon> favicons,
    String fontColor,
    String fontFamily,
    Boolean footerDisplay,
    String iconBackgroundColor,
    String iconColor,
    String infoIconColor,
    String inputBackgroundColor,
    String inputIconColor,
    String inputTextColor,
    String linkTextColor,
    String linkTextFocusColor,
    String logoImageSize,
    String logoImageURL,
    String monoFontColor,
    String monoFontFamily,
    String pageBackgroundColor,
    String panelBackgroundColor,
    String primaryButtonColor,
    String primaryButtonFocusColor,
    String primaryButtonTextColor,
    String primaryButtonTextFocusColor) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SimpleThemeVariablesJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SimpleThemeVariablesJSON.toJSONBytes(this);
  }

  public static SimpleThemeVariables fromJSON(String json) {
    return SimpleThemeVariablesJSON.fromJSON(json);
  }

  public static SimpleThemeVariables fromJSONBytes(byte[] json) {
    return SimpleThemeVariablesJSON.fromJSON(json);
  }

  public static final class Builder {
    private String alertBackgroundColor;
    private String alertFontColor;
    private String backgroundImageURL;
    private String backgroundSize;
    private String borderRadius;
    private String deleteButtonColor;
    private String deleteButtonFocusColor;
    private String deleteButtonTextColor;
    private String deleteButtonTextFocusColor;
    private String errorFontColor;
    private String errorIconColor;
    private List<Favicon> favicons;
    private String fontColor;
    private String fontFamily;
    private Boolean footerDisplay;
    private String iconBackgroundColor;
    private String iconColor;
    private String infoIconColor;
    private String inputBackgroundColor;
    private String inputIconColor;
    private String inputTextColor;
    private String linkTextColor;
    private String linkTextFocusColor;
    private String logoImageSize;
    private String logoImageURL;
    private String monoFontColor;
    private String monoFontFamily;
    private String pageBackgroundColor;
    private String panelBackgroundColor;
    private String primaryButtonColor;
    private String primaryButtonFocusColor;
    private String primaryButtonTextColor;
    private String primaryButtonTextFocusColor;
    public Builder alertBackgroundColor(String alertBackgroundColor) { this.alertBackgroundColor = alertBackgroundColor; return this; }
    public Builder alertFontColor(String alertFontColor) { this.alertFontColor = alertFontColor; return this; }
    public Builder backgroundImageURL(String backgroundImageURL) { this.backgroundImageURL = backgroundImageURL; return this; }
    public Builder backgroundSize(String backgroundSize) { this.backgroundSize = backgroundSize; return this; }
    public Builder borderRadius(String borderRadius) { this.borderRadius = borderRadius; return this; }
    public Builder deleteButtonColor(String deleteButtonColor) { this.deleteButtonColor = deleteButtonColor; return this; }
    public Builder deleteButtonFocusColor(String deleteButtonFocusColor) { this.deleteButtonFocusColor = deleteButtonFocusColor; return this; }
    public Builder deleteButtonTextColor(String deleteButtonTextColor) { this.deleteButtonTextColor = deleteButtonTextColor; return this; }
    public Builder deleteButtonTextFocusColor(String deleteButtonTextFocusColor) { this.deleteButtonTextFocusColor = deleteButtonTextFocusColor; return this; }
    public Builder errorFontColor(String errorFontColor) { this.errorFontColor = errorFontColor; return this; }
    public Builder errorIconColor(String errorIconColor) { this.errorIconColor = errorIconColor; return this; }
    public Builder favicons(List<Favicon> favicons) { this.favicons = favicons; return this; }
    public Builder fontColor(String fontColor) { this.fontColor = fontColor; return this; }
    public Builder fontFamily(String fontFamily) { this.fontFamily = fontFamily; return this; }
    public Builder footerDisplay(Boolean footerDisplay) { this.footerDisplay = footerDisplay; return this; }
    public Builder iconBackgroundColor(String iconBackgroundColor) { this.iconBackgroundColor = iconBackgroundColor; return this; }
    public Builder iconColor(String iconColor) { this.iconColor = iconColor; return this; }
    public Builder infoIconColor(String infoIconColor) { this.infoIconColor = infoIconColor; return this; }
    public Builder inputBackgroundColor(String inputBackgroundColor) { this.inputBackgroundColor = inputBackgroundColor; return this; }
    public Builder inputIconColor(String inputIconColor) { this.inputIconColor = inputIconColor; return this; }
    public Builder inputTextColor(String inputTextColor) { this.inputTextColor = inputTextColor; return this; }
    public Builder linkTextColor(String linkTextColor) { this.linkTextColor = linkTextColor; return this; }
    public Builder linkTextFocusColor(String linkTextFocusColor) { this.linkTextFocusColor = linkTextFocusColor; return this; }
    public Builder logoImageSize(String logoImageSize) { this.logoImageSize = logoImageSize; return this; }
    public Builder logoImageURL(String logoImageURL) { this.logoImageURL = logoImageURL; return this; }
    public Builder monoFontColor(String monoFontColor) { this.monoFontColor = monoFontColor; return this; }
    public Builder monoFontFamily(String monoFontFamily) { this.monoFontFamily = monoFontFamily; return this; }
    public Builder pageBackgroundColor(String pageBackgroundColor) { this.pageBackgroundColor = pageBackgroundColor; return this; }
    public Builder panelBackgroundColor(String panelBackgroundColor) { this.panelBackgroundColor = panelBackgroundColor; return this; }
    public Builder primaryButtonColor(String primaryButtonColor) { this.primaryButtonColor = primaryButtonColor; return this; }
    public Builder primaryButtonFocusColor(String primaryButtonFocusColor) { this.primaryButtonFocusColor = primaryButtonFocusColor; return this; }
    public Builder primaryButtonTextColor(String primaryButtonTextColor) { this.primaryButtonTextColor = primaryButtonTextColor; return this; }
    public Builder primaryButtonTextFocusColor(String primaryButtonTextFocusColor) { this.primaryButtonTextFocusColor = primaryButtonTextFocusColor; return this; }
    public SimpleThemeVariables build() { return new SimpleThemeVariables(alertBackgroundColor, alertFontColor, backgroundImageURL, backgroundSize, borderRadius, deleteButtonColor, deleteButtonFocusColor, deleteButtonTextColor, deleteButtonTextFocusColor, errorFontColor, errorIconColor, favicons, fontColor, fontFamily, footerDisplay, iconBackgroundColor, iconColor, infoIconColor, inputBackgroundColor, inputIconColor, inputTextColor, linkTextColor, linkTextFocusColor, logoImageSize, logoImageURL, monoFontColor, monoFontFamily, pageBackgroundColor, panelBackgroundColor, primaryButtonColor, primaryButtonFocusColor, primaryButtonTextColor, primaryButtonTextFocusColor); }
  }
}
