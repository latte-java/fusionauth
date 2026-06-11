/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationSearchResponseJSON;

@JSON
public record ApplicationSearchResponse(
    List<Application> applications,
    Long total,
    List<String> expandable) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationSearchResponseJSON.toJSONBytes(this);
  }

  public static ApplicationSearchResponse fromJSON(String json) {
    return ApplicationSearchResponseJSON.fromJSON(json);
  }

  public static ApplicationSearchResponse fromJSONBytes(byte[] json) {
    return ApplicationSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Application> applications;
    private Long total;
    private List<String> expandable;
    public Builder applications(List<Application> applications) { this.applications = applications; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public Builder expandable(List<String> expandable) { this.expandable = expandable; return this; }
    public ApplicationSearchResponse build() { return new ApplicationSearchResponse(applications, total, expandable); }
  }
}
