/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifyRegistrationResponseJSON;

@JSON
public record VerifyRegistrationResponse(
    String oneTimeCode,
    String verificationId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifyRegistrationResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return VerifyRegistrationResponseJSON.toJSONBytes(this);
  }
  
  public static VerifyRegistrationResponse fromJSON(String json) {
    return VerifyRegistrationResponseJSON.fromJSON(json);
  }
  
  public static VerifyRegistrationResponse fromJSONBytes(byte[] json) {
    return VerifyRegistrationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String oneTimeCode;
    private String verificationId;
    public Builder oneTimeCode(String oneTimeCode) { this.oneTimeCode = oneTimeCode; return this; }
    public Builder verificationId(String verificationId) { this.verificationId = verificationId; return this; }
    public VerifyRegistrationResponse build() { return new VerifyRegistrationResponse(oneTimeCode, verificationId); }
  }
}
