/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SMSMessageJSON;

@JSON
public record SMSMessage(
    String code,
    String phoneNumber,
    String textMessage,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SMSMessageJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SMSMessageJSON.toJSONBytes(this);
  }
  
  public static SMSMessage fromJSON(String json) {
    return SMSMessageJSON.fromJSON(json);
  }
  
  public static SMSMessage fromJSONBytes(byte[] json) {
    return SMSMessageJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private String phoneNumber;
    private String textMessage;
    private UUID userId;
    public Builder code(String code) { this.code = code; return this; }
    public Builder phoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
    public Builder textMessage(String textMessage) { this.textMessage = textMessage; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public SMSMessage build() { return new SMSMessage(code, phoneNumber, textMessage, userId); }
  }
}
