/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ExpandableResponseJSON;

@JSON
public record ExpandableResponse(
    List<String> expandable) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ExpandableResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ExpandableResponseJSON.toJSONBytes(this);
  }

  public static ExpandableResponse fromJSON(String json) {
    return ExpandableResponseJSON.fromJSON(json);
  }

  public static ExpandableResponse fromJSONBytes(byte[] json) {
    return ExpandableResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<String> expandable;
    public Builder expandable(List<String> expandable) { this.expandable = expandable; return this; }
    public ExpandableResponse build() { return new ExpandableResponse(expandable); }
  }
}
