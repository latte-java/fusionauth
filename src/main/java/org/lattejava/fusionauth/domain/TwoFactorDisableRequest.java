/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorDisableRequestJSON;

@JSON
public record TwoFactorDisableRequest(
    UUID applicationId,
    String code,
    String methodId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorDisableRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorDisableRequestJSON.toJSONBytes(this);
  }

  public static TwoFactorDisableRequest fromJSON(String json) {
    return TwoFactorDisableRequestJSON.fromJSON(json);
  }

  public static TwoFactorDisableRequest fromJSONBytes(byte[] json) {
    return TwoFactorDisableRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String code;
    private String methodId;
    private EventInfo eventInfo;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder code(String code) { this.code = code; return this; }
    public Builder methodId(String methodId) { this.methodId = methodId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public TwoFactorDisableRequest build() { return new TwoFactorDisableRequest(applicationId, code, methodId, eventInfo); }
  }
}
