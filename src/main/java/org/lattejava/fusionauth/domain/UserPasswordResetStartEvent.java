/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserPasswordResetStartEventJSON;

@JSON
public record UserPasswordResetStartEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserPasswordResetStartEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserPasswordResetStartEventJSON.toJSONBytes(this);
  }

  public static UserPasswordResetStartEvent fromJSON(String json) {
    return UserPasswordResetStartEventJSON.fromJSON(json);
  }

  public static UserPasswordResetStartEvent fromJSONBytes(byte[] json) {
    return UserPasswordResetStartEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserPasswordResetStartEvent build() { return new UserPasswordResetStartEvent(user); }
  }
}
