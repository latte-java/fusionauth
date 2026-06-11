/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRegistrationCreateCompleteEventJSON;

@JSON
public record UserRegistrationCreateCompleteEvent(
    UUID applicationId,
    UserRegistration registration,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRegistrationCreateCompleteEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRegistrationCreateCompleteEventJSON.toJSONBytes(this);
  }

  public static UserRegistrationCreateCompleteEvent fromJSON(String json) {
    return UserRegistrationCreateCompleteEventJSON.fromJSON(json);
  }

  public static UserRegistrationCreateCompleteEvent fromJSONBytes(byte[] json) {
    return UserRegistrationCreateCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private UserRegistration registration;
    private User user;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder registration(UserRegistration registration) { this.registration = registration; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserRegistrationCreateCompleteEvent build() { return new UserRegistrationCreateCompleteEvent(applicationId, registration, user); }
  }
}
