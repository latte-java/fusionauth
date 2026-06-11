/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRegistrationDeleteEventJSON;

@JSON
public record UserRegistrationDeleteEvent(
    UUID applicationId,
    UserRegistration registration,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRegistrationDeleteEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRegistrationDeleteEventJSON.toJSONBytes(this);
  }

  public static UserRegistrationDeleteEvent fromJSON(String json) {
    return UserRegistrationDeleteEventJSON.fromJSON(json);
  }

  public static UserRegistrationDeleteEvent fromJSONBytes(byte[] json) {
    return UserRegistrationDeleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private UserRegistration registration;
    private User user;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder registration(UserRegistration registration) { this.registration = registration; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserRegistrationDeleteEvent build() { return new UserRegistrationDeleteEvent(applicationId, registration, user); }
  }
}
