/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberSearchCriteriaJSON;

@JSON
public record GroupMemberSearchCriteria(
    UUID groupId,
    UUID tenantId,
    UUID userId,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberSearchCriteriaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GroupMemberSearchCriteriaJSON.toJSONBytes(this);
  }

  public static GroupMemberSearchCriteria fromJSON(String json) {
    return GroupMemberSearchCriteriaJSON.fromJSON(json);
  }

  public static GroupMemberSearchCriteria fromJSONBytes(byte[] json) {
    return GroupMemberSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID groupId;
    private UUID tenantId;
    private UUID userId;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder groupId(UUID groupId) { this.groupId = groupId; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public GroupMemberSearchCriteria build() { return new GroupMemberSearchCriteria(groupId, tenantId, userId, numberOfResults, orderBy, startRow); }
  }
}
