/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupSearchRequestJSON;

@JSON
public record GroupSearchRequest(
    GroupSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupSearchRequestJSON.toJSONBytes(this);
  }
  
  public static GroupSearchRequest fromJSON(String json) {
    return GroupSearchRequestJSON.fromJSON(json);
  }
  
  public static GroupSearchRequest fromJSONBytes(byte[] json) {
    return GroupSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private GroupSearchCriteria search;
    public Builder search(GroupSearchCriteria search) { this.search = search; return this; }
    public GroupSearchRequest build() { return new GroupSearchRequest(search); }
  }
}
