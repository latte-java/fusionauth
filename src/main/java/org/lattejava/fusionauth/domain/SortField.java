/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SortFieldJSON;

@JSON
public record SortField(
    String missing,
    String name,
    Sort order) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SortFieldJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SortFieldJSON.toJSONBytes(this);
  }

  public static SortField fromJSON(String json) {
    return SortFieldJSON.fromJSON(json);
  }

  public static SortField fromJSONBytes(byte[] json) {
    return SortFieldJSON.fromJSON(json);
  }

  public static final class Builder {
    private String missing;
    private String name;
    private Sort order;
    public Builder missing(String missing) { this.missing = missing; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder order(Sort order) { this.order = order; return this; }
    public SortField build() { return new SortField(missing, name, order); }
  }
}
