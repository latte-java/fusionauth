/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ObjectIdentifiableJSON;

@JSON
public record ObjectIdentifiable() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ObjectIdentifiableJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ObjectIdentifiableJSON.toJSONBytes(this);
  }

  public static ObjectIdentifiable fromJSON(String json) {
    return ObjectIdentifiableJSON.fromJSON(json);
  }

  public static ObjectIdentifiable fromJSONBytes(byte[] json) {
    return ObjectIdentifiableJSON.fromJSON(json);
  }

  public static final class Builder {
    public ObjectIdentifiable build() { return new ObjectIdentifiable(); }
  }
}
