/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.CountJSON;

@JSON
public record Count(
    Integer count,
    Integer interval) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return CountJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return CountJSON.toJSONBytes(this);
  }
  
  public static Count fromJSON(String json) {
    return CountJSON.fromJSON(json);
  }
  
  public static Count fromJSONBytes(byte[] json) {
    return CountJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer count;
    private Integer interval;
    public Builder count(Integer count) { this.count = count; return this; }
    public Builder interval(Integer interval) { this.interval = interval; return this; }
    public Count build() { return new Count(count, interval); }
  }
}
