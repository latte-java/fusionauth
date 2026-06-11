/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogResponseJSON;

@JSON
public record AuditLogResponse(
    AuditLog auditLog) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AuditLogResponseJSON.toJSONBytes(this);
  }

  public static AuditLogResponse fromJSON(String json) {
    return AuditLogResponseJSON.fromJSON(json);
  }

  public static AuditLogResponse fromJSONBytes(byte[] json) {
    return AuditLogResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuditLog auditLog;
    public Builder auditLog(AuditLog auditLog) { this.auditLog = auditLog; return this; }
    public AuditLogResponse build() { return new AuditLogResponse(auditLog); }
  }
}
