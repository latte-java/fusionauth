/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TotalsReportResponseJSON;

@JSON
public record TotalsReportResponse(
    Map<String, Totals> applicationTotals,
    Long globalRegistrations,
    Long totalGlobalRegistrations) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TotalsReportResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TotalsReportResponseJSON.toJSONBytes(this);
  }

  public static TotalsReportResponse fromJSON(String json) {
    return TotalsReportResponseJSON.fromJSON(json);
  }

  public static TotalsReportResponse fromJSONBytes(byte[] json) {
    return TotalsReportResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Totals> applicationTotals;
    private Long globalRegistrations;
    private Long totalGlobalRegistrations;
    public Builder applicationTotals(Map<String, Totals> applicationTotals) { this.applicationTotals = applicationTotals; return this; }
    public Builder globalRegistrations(Long globalRegistrations) { this.globalRegistrations = globalRegistrations; return this; }
    public Builder totalGlobalRegistrations(Long totalGlobalRegistrations) { this.totalGlobalRegistrations = totalGlobalRegistrations; return this; }
    public TotalsReportResponse build() { return new TotalsReportResponse(applicationTotals, globalRegistrations, totalGlobalRegistrations); }
  }
}
