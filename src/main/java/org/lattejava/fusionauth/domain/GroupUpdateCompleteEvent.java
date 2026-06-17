/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupUpdateCompleteEventJSON;

@JSON
public record GroupUpdateCompleteEvent(
    Group original,
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupUpdateCompleteEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupUpdateCompleteEventJSON.toJSONBytes(this);
  }
  
  public static GroupUpdateCompleteEvent fromJSON(String json) {
    return GroupUpdateCompleteEventJSON.fromJSON(json);
  }
  
  public static GroupUpdateCompleteEvent fromJSONBytes(byte[] json) {
    return GroupUpdateCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private Group original;
    private Group group;
    public Builder original(Group original) { this.original = original; return this; }
    public Builder group(Group group) { this.group = group; return this; }
    public GroupUpdateCompleteEvent build() { return new GroupUpdateCompleteEvent(original, group); }
  }
}
