/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LocalizedStringsJSON;

@JSON
public record LocalizedStrings() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LocalizedStringsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LocalizedStringsJSON.toJSONBytes(this);
  }

  public static LocalizedStrings fromJSON(String json) {
    return LocalizedStringsJSON.fromJSON(json);
  }

  public static LocalizedStrings fromJSONBytes(byte[] json) {
    return LocalizedStringsJSON.fromJSON(json);
  }

  public static final class Builder {
    public LocalizedStrings build() { return new LocalizedStrings(); }
  }
}
