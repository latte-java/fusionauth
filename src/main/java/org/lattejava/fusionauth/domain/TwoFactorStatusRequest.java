/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorStatusRequestJSON;

@JSON
public record TwoFactorStatusRequest(
    UUID userId,
    String accessToken,
    MultiFactorAction action,
    UUID applicationId,
    String twoFactorTrustId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorStatusRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorStatusRequestJSON.toJSONBytes(this);
  }

  public static TwoFactorStatusRequest fromJSON(String json) {
    return TwoFactorStatusRequestJSON.fromJSON(json);
  }

  public static TwoFactorStatusRequest fromJSONBytes(byte[] json) {
    return TwoFactorStatusRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID userId;
    private String accessToken;
    private MultiFactorAction action;
    private UUID applicationId;
    private String twoFactorTrustId;
    private EventInfo eventInfo;
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder accessToken(String accessToken) { this.accessToken = accessToken; return this; }
    public Builder action(MultiFactorAction action) { this.action = action; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder twoFactorTrustId(String twoFactorTrustId) { this.twoFactorTrustId = twoFactorTrustId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public TwoFactorStatusRequest build() { return new TwoFactorStatusRequest(userId, accessToken, action, applicationId, twoFactorTrustId, eventInfo); }
  }
}
