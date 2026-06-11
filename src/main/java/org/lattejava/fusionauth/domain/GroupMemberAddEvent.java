/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberAddEventJSON;

@JSON
public record GroupMemberAddEvent(
    List<GroupMember> members,
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberAddEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GroupMemberAddEventJSON.toJSONBytes(this);
  }

  public static GroupMemberAddEvent fromJSON(String json) {
    return GroupMemberAddEventJSON.fromJSON(json);
  }

  public static GroupMemberAddEvent fromJSONBytes(byte[] json) {
    return GroupMemberAddEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<GroupMember> members;
    private Group group;
    public Builder members(List<GroupMember> members) { this.members = members; return this; }
    public Builder group(Group group) { this.group = group; return this; }
    public GroupMemberAddEvent build() { return new GroupMemberAddEvent(members, group); }
  }
}
