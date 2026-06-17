/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupSearchCriteriaJSON;

@JSON
public record GroupSearchCriteria(
    String name,
    UUID tenantId,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static GroupSearchCriteria fromJSON(String json) {
    return GroupSearchCriteriaJSON.fromJSON(json);
  }
  
  public static GroupSearchCriteria fromJSONBytes(byte[] json) {
    return GroupSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private String name;
    private UUID tenantId;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder name(String name) { this.name = name; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public GroupSearchCriteria build() { return new GroupSearchCriteria(name, tenantId, numberOfResults, orderBy, startRow); }
  }
}
