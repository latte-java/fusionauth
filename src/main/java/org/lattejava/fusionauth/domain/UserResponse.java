/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserResponseJSON;

@JSON
public record UserResponse(
    String emailVerificationId,
    String emailVerificationOneTimeCode,
    Map<String, String> registrationVerificationIds,
    Map<String, String> registrationVerificationOneTimeCodes,
    String token,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant tokenExpirationInstant,
    User user,
    List<VerificationId> verificationIds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserResponseJSON.toJSONBytes(this);
  }
  
  public static UserResponse fromJSON(String json) {
    return UserResponseJSON.fromJSON(json);
  }
  
  public static UserResponse fromJSONBytes(byte[] json) {
    return UserResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String emailVerificationId;
    private String emailVerificationOneTimeCode;
    private Map<String, String> registrationVerificationIds;
    private Map<String, String> registrationVerificationOneTimeCodes;
    private String token;
    private Instant tokenExpirationInstant;
    private User user;
    private List<VerificationId> verificationIds;
    public Builder emailVerificationId(String emailVerificationId) { this.emailVerificationId = emailVerificationId; return this; }
    public Builder emailVerificationOneTimeCode(String emailVerificationOneTimeCode) { this.emailVerificationOneTimeCode = emailVerificationOneTimeCode; return this; }
    public Builder registrationVerificationIds(Map<String, String> registrationVerificationIds) { this.registrationVerificationIds = registrationVerificationIds; return this; }
    public Builder registrationVerificationOneTimeCodes(Map<String, String> registrationVerificationOneTimeCodes) { this.registrationVerificationOneTimeCodes = registrationVerificationOneTimeCodes; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder tokenExpirationInstant(Instant tokenExpirationInstant) { this.tokenExpirationInstant = tokenExpirationInstant; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public Builder verificationIds(List<VerificationId> verificationIds) { this.verificationIds = verificationIds; return this; }
    public UserResponse build() { return new UserResponse(emailVerificationId, emailVerificationOneTimeCode, registrationVerificationIds, registrationVerificationOneTimeCodes, token, tokenExpirationInstant, user, verificationIds); }
  }
}
