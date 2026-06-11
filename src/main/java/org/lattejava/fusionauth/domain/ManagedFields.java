/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ManagedFieldsJSON;

@JSON
public record ManagedFields() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ManagedFieldsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ManagedFieldsJSON.toJSONBytes(this);
  }

  public static ManagedFields fromJSON(String json) {
    return ManagedFieldsJSON.fromJSON(json);
  }

  public static ManagedFields fromJSONBytes(byte[] json) {
    return ManagedFieldsJSON.fromJSON(json);
  }

  public static final class Builder {
    public ManagedFields build() { return new ManagedFields(); }
  }
}
