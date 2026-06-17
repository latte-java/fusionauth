/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserinfoResponseJSON;

@JSON
public record UserinfoResponse() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserinfoResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserinfoResponseJSON.toJSONBytes(this);
  }
  
  public static UserinfoResponse fromJSON(String json) {
    return UserinfoResponseJSON.fromJSON(json);
  }
  
  public static UserinfoResponse fromJSONBytes(byte[] json) {
    return UserinfoResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    public UserinfoResponse build() { return new UserinfoResponse(); }
  }
}
