/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KeyResponseJSON;

@JSON
public record KeyResponse(
    Key key,
    List<Key> keys) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return KeyResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return KeyResponseJSON.toJSONBytes(this);
  }

  public static KeyResponse fromJSON(String json) {
    return KeyResponseJSON.fromJSON(json);
  }

  public static KeyResponse fromJSONBytes(byte[] json) {
    return KeyResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Key key;
    private List<Key> keys;
    public Builder key(Key key) { this.key = key; return this; }
    public Builder keys(List<Key> keys) { this.keys = keys; return this; }
    public KeyResponse build() { return new KeyResponse(key, keys); }
  }
}
