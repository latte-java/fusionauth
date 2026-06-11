/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ErrorJSON;

@JSON
public record Error(
    String code,
    Map<String, Object> data,
    String message) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ErrorJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ErrorJSON.toJSONBytes(this);
  }

  public static Error fromJSON(String json) {
    return ErrorJSON.fromJSON(json);
  }

  public static Error fromJSONBytes(byte[] json) {
    return ErrorJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private Map<String, Object> data;
    private String message;
    public Builder code(String code) { this.code = code; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder message(String message) { this.message = message; return this; }
    public Error build() { return new Error(code, data, message); }
  }
}
