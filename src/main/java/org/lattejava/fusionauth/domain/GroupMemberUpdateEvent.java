/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberUpdateEventJSON;

@JSON
public record GroupMemberUpdateEvent(
    List<GroupMember> members,
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberUpdateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GroupMemberUpdateEventJSON.toJSONBytes(this);
  }

  public static GroupMemberUpdateEvent fromJSON(String json) {
    return GroupMemberUpdateEventJSON.fromJSON(json);
  }

  public static GroupMemberUpdateEvent fromJSONBytes(byte[] json) {
    return GroupMemberUpdateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<GroupMember> members;
    private Group group;
    public Builder members(List<GroupMember> members) { this.members = members; return this; }
    public Builder group(Group group) { this.group = group; return this; }
    public GroupMemberUpdateEvent build() { return new GroupMemberUpdateEvent(members, group); }
  }
}
