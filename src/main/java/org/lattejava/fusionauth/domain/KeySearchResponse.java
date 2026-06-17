/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KeySearchResponseJSON;

@JSON
public record KeySearchResponse(
    List<Key> keys,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return KeySearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return KeySearchResponseJSON.toJSONBytes(this);
  }
  
  public static KeySearchResponse fromJSON(String json) {
    return KeySearchResponseJSON.fromJSON(json);
  }
  
  public static KeySearchResponse fromJSONBytes(byte[] json) {
    return KeySearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Key> keys;
    private Long total;
    public Builder keys(List<Key> keys) { this.keys = keys; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public KeySearchResponse build() { return new KeySearchResponse(keys, total); }
  }
}
