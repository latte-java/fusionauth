/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MaximumPasswordAgeJSON;

@JSON
public record MaximumPasswordAge(
    Integer days,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MaximumPasswordAgeJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MaximumPasswordAgeJSON.toJSONBytes(this);
  }

  public static MaximumPasswordAge fromJSON(String json) {
    return MaximumPasswordAgeJSON.fromJSON(json);
  }

  public static MaximumPasswordAge fromJSONBytes(byte[] json) {
    return MaximumPasswordAgeJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer days;
    private Boolean enabled;
    public Builder days(Integer days) { this.days = days; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public MaximumPasswordAge build() { return new MaximumPasswordAge(days, enabled); }
  }
}
