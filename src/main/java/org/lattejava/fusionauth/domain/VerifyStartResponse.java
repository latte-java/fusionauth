/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifyStartResponseJSON;

@JSON
public record VerifyStartResponse(
    String oneTimeCode,
    String verificationId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifyStartResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return VerifyStartResponseJSON.toJSONBytes(this);
  }

  public static VerifyStartResponse fromJSON(String json) {
    return VerifyStartResponseJSON.fromJSON(json);
  }

  public static VerifyStartResponse fromJSONBytes(byte[] json) {
    return VerifyStartResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String oneTimeCode;
    private String verificationId;
    public Builder oneTimeCode(String oneTimeCode) { this.oneTimeCode = oneTimeCode; return this; }
    public Builder verificationId(String verificationId) { this.verificationId = verificationId; return this; }
    public VerifyStartResponse build() { return new VerifyStartResponse(oneTimeCode, verificationId); }
  }
}
