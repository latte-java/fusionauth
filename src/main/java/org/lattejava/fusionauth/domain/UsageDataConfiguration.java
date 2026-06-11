/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UsageDataConfigurationJSON;

@JSON
public record UsageDataConfiguration(
    Integer numberOfDaysToRetain,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UsageDataConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UsageDataConfigurationJSON.toJSONBytes(this);
  }

  public static UsageDataConfiguration fromJSON(String json) {
    return UsageDataConfigurationJSON.fromJSON(json);
  }

  public static UsageDataConfiguration fromJSONBytes(byte[] json) {
    return UsageDataConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer numberOfDaysToRetain;
    private Boolean enabled;
    public Builder numberOfDaysToRetain(Integer numberOfDaysToRetain) { this.numberOfDaysToRetain = numberOfDaysToRetain; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public UsageDataConfiguration build() { return new UsageDataConfiguration(numberOfDaysToRetain, enabled); }
  }
}
