/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRegistrationUpdateEventJSON;

@JSON
public record UserRegistrationUpdateEvent(
    UUID applicationId,
    UserRegistration original,
    UserRegistration registration,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRegistrationUpdateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRegistrationUpdateEventJSON.toJSONBytes(this);
  }

  public static UserRegistrationUpdateEvent fromJSON(String json) {
    return UserRegistrationUpdateEventJSON.fromJSON(json);
  }

  public static UserRegistrationUpdateEvent fromJSONBytes(byte[] json) {
    return UserRegistrationUpdateEventJSON.fromJSON(json);
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
    public UserRegistrationUpdateEvent build() { return new UserRegistrationUpdateEvent(applicationId, original, registration, user); }
  }
}
