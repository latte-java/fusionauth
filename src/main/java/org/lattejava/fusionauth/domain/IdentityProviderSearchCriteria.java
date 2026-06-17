/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderSearchCriteriaJSON;

@JSON
public record IdentityProviderSearchCriteria(
    UUID applicationId,
    String name,
    String source,
    UUID tenantId,
    IdentityProviderType type,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderSearchCriteria fromJSON(String json) {
    return IdentityProviderSearchCriteriaJSON.fromJSON(json);
  }
  
  public static IdentityProviderSearchCriteria fromJSONBytes(byte[] json) {
    return IdentityProviderSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String name;
    private String source;
    private UUID tenantId;
    private IdentityProviderType type;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder source(String source) { this.source = source; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(IdentityProviderType type) { this.type = type; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public IdentityProviderSearchCriteria build() { return new IdentityProviderSearchCriteria(applicationId, name, source, tenantId, type, numberOfResults, orderBy, startRow); }
  }
}
