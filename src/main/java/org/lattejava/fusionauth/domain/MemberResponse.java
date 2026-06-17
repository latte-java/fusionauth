/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MemberResponseJSON;

@JSON
public record MemberResponse(
    Map<String, List<GroupMember>> members) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MemberResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MemberResponseJSON.toJSONBytes(this);
  }
  
  public static MemberResponse fromJSON(String json) {
    return MemberResponseJSON.fromJSON(json);
  }
  
  public static MemberResponse fromJSONBytes(byte[] json) {
    return MemberResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, List<GroupMember>> members;
    public Builder members(Map<String, List<GroupMember>> members) { this.members = members; return this; }
    public MemberResponse build() { return new MemberResponse(members); }
  }
}
