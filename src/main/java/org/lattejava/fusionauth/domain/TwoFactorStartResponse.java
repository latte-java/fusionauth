/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorStartResponseJSON;

@JSON
public record TwoFactorStartResponse(
    String code,
    List<TwoFactorMethod> methods,
    String twoFactorId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorStartResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorStartResponseJSON.toJSONBytes(this);
  }

  public static TwoFactorStartResponse fromJSON(String json) {
    return TwoFactorStartResponseJSON.fromJSON(json);
  }

  public static TwoFactorStartResponse fromJSONBytes(byte[] json) {
    return TwoFactorStartResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private List<TwoFactorMethod> methods;
    private String twoFactorId;
    public Builder code(String code) { this.code = code; return this; }
    public Builder methods(List<TwoFactorMethod> methods) { this.methods = methods; return this; }
    public Builder twoFactorId(String twoFactorId) { this.twoFactorId = twoFactorId; return this; }
    public TwoFactorStartResponse build() { return new TwoFactorStartResponse(code, methods, twoFactorId); }
  }
}
