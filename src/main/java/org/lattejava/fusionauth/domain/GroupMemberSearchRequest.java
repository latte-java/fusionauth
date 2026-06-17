/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberSearchRequestJSON;

@JSON
public record GroupMemberSearchRequest(
    GroupMemberSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupMemberSearchRequestJSON.toJSONBytes(this);
  }
  
  public static GroupMemberSearchRequest fromJSON(String json) {
    return GroupMemberSearchRequestJSON.fromJSON(json);
  }
  
  public static GroupMemberSearchRequest fromJSONBytes(byte[] json) {
    return GroupMemberSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private GroupMemberSearchCriteria search;
    public Builder search(GroupMemberSearchCriteria search) { this.search = search; return this; }
    public GroupMemberSearchRequest build() { return new GroupMemberSearchRequest(search); }
  }
}
