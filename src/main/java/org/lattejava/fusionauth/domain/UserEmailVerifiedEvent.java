/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserEmailVerifiedEventJSON;

@JSON
public record UserEmailVerifiedEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserEmailVerifiedEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserEmailVerifiedEventJSON.toJSONBytes(this);
  }

  public static UserEmailVerifiedEvent fromJSON(String json) {
    return UserEmailVerifiedEventJSON.fromJSON(json);
  }

  public static UserEmailVerifiedEvent fromJSONBytes(byte[] json) {
    return UserEmailVerifiedEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserEmailVerifiedEvent build() { return new UserEmailVerifiedEvent(user); }
  }
}
