/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityTypeJSON;

@JSON
public record IdentityType(
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityTypeJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityTypeJSON.toJSONBytes(this);
  }

  public static IdentityType fromJSON(String json) {
    return IdentityTypeJSON.fromJSON(json);
  }

  public static IdentityType fromJSONBytes(byte[] json) {
    return IdentityTypeJSON.fromJSON(json);
  }

  public static final class Builder {
    private String name;
    public Builder name(String name) { this.name = name; return this; }
    public IdentityType build() { return new IdentityType(name); }
  }
}
