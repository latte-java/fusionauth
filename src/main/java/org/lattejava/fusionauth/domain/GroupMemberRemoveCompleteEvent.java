/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberRemoveCompleteEventJSON;

@JSON
public record GroupMemberRemoveCompleteEvent(
    List<GroupMember> members,
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberRemoveCompleteEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupMemberRemoveCompleteEventJSON.toJSONBytes(this);
  }
  
  public static GroupMemberRemoveCompleteEvent fromJSON(String json) {
    return GroupMemberRemoveCompleteEventJSON.fromJSON(json);
  }
  
  public static GroupMemberRemoveCompleteEvent fromJSONBytes(byte[] json) {
    return GroupMemberRemoveCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<GroupMember> members;
    private Group group;
    public Builder members(List<GroupMember> members) { this.members = members; return this; }
    public Builder group(Group group) { this.group = group; return this; }
    public GroupMemberRemoveCompleteEvent build() { return new GroupMemberRemoveCompleteEvent(members, group); }
  }
}
