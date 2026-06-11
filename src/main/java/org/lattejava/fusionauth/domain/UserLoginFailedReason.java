/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserLoginFailedReasonJSON;

@JSON
public record UserLoginFailedReason(
    String code,
    UUID lambdaId,
    Errors lambdaResult) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserLoginFailedReasonJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserLoginFailedReasonJSON.toJSONBytes(this);
  }

  public static UserLoginFailedReason fromJSON(String json) {
    return UserLoginFailedReasonJSON.fromJSON(json);
  }

  public static UserLoginFailedReason fromJSONBytes(byte[] json) {
    return UserLoginFailedReasonJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private UUID lambdaId;
    private Errors lambdaResult;
    public Builder code(String code) { this.code = code; return this; }
    public Builder lambdaId(UUID lambdaId) { this.lambdaId = lambdaId; return this; }
    public Builder lambdaResult(Errors lambdaResult) { this.lambdaResult = lambdaResult; return this; }
    public UserLoginFailedReason build() { return new UserLoginFailedReason(code, lambdaId, lambdaResult); }
  }
}
