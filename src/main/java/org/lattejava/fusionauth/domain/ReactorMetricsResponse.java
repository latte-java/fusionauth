/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ReactorMetricsResponseJSON;

@JSON
public record ReactorMetricsResponse(
    ReactorMetrics metrics) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ReactorMetricsResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ReactorMetricsResponseJSON.toJSONBytes(this);
  }

  public static ReactorMetricsResponse fromJSON(String json) {
    return ReactorMetricsResponseJSON.fromJSON(json);
  }

  public static ReactorMetricsResponse fromJSONBytes(byte[] json) {
    return ReactorMetricsResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private ReactorMetrics metrics;
    public Builder metrics(ReactorMetrics metrics) { this.metrics = metrics; return this; }
    public ReactorMetricsResponse build() { return new ReactorMetricsResponse(metrics); }
  }
}
