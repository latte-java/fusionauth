/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorStatusResponseJSON;

@JSON
public record TwoFactorStatusResponse(
    List<TwoFactorTrust> trusts,
    String twoFactorTrustId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorStatusResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorStatusResponseJSON.toJSONBytes(this);
  }

  public static TwoFactorStatusResponse fromJSON(String json) {
    return TwoFactorStatusResponseJSON.fromJSON(json);
  }

  public static TwoFactorStatusResponse fromJSONBytes(byte[] json) {
    return TwoFactorStatusResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<TwoFactorTrust> trusts;
    private String twoFactorTrustId;
    public Builder trusts(List<TwoFactorTrust> trusts) { this.trusts = trusts; return this; }
    public Builder twoFactorTrustId(String twoFactorTrustId) { this.twoFactorTrustId = twoFactorTrustId; return this; }
    public TwoFactorStatusResponse build() { return new TwoFactorStatusResponse(trusts, twoFactorTrustId); }
  }
}
