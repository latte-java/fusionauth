/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifyRequestJSON;

@JSON
public record VerifyRequest(
    String loginId,
    String loginIdType,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifyRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return VerifyRequestJSON.toJSONBytes(this);
  }
  
  public static VerifyRequest fromJSON(String json) {
    return VerifyRequestJSON.fromJSON(json);
  }
  
  public static VerifyRequest fromJSONBytes(byte[] json) {
    return VerifyRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String loginId;
    private String loginIdType;
    private EventInfo eventInfo;
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdType(String loginIdType) { this.loginIdType = loginIdType; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public VerifyRequest build() { return new VerifyRequest(loginId, loginIdType, eventInfo); }
  }
}
