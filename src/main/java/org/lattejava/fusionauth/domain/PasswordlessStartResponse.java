/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordlessStartResponseJSON;

@JSON
public record PasswordlessStartResponse(
    String code,
    String oneTimeCode) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordlessStartResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PasswordlessStartResponseJSON.toJSONBytes(this);
  }
  
  public static PasswordlessStartResponse fromJSON(String json) {
    return PasswordlessStartResponseJSON.fromJSON(json);
  }
  
  public static PasswordlessStartResponse fromJSONBytes(byte[] json) {
    return PasswordlessStartResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private String oneTimeCode;
    public Builder code(String code) { this.code = code; return this; }
    public Builder oneTimeCode(String oneTimeCode) { this.oneTimeCode = oneTimeCode; return this; }
    public PasswordlessStartResponse build() { return new PasswordlessStartResponse(code, oneTimeCode); }
  }
}
