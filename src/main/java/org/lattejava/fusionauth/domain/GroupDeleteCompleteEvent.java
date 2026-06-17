/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupDeleteCompleteEventJSON;

@JSON
public record GroupDeleteCompleteEvent(
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupDeleteCompleteEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupDeleteCompleteEventJSON.toJSONBytes(this);
  }
  
  public static GroupDeleteCompleteEvent fromJSON(String json) {
    return GroupDeleteCompleteEventJSON.fromJSON(json);
  }
  
  public static GroupDeleteCompleteEvent fromJSONBytes(byte[] json) {
    return GroupDeleteCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private Group group;
    public Builder group(Group group) { this.group = group; return this; }
    public GroupDeleteCompleteEvent build() { return new GroupDeleteCompleteEvent(group); }
  }
}
