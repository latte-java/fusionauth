/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SystemLogsExportRequestJSON;

@JSON
public record SystemLogsExportRequest(
    Boolean includeArchived,
    Integer lastNBytes,
    String dateTimeSecondsFormat,
    String zoneId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SystemLogsExportRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SystemLogsExportRequestJSON.toJSONBytes(this);
  }
  
  public static SystemLogsExportRequest fromJSON(String json) {
    return SystemLogsExportRequestJSON.fromJSON(json);
  }
  
  public static SystemLogsExportRequest fromJSONBytes(byte[] json) {
    return SystemLogsExportRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean includeArchived;
    private Integer lastNBytes;
    private String dateTimeSecondsFormat;
    private String zoneId;
    public Builder includeArchived(Boolean includeArchived) { this.includeArchived = includeArchived; return this; }
    public Builder lastNBytes(Integer lastNBytes) { this.lastNBytes = lastNBytes; return this; }
    public Builder dateTimeSecondsFormat(String dateTimeSecondsFormat) { this.dateTimeSecondsFormat = dateTimeSecondsFormat; return this; }
    public Builder zoneId(String zoneId) { this.zoneId = zoneId; return this; }
    public SystemLogsExportRequest build() { return new SystemLogsExportRequest(includeArchived, lastNBytes, dateTimeSecondsFormat, zoneId); }
  }
}
