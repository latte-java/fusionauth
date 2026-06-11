/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.StartInstantJSON;

@JSON
public record StartInstant(
    Map<String, Instant> applications,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant tenant) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return StartInstantJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return StartInstantJSON.toJSONBytes(this);
  }

  public static StartInstant fromJSON(String json) {
    return StartInstantJSON.fromJSON(json);
  }

  public static StartInstant fromJSONBytes(byte[] json) {
    return StartInstantJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Instant> applications;
    private Instant tenant;
    public Builder applications(Map<String, Instant> applications) { this.applications = applications; return this; }
    public Builder tenant(Instant tenant) { this.tenant = tenant; return this; }
    public StartInstant build() { return new StartInstant(applications, tenant); }
  }
}
