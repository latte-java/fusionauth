/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationSearchCriteriaJSON;

@JSON
public record ApplicationSearchCriteria(
    String name,
    ObjectState state,
    UUID tenantId,
    Boolean universal,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static ApplicationSearchCriteria fromJSON(String json) {
    return ApplicationSearchCriteriaJSON.fromJSON(json);
  }
  
  public static ApplicationSearchCriteria fromJSONBytes(byte[] json) {
    return ApplicationSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private String name;
    private ObjectState state;
    private UUID tenantId;
    private Boolean universal;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder name(String name) { this.name = name; return this; }
    public Builder state(ObjectState state) { this.state = state; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder universal(Boolean universal) { this.universal = universal; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public ApplicationSearchCriteria build() { return new ApplicationSearchCriteria(name, state, tenantId, universal, numberOfResults, orderBy, startRow); }
  }
}
