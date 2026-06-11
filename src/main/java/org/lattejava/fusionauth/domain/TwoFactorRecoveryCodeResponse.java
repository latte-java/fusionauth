/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorRecoveryCodeResponseJSON;

@JSON
public record TwoFactorRecoveryCodeResponse(
    List<String> recoveryCodes) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorRecoveryCodeResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorRecoveryCodeResponseJSON.toJSONBytes(this);
  }

  public static TwoFactorRecoveryCodeResponse fromJSON(String json) {
    return TwoFactorRecoveryCodeResponseJSON.fromJSON(json);
  }

  public static TwoFactorRecoveryCodeResponse fromJSONBytes(byte[] json) {
    return TwoFactorRecoveryCodeResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<String> recoveryCodes;
    public Builder recoveryCodes(List<String> recoveryCodes) { this.recoveryCodes = recoveryCodes; return this; }
    public TwoFactorRecoveryCodeResponse build() { return new TwoFactorRecoveryCodeResponse(recoveryCodes); }
  }
}
