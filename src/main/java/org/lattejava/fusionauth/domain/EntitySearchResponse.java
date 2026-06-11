/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntitySearchResponseJSON;

@JSON
public record EntitySearchResponse(
    List<Entity> entities,
    String nextResults,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntitySearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntitySearchResponseJSON.toJSONBytes(this);
  }

  public static EntitySearchResponse fromJSON(String json) {
    return EntitySearchResponseJSON.fromJSON(json);
  }

  public static EntitySearchResponse fromJSONBytes(byte[] json) {
    return EntitySearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Entity> entities;
    private String nextResults;
    private Long total;
    public Builder entities(List<Entity> entities) { this.entities = entities; return this; }
    public Builder nextResults(String nextResults) { this.nextResults = nextResults; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public EntitySearchResponse build() { return new EntitySearchResponse(entities, nextResults, total); }
  }
}
