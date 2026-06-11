/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LogoutRequestJSON;

@JSON
public record LogoutRequest(
    Boolean global,
    String refreshToken,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LogoutRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LogoutRequestJSON.toJSONBytes(this);
  }

  public static LogoutRequest fromJSON(String json) {
    return LogoutRequestJSON.fromJSON(json);
  }

  public static LogoutRequest fromJSONBytes(byte[] json) {
    return LogoutRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean global;
    private String refreshToken;
    private EventInfo eventInfo;
    public Builder global(Boolean global) { this.global = global; return this; }
    public Builder refreshToken(String refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public LogoutRequest build() { return new LogoutRequest(global, refreshToken, eventInfo); }
  }
}
