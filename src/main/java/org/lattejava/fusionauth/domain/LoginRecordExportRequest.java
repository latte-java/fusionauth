/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginRecordExportRequestJSON;

@JSON
public record LoginRecordExportRequest(
    LoginRecordSearchCriteria criteria,
    String dateTimeSecondsFormat,
    String zoneId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginRecordExportRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LoginRecordExportRequestJSON.toJSONBytes(this);
  }

  public static LoginRecordExportRequest fromJSON(String json) {
    return LoginRecordExportRequestJSON.fromJSON(json);
  }

  public static LoginRecordExportRequest fromJSONBytes(byte[] json) {
    return LoginRecordExportRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private LoginRecordSearchCriteria criteria;
    private String dateTimeSecondsFormat;
    private String zoneId;
    public Builder criteria(LoginRecordSearchCriteria criteria) { this.criteria = criteria; return this; }
    public Builder dateTimeSecondsFormat(String dateTimeSecondsFormat) { this.dateTimeSecondsFormat = dateTimeSecondsFormat; return this; }
    public Builder zoneId(String zoneId) { this.zoneId = zoneId; return this; }
    public LoginRecordExportRequest build() { return new LoginRecordExportRequest(criteria, dateTimeSecondsFormat, zoneId); }
  }
}
