/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MinimumPasswordAgeJSON;

@JSON
public record MinimumPasswordAge(
    Integer seconds,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MinimumPasswordAgeJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MinimumPasswordAgeJSON.toJSONBytes(this);
  }

  public static MinimumPasswordAge fromJSON(String json) {
    return MinimumPasswordAgeJSON.fromJSON(json);
  }

  public static MinimumPasswordAge fromJSONBytes(byte[] json) {
    return MinimumPasswordAgeJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer seconds;
    private Boolean enabled;
    public Builder seconds(Integer seconds) { this.seconds = seconds; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public MinimumPasswordAge build() { return new MinimumPasswordAge(seconds, enabled); }
  }
}
