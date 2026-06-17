/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogSearchCriteriaJSON;

@JSON
public record AuditLogSearchCriteria(
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant end,
    String message,
    String newValue,
    String oldValue,
    String reason,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant start,
    UUID tenantId,
    String user,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogSearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return AuditLogSearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static AuditLogSearchCriteria fromJSON(String json) {
    return AuditLogSearchCriteriaJSON.fromJSON(json);
  }
  
  public static AuditLogSearchCriteria fromJSONBytes(byte[] json) {
    return AuditLogSearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private Instant end;
    private String message;
    private String newValue;
    private String oldValue;
    private String reason;
    private Instant start;
    private UUID tenantId;
    private String user;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder end(Instant end) { this.end = end; return this; }
    public Builder message(String message) { this.message = message; return this; }
    public Builder newValue(String newValue) { this.newValue = newValue; return this; }
    public Builder oldValue(String oldValue) { this.oldValue = oldValue; return this; }
    public Builder reason(String reason) { this.reason = reason; return this; }
    public Builder start(Instant start) { this.start = start; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder user(String user) { this.user = user; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public AuditLogSearchCriteria build() { return new AuditLogSearchCriteria(end, message, newValue, oldValue, reason, start, tenantId, user, numberOfResults, orderBy, startRow); }
  }
}
