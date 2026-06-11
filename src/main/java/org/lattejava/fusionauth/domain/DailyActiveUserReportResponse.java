/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DailyActiveUserReportResponseJSON;

@JSON
public record DailyActiveUserReportResponse(
    List<Count> dailyActiveUsers,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DailyActiveUserReportResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return DailyActiveUserReportResponseJSON.toJSONBytes(this);
  }

  public static DailyActiveUserReportResponse fromJSON(String json) {
    return DailyActiveUserReportResponseJSON.fromJSON(json);
  }

  public static DailyActiveUserReportResponse fromJSONBytes(byte[] json) {
    return DailyActiveUserReportResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Count> dailyActiveUsers;
    private Long total;
    public Builder dailyActiveUsers(List<Count> dailyActiveUsers) { this.dailyActiveUsers = dailyActiveUsers; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public DailyActiveUserReportResponse build() { return new DailyActiveUserReportResponse(dailyActiveUsers, total); }
  }
}
