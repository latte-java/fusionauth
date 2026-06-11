/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRegistrationUpdateCompleteEventJSON;

@JSON
public record UserRegistrationUpdateCompleteEvent(
    UUID applicationId,
    UserRegistration original,
    UserRegistration registration,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRegistrationUpdateCompleteEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRegistrationUpdateCompleteEventJSON.toJSONBytes(this);
  }

  public static UserRegistrationUpdateCompleteEvent fromJSON(String json) {
    return UserRegistrationUpdateCompleteEventJSON.fromJSON(json);
  }

  public static UserRegistrationUpdateCompleteEvent fromJSONBytes(byte[] json) {
    return UserRegistrationUpdateCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private UserRegistration original;
    private UserRegistration registration;
    private User user;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder original(UserRegistration original) { this.original = original; return this; }
    public Builder registration(UserRegistration registration) { this.registration = registration; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserRegistrationUpdateCompleteEvent build() { return new UserRegistrationUpdateCompleteEvent(applicationId, original, registration, user); }
  }
}
