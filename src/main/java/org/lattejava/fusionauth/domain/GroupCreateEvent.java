/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupCreateEventJSON;

@JSON
public record GroupCreateEvent(
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupCreateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GroupCreateEventJSON.toJSONBytes(this);
  }

  public static GroupCreateEvent fromJSON(String json) {
    return GroupCreateEventJSON.fromJSON(json);
  }

  public static GroupCreateEvent fromJSONBytes(byte[] json) {
    return GroupCreateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private Group group;
    public Builder group(Group group) { this.group = group; return this; }
    public GroupCreateEvent build() { return new GroupCreateEvent(group); }
  }
}
