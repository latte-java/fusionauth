/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityTypeSearchRequestJSON;

@JSON
public record EntityTypeSearchRequest(
    EntityTypeSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityTypeSearchRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntityTypeSearchRequestJSON.toJSONBytes(this);
  }

  public static EntityTypeSearchRequest fromJSON(String json) {
    return EntityTypeSearchRequestJSON.fromJSON(json);
  }

  public static EntityTypeSearchRequest fromJSONBytes(byte[] json) {
    return EntityTypeSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EntityTypeSearchCriteria search;
    public Builder search(EntityTypeSearchCriteria search) { this.search = search; return this; }
    public EntityTypeSearchRequest build() { return new EntityTypeSearchRequest(search); }
  }
}
