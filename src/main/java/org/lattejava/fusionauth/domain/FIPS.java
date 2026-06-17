/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FIPSJSON;

@JSON
public record FIPS() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FIPSJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FIPSJSON.toJSONBytes(this);
  }
  
  public static FIPS fromJSON(String json) {
    return FIPSJSON.fromJSON(json);
  }
  
  public static FIPS fromJSONBytes(byte[] json) {
    return FIPSJSON.fromJSON(json);
  }

  public static final class Builder {
    public FIPS build() { return new FIPS(); }
  }
}
