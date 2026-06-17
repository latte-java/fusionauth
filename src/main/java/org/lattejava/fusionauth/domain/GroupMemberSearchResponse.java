/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberSearchResponseJSON;

@JSON
public record GroupMemberSearchResponse(
    List<GroupMember> members,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberSearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupMemberSearchResponseJSON.toJSONBytes(this);
  }
  
  public static GroupMemberSearchResponse fromJSON(String json) {
    return GroupMemberSearchResponseJSON.fromJSON(json);
  }
  
  public static GroupMemberSearchResponse fromJSONBytes(byte[] json) {
    return GroupMemberSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<GroupMember> members;
    private Long total;
    public Builder members(List<GroupMember> members) { this.members = members; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public GroupMemberSearchResponse build() { return new GroupMemberSearchResponse(members, total); }
  }
}
