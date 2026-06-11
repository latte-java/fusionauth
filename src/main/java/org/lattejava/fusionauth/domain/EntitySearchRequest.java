/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntitySearchRequestJSON;

@JSON
public record EntitySearchRequest(
    EntitySearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntitySearchRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntitySearchRequestJSON.toJSONBytes(this);
  }

  public static EntitySearchRequest fromJSON(String json) {
    return EntitySearchRequestJSON.fromJSON(json);
  }

  public static EntitySearchRequest fromJSONBytes(byte[] json) {
    return EntitySearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EntitySearchCriteria search;
    public Builder search(EntitySearchCriteria search) { this.search = search; return this; }
    public EntitySearchRequest build() { return new EntitySearchRequest(search); }
  }
}
