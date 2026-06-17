/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.StatusResponseJSON;

@JSON
public record StatusResponse() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return StatusResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return StatusResponseJSON.toJSONBytes(this);
  }
  
  public static StatusResponse fromJSON(String json) {
    return StatusResponseJSON.fromJSON(json);
  }
  
  public static StatusResponse fromJSONBytes(byte[] json) {
    return StatusResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    public StatusResponse build() { return new StatusResponse(); }
  }
}
