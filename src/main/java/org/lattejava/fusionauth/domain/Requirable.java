/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RequirableJSON;

@JSON
public record Requirable(
    Boolean required,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RequirableJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RequirableJSON.toJSONBytes(this);
  }

  public static Requirable fromJSON(String json) {
    return RequirableJSON.fromJSON(json);
  }

  public static Requirable fromJSONBytes(byte[] json) {
    return RequirableJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean required;
    private Boolean enabled;
    public Builder required(Boolean required) { this.required = required; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public Requirable build() { return new Requirable(required, enabled); }
  }
}
