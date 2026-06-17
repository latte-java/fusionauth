/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifyCompleteRequestJSON;

@JSON
public record VerifyCompleteRequest(
    String oneTimeCode,
    String verificationId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifyCompleteRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return VerifyCompleteRequestJSON.toJSONBytes(this);
  }
  
  public static VerifyCompleteRequest fromJSON(String json) {
    return VerifyCompleteRequestJSON.fromJSON(json);
  }
  
  public static VerifyCompleteRequest fromJSONBytes(byte[] json) {
    return VerifyCompleteRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String oneTimeCode;
    private String verificationId;
    private EventInfo eventInfo;
    public Builder oneTimeCode(String oneTimeCode) { this.oneTimeCode = oneTimeCode; return this; }
    public Builder verificationId(String verificationId) { this.verificationId = verificationId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public VerifyCompleteRequest build() { return new VerifyCompleteRequest(oneTimeCode, verificationId, eventInfo); }
  }
}
