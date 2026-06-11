/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupSearchResponseJSON;

@JSON
public record GroupSearchResponse(
    List<Group> groups,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GroupSearchResponseJSON.toJSONBytes(this);
  }

  public static GroupSearchResponse fromJSON(String json) {
    return GroupSearchResponseJSON.fromJSON(json);
  }

  public static GroupSearchResponse fromJSONBytes(byte[] json) {
    return GroupSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Group> groups;
    private Long total;
    public Builder groups(List<Group> groups) { this.groups = groups; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public GroupSearchResponse build() { return new GroupSearchResponse(groups, total); }
  }
}
