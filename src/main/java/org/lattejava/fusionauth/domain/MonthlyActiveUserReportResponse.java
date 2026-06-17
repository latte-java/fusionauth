/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MonthlyActiveUserReportResponseJSON;

@JSON
public record MonthlyActiveUserReportResponse(
    List<Count> monthlyActiveUsers,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MonthlyActiveUserReportResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MonthlyActiveUserReportResponseJSON.toJSONBytes(this);
  }
  
  public static MonthlyActiveUserReportResponse fromJSON(String json) {
    return MonthlyActiveUserReportResponseJSON.fromJSON(json);
  }
  
  public static MonthlyActiveUserReportResponse fromJSONBytes(byte[] json) {
    return MonthlyActiveUserReportResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Count> monthlyActiveUsers;
    private Long total;
    public Builder monthlyActiveUsers(List<Count> monthlyActiveUsers) { this.monthlyActiveUsers = monthlyActiveUsers; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public MonthlyActiveUserReportResponse build() { return new MonthlyActiveUserReportResponse(monthlyActiveUsers, total); }
  }
}
