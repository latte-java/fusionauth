/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshTokenRevocationPolicyJSON;

@JSON
public record RefreshTokenRevocationPolicy(
    Boolean onLoginPrevented,
    Boolean onMultiFactorEnable,
    Boolean onOneTimeTokenReuse,
    Boolean onPasswordChanged) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshTokenRevocationPolicyJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RefreshTokenRevocationPolicyJSON.toJSONBytes(this);
  }

  public static RefreshTokenRevocationPolicy fromJSON(String json) {
    return RefreshTokenRevocationPolicyJSON.fromJSON(json);
  }

  public static RefreshTokenRevocationPolicy fromJSONBytes(byte[] json) {
    return RefreshTokenRevocationPolicyJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean onLoginPrevented;
    private Boolean onMultiFactorEnable;
    private Boolean onOneTimeTokenReuse;
    private Boolean onPasswordChanged;
    public Builder onLoginPrevented(Boolean onLoginPrevented) { this.onLoginPrevented = onLoginPrevented; return this; }
    public Builder onMultiFactorEnable(Boolean onMultiFactorEnable) { this.onMultiFactorEnable = onMultiFactorEnable; return this; }
    public Builder onOneTimeTokenReuse(Boolean onOneTimeTokenReuse) { this.onOneTimeTokenReuse = onOneTimeTokenReuse; return this; }
    public Builder onPasswordChanged(Boolean onPasswordChanged) { this.onPasswordChanged = onPasswordChanged; return this; }
    public RefreshTokenRevocationPolicy build() { return new RefreshTokenRevocationPolicy(onLoginPrevented, onMultiFactorEnable, onOneTimeTokenReuse, onPasswordChanged); }
  }
}
