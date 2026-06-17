/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginRecordSearchCriteriaJSON;

@JSON
public record LoginRecordSearchCriteria(
    UUID applicationId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant end,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant start,
    UUID userId,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginRecordSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginRecordSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static LoginRecordSearchCriteria fromJSON(String json) {
    return LoginRecordSearchCriteriaJSON.fromJSON(json);
  }
  
  public static LoginRecordSearchCriteria fromJSONBytes(byte[] json) {
    return LoginRecordSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private Instant end;
    private Instant start;
    private UUID userId;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder end(Instant end) { this.end = end; return this; }
    public Builder start(Instant start) { this.start = start; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public LoginRecordSearchCriteria build() { return new LoginRecordSearchCriteria(applicationId, end, start, userId, numberOfResults, orderBy, startRow); }
  }
}
