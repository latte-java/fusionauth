/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogExportRequestJSON;

@JSON
public record AuditLogExportRequest(
    AuditLogSearchCriteria criteria,
    String dateTimeSecondsFormat,
    String zoneId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogExportRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return AuditLogExportRequestJSON.toJSONBytes(this);
  }
  
  public static AuditLogExportRequest fromJSON(String json) {
    return AuditLogExportRequestJSON.fromJSON(json);
  }
  
  public static AuditLogExportRequest fromJSONBytes(byte[] json) {
    return AuditLogExportRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuditLogSearchCriteria criteria;
    private String dateTimeSecondsFormat;
    private String zoneId;
    public Builder criteria(AuditLogSearchCriteria criteria) { this.criteria = criteria; return this; }
    public Builder dateTimeSecondsFormat(String dateTimeSecondsFormat) { this.dateTimeSecondsFormat = dateTimeSecondsFormat; return this; }
    public Builder zoneId(String zoneId) { this.zoneId = zoneId; return this; }
    public AuditLogExportRequest build() { return new AuditLogExportRequest(criteria, dateTimeSecondsFormat, zoneId); }
  }
}
