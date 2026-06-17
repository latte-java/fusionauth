/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupRequestJSON;

@JSON
public record GroupRequest(
    Group group,
    List<UUID> roleIds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupRequestJSON.toJSONBytes(this);
  }
  
  public static GroupRequest fromJSON(String json) {
    return GroupRequestJSON.fromJSON(json);
  }
  
  public static GroupRequest fromJSONBytes(byte[] json) {
    return GroupRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Group group;
    private List<UUID> roleIds;
    public Builder group(Group group) { this.group = group; return this; }
    public Builder roleIds(List<UUID> roleIds) { this.roleIds = roleIds; return this; }
    public GroupRequest build() { return new GroupRequest(group, roleIds); }
  }
}
