/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ChangePasswordRequestJSON;

@JSON
public record ChangePasswordRequest(
    UUID applicationId,
    String changePasswordId,
    String currentPassword,
    String loginId,
    List<String> loginIdTypes,
    String password,
    String refreshToken,
    String trustChallenge,
    String trustToken,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ChangePasswordRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ChangePasswordRequestJSON.toJSONBytes(this);
  }

  public static ChangePasswordRequest fromJSON(String json) {
    return ChangePasswordRequestJSON.fromJSON(json);
  }

  public static ChangePasswordRequest fromJSONBytes(byte[] json) {
    return ChangePasswordRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String changePasswordId;
    private String currentPassword;
    private String loginId;
    private List<String> loginIdTypes;
    private String password;
    private String refreshToken;
    private String trustChallenge;
    private String trustToken;
    private EventInfo eventInfo;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder changePasswordId(String changePasswordId) { this.changePasswordId = changePasswordId; return this; }
    public Builder currentPassword(String currentPassword) { this.currentPassword = currentPassword; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdTypes(List<String> loginIdTypes) { this.loginIdTypes = loginIdTypes; return this; }
    public Builder password(String password) { this.password = password; return this; }
    public Builder refreshToken(String refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder trustChallenge(String trustChallenge) { this.trustChallenge = trustChallenge; return this; }
    public Builder trustToken(String trustToken) { this.trustToken = trustToken; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public ChangePasswordRequest build() { return new ChangePasswordRequest(applicationId, changePasswordId, currentPassword, loginId, loginIdTypes, password, refreshToken, trustChallenge, trustToken, eventInfo); }
  }
}
