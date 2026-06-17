/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseExportRequestJSON;

@JSON
public record BaseExportRequest(
    String dateTimeSecondsFormat,
    String zoneId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseExportRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return BaseExportRequestJSON.toJSONBytes(this);
  }
  
  public static BaseExportRequest fromJSON(String json) {
    return BaseExportRequestJSON.fromJSON(json);
  }
  
  public static BaseExportRequest fromJSONBytes(byte[] json) {
    return BaseExportRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String dateTimeSecondsFormat;
    private String zoneId;
    public Builder dateTimeSecondsFormat(String dateTimeSecondsFormat) { this.dateTimeSecondsFormat = dateTimeSecondsFormat; return this; }
    public Builder zoneId(String zoneId) { this.zoneId = zoneId; return this; }
    public BaseExportRequest build() { return new BaseExportRequest(dateTimeSecondsFormat, zoneId); }
  }
}
