/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FailedAuthenticationActionCancelPolicyJSON;

@JSON
public record FailedAuthenticationActionCancelPolicy(
    Boolean onPasswordReset) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FailedAuthenticationActionCancelPolicyJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FailedAuthenticationActionCancelPolicyJSON.toJSONBytes(this);
  }

  public static FailedAuthenticationActionCancelPolicy fromJSON(String json) {
    return FailedAuthenticationActionCancelPolicyJSON.fromJSON(json);
  }

  public static FailedAuthenticationActionCancelPolicy fromJSONBytes(byte[] json) {
    return FailedAuthenticationActionCancelPolicyJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean onPasswordReset;
    public Builder onPasswordReset(Boolean onPasswordReset) { this.onPasswordReset = onPasswordReset; return this; }
    public FailedAuthenticationActionCancelPolicy build() { return new FailedAuthenticationActionCancelPolicy(onPasswordReset); }
  }
}
