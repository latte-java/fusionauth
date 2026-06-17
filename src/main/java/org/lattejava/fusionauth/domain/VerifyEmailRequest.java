/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifyEmailRequestJSON;

@JSON
public record VerifyEmailRequest(
    String oneTimeCode,
    UUID userId,
    String verificationId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifyEmailRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return VerifyEmailRequestJSON.toJSONBytes(this);
  }
  
  public static VerifyEmailRequest fromJSON(String json) {
    return VerifyEmailRequestJSON.fromJSON(json);
  }
  
  public static VerifyEmailRequest fromJSONBytes(byte[] json) {
    return VerifyEmailRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String oneTimeCode;
    private UUID userId;
    private String verificationId;
    private EventInfo eventInfo;
    public Builder oneTimeCode(String oneTimeCode) { this.oneTimeCode = oneTimeCode; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder verificationId(String verificationId) { this.verificationId = verificationId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public VerifyEmailRequest build() { return new VerifyEmailRequest(oneTimeCode, userId, verificationId, eventInfo); }
  }
}
