/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifyRegistrationRequestJSON;

@JSON
public record VerifyRegistrationRequest(
    String oneTimeCode,
    String verificationId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifyRegistrationRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return VerifyRegistrationRequestJSON.toJSONBytes(this);
  }
  
  public static VerifyRegistrationRequest fromJSON(String json) {
    return VerifyRegistrationRequestJSON.fromJSON(json);
  }
  
  public static VerifyRegistrationRequest fromJSONBytes(byte[] json) {
    return VerifyRegistrationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String oneTimeCode;
    private String verificationId;
    private EventInfo eventInfo;
    public Builder oneTimeCode(String oneTimeCode) { this.oneTimeCode = oneTimeCode; return this; }
    public Builder verificationId(String verificationId) { this.verificationId = verificationId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public VerifyRegistrationRequest build() { return new VerifyRegistrationRequest(oneTimeCode, verificationId, eventInfo); }
  }
}
