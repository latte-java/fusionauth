/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KeyRequestJSON;

@JSON
public record KeyRequest(
    Key key) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return KeyRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return KeyRequestJSON.toJSONBytes(this);
  }

  public static KeyRequest fromJSON(String json) {
    return KeyRequestJSON.fromJSON(json);
  }

  public static KeyRequest fromJSONBytes(byte[] json) {
    return KeyRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Key key;
    public Builder key(Key key) { this.key = key; return this; }
    public KeyRequest build() { return new KeyRequest(key); }
  }
}
