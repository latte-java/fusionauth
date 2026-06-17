/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ReindexRequestJSON;

@JSON
public record ReindexRequest(
    String index) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ReindexRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ReindexRequestJSON.toJSONBytes(this);
  }
  
  public static ReindexRequest fromJSON(String json) {
    return ReindexRequestJSON.fromJSON(json);
  }
  
  public static ReindexRequest fromJSONBytes(byte[] json) {
    return ReindexRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String index;
    public Builder index(String index) { this.index = index; return this; }
    public ReindexRequest build() { return new ReindexRequest(index); }
  }
}
