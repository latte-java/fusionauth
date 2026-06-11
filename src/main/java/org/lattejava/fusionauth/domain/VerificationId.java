/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerificationIdJSON;

@JSON
public record VerificationId(
    String id,
    String oneTimeCode,
    IdentityType type,
    String value) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerificationIdJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return VerificationIdJSON.toJSONBytes(this);
  }

  public static VerificationId fromJSON(String json) {
    return VerificationIdJSON.fromJSON(json);
  }

  public static VerificationId fromJSONBytes(byte[] json) {
    return VerificationIdJSON.fromJSON(json);
  }

  public static final class Builder {
    private String id;
    private String oneTimeCode;
    private IdentityType type;
    private String value;
    public Builder id(String id) { this.id = id; return this; }
    public Builder oneTimeCode(String oneTimeCode) { this.oneTimeCode = oneTimeCode; return this; }
    public Builder type(IdentityType type) { this.type = type; return this; }
    public Builder value(String value) { this.value = value; return this; }
    public VerificationId build() { return new VerificationId(id, oneTimeCode, type, value); }
  }
}
