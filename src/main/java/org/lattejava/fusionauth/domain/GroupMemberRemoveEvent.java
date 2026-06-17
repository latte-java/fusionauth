/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberRemoveEventJSON;

@JSON
public record GroupMemberRemoveEvent(
    List<GroupMember> members,
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberRemoveEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupMemberRemoveEventJSON.toJSONBytes(this);
  }
  
  public static GroupMemberRemoveEvent fromJSON(String json) {
    return GroupMemberRemoveEventJSON.fromJSON(json);
  }
  
  public static GroupMemberRemoveEvent fromJSONBytes(byte[] json) {
    return GroupMemberRemoveEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<GroupMember> members;
    private Group group;
    public Builder members(List<GroupMember> members) { this.members = members; return this; }
    public Builder group(Group group) { this.group = group; return this; }
    public GroupMemberRemoveEvent build() { return new GroupMemberRemoveEvent(members, group); }
  }
}
