/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserEmailUpdateEventJSON;

@JSON
public record UserEmailUpdateEvent(
    String previousEmail,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserEmailUpdateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserEmailUpdateEventJSON.toJSONBytes(this);
  }

  public static UserEmailUpdateEvent fromJSON(String json) {
    return UserEmailUpdateEventJSON.fromJSON(json);
  }

  public static UserEmailUpdateEvent fromJSONBytes(byte[] json) {
    return UserEmailUpdateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private String previousEmail;
    private User user;
    public Builder previousEmail(String previousEmail) { this.previousEmail = previousEmail; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserEmailUpdateEvent build() { return new UserEmailUpdateEvent(previousEmail, user); }
  }
}
