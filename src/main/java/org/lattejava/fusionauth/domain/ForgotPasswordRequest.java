/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ForgotPasswordRequestJSON;

@JSON
public record ForgotPasswordRequest(
    UUID applicationId,
    String changePasswordId,
    String loginId,
    List<String> loginIdTypes,
    Boolean sendForgotPasswordEmail,
    Boolean sendForgotPasswordMessage,
    Map<String, Object> state,
    String email,
    String username,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ForgotPasswordRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ForgotPasswordRequestJSON.toJSONBytes(this);
  }

  public static ForgotPasswordRequest fromJSON(String json) {
    return ForgotPasswordRequestJSON.fromJSON(json);
  }

  public static ForgotPasswordRequest fromJSONBytes(byte[] json) {
    return ForgotPasswordRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String changePasswordId;
    private String loginId;
    private List<String> loginIdTypes;
    private Boolean sendForgotPasswordEmail;
    private Boolean sendForgotPasswordMessage;
    private Map<String, Object> state;
    private String email;
    private String username;
    private EventInfo eventInfo;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder changePasswordId(String changePasswordId) { this.changePasswordId = changePasswordId; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdTypes(List<String> loginIdTypes) { this.loginIdTypes = loginIdTypes; return this; }
    public Builder sendForgotPasswordEmail(Boolean sendForgotPasswordEmail) { this.sendForgotPasswordEmail = sendForgotPasswordEmail; return this; }
    public Builder sendForgotPasswordMessage(Boolean sendForgotPasswordMessage) { this.sendForgotPasswordMessage = sendForgotPasswordMessage; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public Builder email(String email) { this.email = email; return this; }
    public Builder username(String username) { this.username = username; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public ForgotPasswordRequest build() { return new ForgotPasswordRequest(applicationId, changePasswordId, loginId, loginIdTypes, sendForgotPasswordEmail, sendForgotPasswordMessage, state, email, username, eventInfo); }
  }
}
