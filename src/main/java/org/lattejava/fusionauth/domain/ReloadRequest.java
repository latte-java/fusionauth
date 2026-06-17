/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ReloadRequestJSON;

@JSON
public record ReloadRequest(
    List<String> names) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ReloadRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ReloadRequestJSON.toJSONBytes(this);
  }
  
  public static ReloadRequest fromJSON(String json) {
    return ReloadRequestJSON.fromJSON(json);
  }
  
  public static ReloadRequest fromJSONBytes(byte[] json) {
    return ReloadRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<String> names;
    public Builder names(List<String> names) { this.names = names; return this; }
    public ReloadRequest build() { return new ReloadRequest(names); }
  }
}
