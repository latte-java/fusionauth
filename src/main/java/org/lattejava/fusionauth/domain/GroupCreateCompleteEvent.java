/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupCreateCompleteEventJSON;

@JSON
public record GroupCreateCompleteEvent(
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupCreateCompleteEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupCreateCompleteEventJSON.toJSONBytes(this);
  }
  
  public static GroupCreateCompleteEvent fromJSON(String json) {
    return GroupCreateCompleteEventJSON.fromJSON(json);
  }
  
  public static GroupCreateCompleteEvent fromJSONBytes(byte[] json) {
    return GroupCreateCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private Group group;
    public Builder group(Group group) { this.group = group; return this; }
    public GroupCreateCompleteEvent build() { return new GroupCreateCompleteEvent(group); }
  }
}
