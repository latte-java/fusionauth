/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRegistrationCreateEventJSON;

@JSON
public record UserRegistrationCreateEvent(
    UUID applicationId,
    UserRegistration registration,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRegistrationCreateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRegistrationCreateEventJSON.toJSONBytes(this);
  }

  public static UserRegistrationCreateEvent fromJSON(String json) {
    return UserRegistrationCreateEventJSON.fromJSON(json);
  }

  public static UserRegistrationCreateEvent fromJSONBytes(byte[] json) {
    return UserRegistrationCreateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private UserRegistration registration;
    private User user;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder registration(UserRegistration registration) { this.registration = registration; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserRegistrationCreateEvent build() { return new UserRegistrationCreateEvent(applicationId, registration, user); }
  }
}
