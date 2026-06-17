/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityGrantSearchRequestJSON;

@JSON
public record EntityGrantSearchRequest(
    EntityGrantSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityGrantSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityGrantSearchRequestJSON.toJSONBytes(this);
  }
  
  public static EntityGrantSearchRequest fromJSON(String json) {
    return EntityGrantSearchRequestJSON.fromJSON(json);
  }
  
  public static EntityGrantSearchRequest fromJSONBytes(byte[] json) {
    return EntityGrantSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EntityGrantSearchCriteria search;
    public Builder search(EntityGrantSearchCriteria search) { this.search = search; return this; }
    public EntityGrantSearchRequest build() { return new EntityGrantSearchRequest(search); }
  }
}
