/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityGrantSearchResponseJSON;

@JSON
public record EntityGrantSearchResponse(
    List<EntityGrant> grants,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityGrantSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntityGrantSearchResponseJSON.toJSONBytes(this);
  }

  public static EntityGrantSearchResponse fromJSON(String json) {
    return EntityGrantSearchResponseJSON.fromJSON(json);
  }

  public static EntityGrantSearchResponse fromJSONBytes(byte[] json) {
    return EntityGrantSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<EntityGrant> grants;
    private Long total;
    public Builder grants(List<EntityGrant> grants) { this.grants = grants; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public EntityGrantSearchResponse build() { return new EntityGrantSearchResponse(grants, total); }
  }
}
