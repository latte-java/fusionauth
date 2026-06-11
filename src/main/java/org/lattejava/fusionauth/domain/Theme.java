/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ThemeJSON;

@JSON
public record Theme(
    Map<String, Object> data,
    String defaultMessages,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    LocalizedStrings localizedMessages,
    String name,
    String stylesheet,
    Templates templates,
    ThemeType type,
    SimpleThemeVariables variables) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ThemeJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ThemeJSON.toJSONBytes(this);
  }

  public static Theme fromJSON(String json) {
    return ThemeJSON.fromJSON(json);
  }

  public static Theme fromJSONBytes(byte[] json) {
    return ThemeJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private String defaultMessages;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private LocalizedStrings localizedMessages;
    private String name;
    private String stylesheet;
    private Templates templates;
    private ThemeType type;
    private SimpleThemeVariables variables;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder defaultMessages(String defaultMessages) { this.defaultMessages = defaultMessages; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder localizedMessages(LocalizedStrings localizedMessages) { this.localizedMessages = localizedMessages; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder stylesheet(String stylesheet) { this.stylesheet = stylesheet; return this; }
    public Builder templates(Templates templates) { this.templates = templates; return this; }
    public Builder type(ThemeType type) { this.type = type; return this; }
    public Builder variables(SimpleThemeVariables variables) { this.variables = variables; return this; }
    public Theme build() { return new Theme(data, defaultMessages, id, insertInstant, lastUpdateInstant, localizedMessages, name, stylesheet, templates, type, variables); }
  }
}
