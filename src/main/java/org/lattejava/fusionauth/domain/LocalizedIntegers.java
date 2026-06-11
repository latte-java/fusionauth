/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LocalizedIntegersJSON;

@JSON
public record LocalizedIntegers() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LocalizedIntegersJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LocalizedIntegersJSON.toJSONBytes(this);
  }

  public static LocalizedIntegers fromJSON(String json) {
    return LocalizedIntegersJSON.fromJSON(json);
  }

  public static LocalizedIntegers fromJSONBytes(byte[] json) {
    return LocalizedIntegersJSON.fromJSON(json);
  }

  public static final class Builder {
    public LocalizedIntegers build() { return new LocalizedIntegers(); }
  }
}
