/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TotalsJSON;

@JSON
public record Totals(
    Long logins,
    Long registrations,
    Long totalRegistrations) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TotalsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TotalsJSON.toJSONBytes(this);
  }

  public static Totals fromJSON(String json) {
    return TotalsJSON.fromJSON(json);
  }

  public static Totals fromJSONBytes(byte[] json) {
    return TotalsJSON.fromJSON(json);
  }

  public static final class Builder {
    private Long logins;
    private Long registrations;
    private Long totalRegistrations;
    public Builder logins(Long logins) { this.logins = logins; return this; }
    public Builder registrations(Long registrations) { this.registrations = registrations; return this; }
    public Builder totalRegistrations(Long totalRegistrations) { this.totalRegistrations = totalRegistrations; return this; }
    public Totals build() { return new Totals(logins, registrations, totalRegistrations); }
  }
}
