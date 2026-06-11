/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupResponseJSON;

@JSON
public record GroupResponse(
    Group group,
    List<Group> groups) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GroupResponseJSON.toJSONBytes(this);
  }

  public static GroupResponse fromJSON(String json) {
    return GroupResponseJSON.fromJSON(json);
  }

  public static GroupResponse fromJSONBytes(byte[] json) {
    return GroupResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Group group;
    private List<Group> groups;
    public Builder group(Group group) { this.group = group; return this; }
    public Builder groups(List<Group> groups) { this.groups = groups; return this; }
    public GroupResponse build() { return new GroupResponse(group, groups); }
  }
}
