/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RegistrationReportResponseJSON;

@JSON
public record RegistrationReportResponse(
    List<Count> hourlyCounts,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RegistrationReportResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RegistrationReportResponseJSON.toJSONBytes(this);
  }

  public static RegistrationReportResponse fromJSON(String json) {
    return RegistrationReportResponseJSON.fromJSON(json);
  }

  public static RegistrationReportResponse fromJSONBytes(byte[] json) {
    return RegistrationReportResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Count> hourlyCounts;
    private Long total;
    public Builder hourlyCounts(List<Count> hourlyCounts) { this.hourlyCounts = hourlyCounts; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public RegistrationReportResponse build() { return new RegistrationReportResponse(hourlyCounts, total); }
  }
}
