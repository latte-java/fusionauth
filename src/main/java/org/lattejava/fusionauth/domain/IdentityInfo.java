/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityInfoJSON;

@JSON
public record IdentityInfo(
    String type,
    String value) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityInfoJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityInfoJSON.toJSONBytes(this);
  }
  
  public static IdentityInfo fromJSON(String json) {
    return IdentityInfoJSON.fromJSON(json);
  }
  
  public static IdentityInfo fromJSONBytes(byte[] json) {
    return IdentityInfoJSON.fromJSON(json);
  }

  public static final class Builder {
    private String type;
    private String value;
    public Builder type(String type) { this.type = type; return this; }
    public Builder value(String value) { this.value = value; return this; }
    public IdentityInfo build() { return new IdentityInfo(type, value); }
  }
}
