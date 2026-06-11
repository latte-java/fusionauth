/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogSearchResponseJSON;

@JSON
public record AuditLogSearchResponse(
    List<AuditLog> auditLogs,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AuditLogSearchResponseJSON.toJSONBytes(this);
  }

  public static AuditLogSearchResponse fromJSON(String json) {
    return AuditLogSearchResponseJSON.fromJSON(json);
  }

  public static AuditLogSearchResponse fromJSONBytes(byte[] json) {
    return AuditLogSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<AuditLog> auditLogs;
    private Long total;
    public Builder auditLogs(List<AuditLog> auditLogs) { this.auditLogs = auditLogs; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public AuditLogSearchResponse build() { return new AuditLogSearchResponse(auditLogs, total); }
  }
}
