/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupUpdateEventJSON;

@JSON
public record GroupUpdateEvent(
    Group original,
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupUpdateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GroupUpdateEventJSON.toJSONBytes(this);
  }

  public static GroupUpdateEvent fromJSON(String json) {
    return GroupUpdateEventJSON.fromJSON(json);
  }

  public static GroupUpdateEvent fromJSONBytes(byte[] json) {
    return GroupUpdateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private Group original;
    private Group group;
    public Builder original(Group original) { this.original = original; return this; }
    public Builder group(Group group) { this.group = group; return this; }
    public GroupUpdateEvent build() { return new GroupUpdateEvent(original, group); }
  }
}
