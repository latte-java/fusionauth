/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityGrantSearchCriteriaJSON;

@JSON
public record EntityGrantSearchCriteria(
    UUID entityId,
    String name,
    UUID userId,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityGrantSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityGrantSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static EntityGrantSearchCriteria fromJSON(String json) {
    return EntityGrantSearchCriteriaJSON.fromJSON(json);
  }
  
  public static EntityGrantSearchCriteria fromJSONBytes(byte[] json) {
    return EntityGrantSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID entityId;
    private String name;
    private UUID userId;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder entityId(UUID entityId) { this.entityId = entityId; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public EntityGrantSearchCriteria build() { return new EntityGrantSearchCriteria(entityId, name, userId, numberOfResults, orderBy, startRow); }
  }
}
