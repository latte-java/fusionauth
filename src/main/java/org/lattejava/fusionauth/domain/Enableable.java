/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EnableableJSON;

@JSON
public record Enableable(
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EnableableJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EnableableJSON.toJSONBytes(this);
  }

  public static Enableable fromJSON(String json) {
    return EnableableJSON.fromJSON(json);
  }

  public static Enableable fromJSONBytes(byte[] json) {
    return EnableableJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean enabled;
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public Enableable build() { return new Enableable(enabled); }
  }
}
