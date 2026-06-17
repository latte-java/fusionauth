/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCommentSearchCriteriaJSON;

@JSON
public record UserCommentSearchCriteria(
    String comment,
    UUID commenterId,
    UUID tenantId,
    UUID userId,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCommentSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserCommentSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static UserCommentSearchCriteria fromJSON(String json) {
    return UserCommentSearchCriteriaJSON.fromJSON(json);
  }
  
  public static UserCommentSearchCriteria fromJSONBytes(byte[] json) {
    return UserCommentSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private String comment;
    private UUID commenterId;
    private UUID tenantId;
    private UUID userId;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder comment(String comment) { this.comment = comment; return this; }
    public Builder commenterId(UUID commenterId) { this.commenterId = commenterId; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public UserCommentSearchCriteria build() { return new UserCommentSearchCriteria(comment, commenterId, tenantId, userId, numberOfResults, orderBy, startRow); }
  }
}
