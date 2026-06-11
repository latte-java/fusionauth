/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRegistrationDeleteCompleteEventJSON;

@JSON
public record UserRegistrationDeleteCompleteEvent(
    UUID applicationId,
    UserRegistration registration,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRegistrationDeleteCompleteEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRegistrationDeleteCompleteEventJSON.toJSONBytes(this);
  }

  public static UserRegistrationDeleteCompleteEvent fromJSON(String json) {
    return UserRegistrationDeleteCompleteEventJSON.fromJSON(json);
  }

  public static UserRegistrationDeleteCompleteEvent fromJSONBytes(byte[] json) {
    return UserRegistrationDeleteCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private UserRegistration registration;
    private User user;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder registration(UserRegistration registration) { this.registration = registration; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserRegistrationDeleteCompleteEvent build() { return new UserRegistrationDeleteCompleteEvent(applicationId, registration, user); }
  }
}
