/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogCreateEventJSON;

@JSON
public record AuditLogCreateEvent(
    AuditLog auditLog,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogCreateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return AuditLogCreateEventJSON.toJSONBytes(this);
  }
  
  public static AuditLogCreateEvent fromJSON(String json) {
    return AuditLogCreateEventJSON.fromJSON(json);
  }
  
  public static AuditLogCreateEvent fromJSONBytes(byte[] json) {
    return AuditLogCreateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuditLog auditLog;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder auditLog(AuditLog auditLog) { this.auditLog = auditLog; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public AuditLogCreateEvent build() { return new AuditLogCreateEvent(auditLog, createInstant, id, info, tenantId, type); }
  }
}
