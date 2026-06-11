/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorStartRequestJSON;

@JSON
public record TwoFactorStartRequest(
    UUID applicationId,
    String code,
    String loginId,
    List<String> loginIdTypes,
    Map<String, Object> state,
    String trustChallenge,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorStartRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorStartRequestJSON.toJSONBytes(this);
  }

  public static TwoFactorStartRequest fromJSON(String json) {
    return TwoFactorStartRequestJSON.fromJSON(json);
  }

  public static TwoFactorStartRequest fromJSONBytes(byte[] json) {
    return TwoFactorStartRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String code;
    private String loginId;
    private List<String> loginIdTypes;
    private Map<String, Object> state;
    private String trustChallenge;
    private UUID userId;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder code(String code) { this.code = code; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdTypes(List<String> loginIdTypes) { this.loginIdTypes = loginIdTypes; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public Builder trustChallenge(String trustChallenge) { this.trustChallenge = trustChallenge; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public TwoFactorStartRequest build() { return new TwoFactorStartRequest(applicationId, code, loginId, loginIdTypes, state, trustChallenge, userId); }
  }
}
