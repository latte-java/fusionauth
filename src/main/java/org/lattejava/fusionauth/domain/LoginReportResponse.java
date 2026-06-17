/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginReportResponseJSON;

@JSON
public record LoginReportResponse(
    List<Count> hourlyCounts,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginReportResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginReportResponseJSON.toJSONBytes(this);
  }
  
  public static LoginReportResponse fromJSON(String json) {
    return LoginReportResponseJSON.fromJSON(json);
  }
  
  public static LoginReportResponse fromJSONBytes(byte[] json) {
    return LoginReportResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Count> hourlyCounts;
    private Long total;
    public Builder hourlyCounts(List<Count> hourlyCounts) { this.hourlyCounts = hourlyCounts; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public LoginReportResponse build() { return new LoginReportResponse(hourlyCounts, total); }
  }
}
