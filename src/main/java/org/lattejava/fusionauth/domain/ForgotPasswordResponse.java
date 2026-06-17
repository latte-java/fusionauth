/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ForgotPasswordResponseJSON;

@JSON
public record ForgotPasswordResponse(
    String changePasswordId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ForgotPasswordResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ForgotPasswordResponseJSON.toJSONBytes(this);
  }
  
  public static ForgotPasswordResponse fromJSON(String json) {
    return ForgotPasswordResponseJSON.fromJSON(json);
  }
  
  public static ForgotPasswordResponse fromJSONBytes(byte[] json) {
    return ForgotPasswordResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String changePasswordId;
    public Builder changePasswordId(String changePasswordId) { this.changePasswordId = changePasswordId; return this; }
    public ForgotPasswordResponse build() { return new ForgotPasswordResponse(changePasswordId); }
  }
}
