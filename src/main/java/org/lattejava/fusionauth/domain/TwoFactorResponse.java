/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorResponseJSON;

@JSON
public record TwoFactorResponse(
    String code,
    List<String> recoveryCodes) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorResponseJSON.toJSONBytes(this);
  }

  public static TwoFactorResponse fromJSON(String json) {
    return TwoFactorResponseJSON.fromJSON(json);
  }

  public static TwoFactorResponse fromJSONBytes(byte[] json) {
    return TwoFactorResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private List<String> recoveryCodes;
    public Builder code(String code) { this.code = code; return this; }
    public Builder recoveryCodes(List<String> recoveryCodes) { this.recoveryCodes = recoveryCodes; return this; }
    public TwoFactorResponse build() { return new TwoFactorResponse(code, recoveryCodes); }
  }
}
