/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogRequestJSON;

@JSON
public record AuditLogRequest(
    AuditLog auditLog,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AuditLogRequestJSON.toJSONBytes(this);
  }

  public static AuditLogRequest fromJSON(String json) {
    return AuditLogRequestJSON.fromJSON(json);
  }

  public static AuditLogRequest fromJSONBytes(byte[] json) {
    return AuditLogRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuditLog auditLog;
    private EventInfo eventInfo;
    public Builder auditLog(AuditLog auditLog) { this.auditLog = auditLog; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public AuditLogRequest build() { return new AuditLogRequest(auditLog, eventInfo); }
  }
}
