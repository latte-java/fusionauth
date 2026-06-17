/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogJSON;

@JSON
public record AuditLog(
    Map<String, Object> data,
    Long id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    String insertUser,
    String message,
    Map<String, Object> newValue,
    Map<String, Object> oldValue,
    String reason,
    UUID tenantId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return AuditLogJSON.toJSONBytes(this);
  }
  
  public static AuditLog fromJSON(String json) {
    return AuditLogJSON.fromJSON(json);
  }
  
  public static AuditLog fromJSONBytes(byte[] json) {
    return AuditLogJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Long id;
    private Instant insertInstant;
    private String insertUser;
    private String message;
    private Map<String, Object> newValue;
    private Map<String, Object> oldValue;
    private String reason;
    private UUID tenantId;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder id(Long id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder insertUser(String insertUser) { this.insertUser = insertUser; return this; }
    public Builder message(String message) { this.message = message; return this; }
    public Builder newValue(Map<String, Object> newValue) { this.newValue = newValue; return this; }
    public Builder oldValue(Map<String, Object> oldValue) { this.oldValue = oldValue; return this; }
    public Builder reason(String reason) { this.reason = reason; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public AuditLog build() { return new AuditLog(data, id, insertInstant, insertUser, message, newValue, oldValue, reason, tenantId); }
  }
}
