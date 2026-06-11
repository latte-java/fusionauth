/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityTypeSearchResponseJSON;

@JSON
public record EntityTypeSearchResponse(
    List<EntityType> entityTypes,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityTypeSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntityTypeSearchResponseJSON.toJSONBytes(this);
  }

  public static EntityTypeSearchResponse fromJSON(String json) {
    return EntityTypeSearchResponseJSON.fromJSON(json);
  }

  public static EntityTypeSearchResponse fromJSONBytes(byte[] json) {
    return EntityTypeSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<EntityType> entityTypes;
    private Long total;
    public Builder entityTypes(List<EntityType> entityTypes) { this.entityTypes = entityTypes; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public EntityTypeSearchResponse build() { return new EntityTypeSearchResponse(entityTypes, total); }
  }
}
