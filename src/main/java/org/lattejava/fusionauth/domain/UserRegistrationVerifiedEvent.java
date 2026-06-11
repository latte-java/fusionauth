/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRegistrationVerifiedEventJSON;

@JSON
public record UserRegistrationVerifiedEvent(
    UUID applicationId,
    UserRegistration registration,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRegistrationVerifiedEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRegistrationVerifiedEventJSON.toJSONBytes(this);
  }

  public static UserRegistrationVerifiedEvent fromJSON(String json) {
    return UserRegistrationVerifiedEventJSON.fromJSON(json);
  }

  public static UserRegistrationVerifiedEvent fromJSONBytes(byte[] json) {
    return UserRegistrationVerifiedEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private UserRegistration registration;
    private User user;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder registration(UserRegistration registration) { this.registration = registration; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserRegistrationVerifiedEvent build() { return new UserRegistrationVerifiedEvent(applicationId, registration, user); }
  }
}
