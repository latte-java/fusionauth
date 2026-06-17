/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ReactorResponseJSON;

@JSON
public record ReactorResponse(
    ReactorStatus status) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ReactorResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ReactorResponseJSON.toJSONBytes(this);
  }
  
  public static ReactorResponse fromJSON(String json) {
    return ReactorResponseJSON.fromJSON(json);
  }
  
  public static ReactorResponse fromJSONBytes(byte[] json) {
    return ReactorResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private ReactorStatus status;
    public Builder status(ReactorStatus status) { this.status = status; return this; }
    public ReactorResponse build() { return new ReactorResponse(status); }
  }
}
