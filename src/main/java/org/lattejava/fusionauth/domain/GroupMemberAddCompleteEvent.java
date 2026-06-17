/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberAddCompleteEventJSON;

@JSON
public record GroupMemberAddCompleteEvent(
    List<GroupMember> members,
    Group group) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberAddCompleteEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupMemberAddCompleteEventJSON.toJSONBytes(this);
  }
  
  public static GroupMemberAddCompleteEvent fromJSON(String json) {
    return GroupMemberAddCompleteEventJSON.fromJSON(json);
  }
  
  public static GroupMemberAddCompleteEvent fromJSONBytes(byte[] json) {
    return GroupMemberAddCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<GroupMember> members;
    private Group group;
    public Builder members(List<GroupMember> members) { this.members = members; return this; }
    public Builder group(Group group) { this.group = group; return this; }
    public GroupMemberAddCompleteEvent build() { return new GroupMemberAddCompleteEvent(members, group); }
  }
}
