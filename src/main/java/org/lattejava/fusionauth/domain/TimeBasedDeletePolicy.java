/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TimeBasedDeletePolicyJSON;

@JSON
public record TimeBasedDeletePolicy(
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant enabledInstant,
    Integer numberOfDaysToRetain,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TimeBasedDeletePolicyJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TimeBasedDeletePolicyJSON.toJSONBytes(this);
  }

  public static TimeBasedDeletePolicy fromJSON(String json) {
    return TimeBasedDeletePolicyJSON.fromJSON(json);
  }

  public static TimeBasedDeletePolicy fromJSONBytes(byte[] json) {
    return TimeBasedDeletePolicyJSON.fromJSON(json);
  }

  public static final class Builder {
    private Instant enabledInstant;
    private Integer numberOfDaysToRetain;
    private Boolean enabled;
    public Builder enabledInstant(Instant enabledInstant) { this.enabledInstant = enabledInstant; return this; }
    public Builder numberOfDaysToRetain(Integer numberOfDaysToRetain) { this.numberOfDaysToRetain = numberOfDaysToRetain; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public TimeBasedDeletePolicy build() { return new TimeBasedDeletePolicy(enabledInstant, numberOfDaysToRetain, enabled); }
  }
}
