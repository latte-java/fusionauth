/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupDeleteEventJSON;

@JSON
public record GroupDeleteEvent(
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupDeleteEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GroupDeleteEventJSON.toJSONBytes(this);
  }

  public static GroupDeleteEvent fromJSON(String json) {
    return GroupDeleteEventJSON.fromJSON(json);
  }

  public static GroupDeleteEvent fromJSONBytes(byte[] json) {
    return GroupDeleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private Group group;
    public Builder group(Group group) { this.group = group; return this; }
    public GroupDeleteEvent build() { return new GroupDeleteEvent(group); }
  }
}
