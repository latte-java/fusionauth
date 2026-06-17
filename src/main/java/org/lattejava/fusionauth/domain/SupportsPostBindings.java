/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SupportsPostBindingsJSON;

@JSON
public record SupportsPostBindings() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SupportsPostBindingsJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SupportsPostBindingsJSON.toJSONBytes(this);
  }
  
  public static SupportsPostBindings fromJSON(String json) {
    return SupportsPostBindingsJSON.fromJSON(json);
  }
  
  public static SupportsPostBindings fromJSONBytes(byte[] json) {
    return SupportsPostBindingsJSON.fromJSON(json);
  }

  public static final class Builder {
    public SupportsPostBindings build() { return new SupportsPostBindings(); }
  }
}
