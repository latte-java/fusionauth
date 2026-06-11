/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginResponseJSON;

@JSON
public record LoginResponse(
    List<LoginPreventedResponse> actions,
    String changePasswordId,
    ChangePasswordReason changePasswordReason,
    List<String> configurableMethods,
    String emailVerificationId,
    String identityVerificationId,
    List<TwoFactorMethod> methods,
    String pendingIdPLinkId,
    String refreshToken,
    UUID refreshTokenId,
    String registrationVerificationId,
    Map<String, Object> state,
    Set<String> threatsDetected,
    String token,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant tokenExpirationInstant,
    String trustToken,
    String twoFactorId,
    String twoFactorTrustId,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LoginResponseJSON.toJSONBytes(this);
  }

  public static LoginResponse fromJSON(String json) {
    return LoginResponseJSON.fromJSON(json);
  }

  public static LoginResponse fromJSONBytes(byte[] json) {
    return LoginResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<LoginPreventedResponse> actions;
    private String changePasswordId;
    private ChangePasswordReason changePasswordReason;
    private List<String> configurableMethods;
    private String emailVerificationId;
    private String identityVerificationId;
    private List<TwoFactorMethod> methods;
    private String pendingIdPLinkId;
    private String refreshToken;
    private UUID refreshTokenId;
    private String registrationVerificationId;
    private Map<String, Object> state;
    private Set<String> threatsDetected;
    private String token;
    private Instant tokenExpirationInstant;
    private String trustToken;
    private String twoFactorId;
    private String twoFactorTrustId;
    private User user;
    public Builder actions(List<LoginPreventedResponse> actions) { this.actions = actions; return this; }
    public Builder changePasswordId(String changePasswordId) { this.changePasswordId = changePasswordId; return this; }
    public Builder changePasswordReason(ChangePasswordReason changePasswordReason) { this.changePasswordReason = changePasswordReason; return this; }
    public Builder configurableMethods(List<String> configurableMethods) { this.configurableMethods = configurableMethods; return this; }
    public Builder emailVerificationId(String emailVerificationId) { this.emailVerificationId = emailVerificationId; return this; }
    public Builder identityVerificationId(String identityVerificationId) { this.identityVerificationId = identityVerificationId; return this; }
    public Builder methods(List<TwoFactorMethod> methods) { this.methods = methods; return this; }
    public Builder pendingIdPLinkId(String pendingIdPLinkId) { this.pendingIdPLinkId = pendingIdPLinkId; return this; }
    public Builder refreshToken(String refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder refreshTokenId(UUID refreshTokenId) { this.refreshTokenId = refreshTokenId; return this; }
    public Builder registrationVerificationId(String registrationVerificationId) { this.registrationVerificationId = registrationVerificationId; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public Builder threatsDetected(Set<String> threatsDetected) { this.threatsDetected = threatsDetected; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder tokenExpirationInstant(Instant tokenExpirationInstant) { this.tokenExpirationInstant = tokenExpirationInstant; return this; }
    public Builder trustToken(String trustToken) { this.trustToken = trustToken; return this; }
    public Builder twoFactorId(String twoFactorId) { this.twoFactorId = twoFactorId; return this; }
    public Builder twoFactorTrustId(String twoFactorTrustId) { this.twoFactorTrustId = twoFactorTrustId; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public LoginResponse build() { return new LoginResponse(actions, changePasswordId, changePasswordReason, configurableMethods, emailVerificationId, identityVerificationId, methods, pendingIdPLinkId, refreshToken, refreshTokenId, registrationVerificationId, state, threatsDetected, token, tokenExpirationInstant, trustToken, twoFactorId, twoFactorTrustId, user); }
  }
}
