/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MemberDeleteRequestJSON;

@JSON
public record MemberDeleteRequest(
    List<UUID> memberIds,
    List<UUID> members) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MemberDeleteRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MemberDeleteRequestJSON.toJSONBytes(this);
  }

  public static MemberDeleteRequest fromJSON(String json) {
    return MemberDeleteRequestJSON.fromJSON(json);
  }

  public static MemberDeleteRequest fromJSONBytes(byte[] json) {
    return MemberDeleteRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<UUID> memberIds;
    private List<UUID> members;
    public Builder memberIds(List<UUID> memberIds) { this.memberIds = memberIds; return this; }
    public Builder members(List<UUID> members) { this.members = members; return this; }
    public MemberDeleteRequest build() { return new MemberDeleteRequest(memberIds, members); }
  }
}
