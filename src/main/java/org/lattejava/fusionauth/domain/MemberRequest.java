/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MemberRequestJSON;

@JSON
public record MemberRequest(
    List<GroupMember> members) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MemberRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MemberRequestJSON.toJSONBytes(this);
  }

  public static MemberRequest fromJSON(String json) {
    return MemberRequestJSON.fromJSON(json);
  }

  public static MemberRequest fromJSONBytes(byte[] json) {
    return MemberRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<GroupMember> members;
    public Builder members(List<GroupMember> members) { this.members = members; return this; }
    public MemberRequest build() { return new MemberRequest(members); }
  }
}
