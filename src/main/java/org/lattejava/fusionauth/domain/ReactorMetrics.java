/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ReactorMetricsJSON;

@JSON
public record ReactorMetrics(
    Map<String, BreachedPasswordTenantMetric> breachedPasswordMetrics) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ReactorMetricsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ReactorMetricsJSON.toJSONBytes(this);
  }

  public static ReactorMetrics fromJSON(String json) {
    return ReactorMetricsJSON.fromJSON(json);
  }

  public static ReactorMetrics fromJSONBytes(byte[] json) {
    return ReactorMetricsJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, BreachedPasswordTenantMetric> breachedPasswordMetrics;
    public Builder breachedPasswordMetrics(Map<String, BreachedPasswordTenantMetric> breachedPasswordMetrics) { this.breachedPasswordMetrics = breachedPasswordMetrics; return this; }
    public ReactorMetrics build() { return new ReactorMetrics(breachedPasswordMetrics); }
  }
}
