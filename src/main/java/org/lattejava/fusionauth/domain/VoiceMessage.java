/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VoiceMessageJSON;

@JSON
public record VoiceMessage(
    String code,
    String locale,
    String message,
    String phoneNumber,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VoiceMessageJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return VoiceMessageJSON.toJSONBytes(this);
  }

  public static VoiceMessage fromJSON(String json) {
    return VoiceMessageJSON.fromJSON(json);
  }

  public static VoiceMessage fromJSONBytes(byte[] json) {
    return VoiceMessageJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private String locale;
    private String message;
    private String phoneNumber;
    private UUID userId;
    public Builder code(String code) { this.code = code; return this; }
    public Builder locale(String locale) { this.locale = locale; return this; }
    public Builder message(String message) { this.message = message; return this; }
    public Builder phoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public VoiceMessage build() { return new VoiceMessage(code, locale, message, phoneNumber, userId); }
  }
}
