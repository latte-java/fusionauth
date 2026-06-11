/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RegistrationResponseJSON;

@JSON
public record RegistrationResponse(
    String refreshToken,
    UUID refreshTokenId,
    UserRegistration registration,
    String registrationVerificationId,
    String registrationVerificationOneTimeCode,
    String token,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant tokenExpirationInstant,
    User user,
    List<VerificationId> verificationIds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RegistrationResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RegistrationResponseJSON.toJSONBytes(this);
  }

  public static RegistrationResponse fromJSON(String json) {
    return RegistrationResponseJSON.fromJSON(json);
  }

  public static RegistrationResponse fromJSONBytes(byte[] json) {
    return RegistrationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String refreshToken;
    private UUID refreshTokenId;
    private UserRegistration registration;
    private String registrationVerificationId;
    private String registrationVerificationOneTimeCode;
    private String token;
    private Instant tokenExpirationInstant;
    private User user;
    private List<VerificationId> verificationIds;
    public Builder refreshToken(String refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder refreshTokenId(UUID refreshTokenId) { this.refreshTokenId = refreshTokenId; return this; }
    public Builder registration(UserRegistration registration) { this.registration = registration; return this; }
    public Builder registrationVerificationId(String registrationVerificationId) { this.registrationVerificationId = registrationVerificationId; return this; }
    public Builder registrationVerificationOneTimeCode(String registrationVerificationOneTimeCode) { this.registrationVerificationOneTimeCode = registrationVerificationOneTimeCode; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder tokenExpirationInstant(Instant tokenExpirationInstant) { this.tokenExpirationInstant = tokenExpirationInstant; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public Builder verificationIds(List<VerificationId> verificationIds) { this.verificationIds = verificationIds; return this; }
    public RegistrationResponse build() { return new RegistrationResponse(refreshToken, refreshTokenId, registration, registrationVerificationId, registrationVerificationOneTimeCode, token, tokenExpirationInstant, user, verificationIds); }
  }
}
