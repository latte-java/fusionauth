/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ExpandableRequestJSON;

@JSON
public record ExpandableRequest(
    List<String> expand) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ExpandableRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ExpandableRequestJSON.toJSONBytes(this);
  }
  
  public static ExpandableRequest fromJSON(String json) {
    return ExpandableRequestJSON.fromJSON(json);
  }
  
  public static ExpandableRequest fromJSONBytes(byte[] json) {
    return ExpandableRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<String> expand;
    public Builder expand(List<String> expand) { this.expand = expand; return this; }
    public ExpandableRequest build() { return new ExpandableRequest(expand); }
  }
}
