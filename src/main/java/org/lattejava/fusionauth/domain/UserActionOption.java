/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionOptionJSON;

@JSON
public record UserActionOption(
    LocalizedStrings localizedNames,
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionOptionJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserActionOptionJSON.toJSONBytes(this);
  }
  
  public static UserActionOption fromJSON(String json) {
    return UserActionOptionJSON.fromJSON(json);
  }
  
  public static UserActionOption fromJSONBytes(byte[] json) {
    return UserActionOptionJSON.fromJSON(json);
  }

  public static final class Builder {
    private LocalizedStrings localizedNames;
    private String name;
    public Builder localizedNames(LocalizedStrings localizedNames) { this.localizedNames = localizedNames; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public UserActionOption build() { return new UserActionOption(localizedNames, name); }
  }
}
