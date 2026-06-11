/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCreateCompleteEventJSON;

@JSON
public record UserCreateCompleteEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCreateCompleteEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserCreateCompleteEventJSON.toJSONBytes(this);
  }

  public static UserCreateCompleteEvent fromJSON(String json) {
    return UserCreateCompleteEventJSON.fromJSON(json);
  }

  public static UserCreateCompleteEvent fromJSONBytes(byte[] json) {
    return UserCreateCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserCreateCompleteEvent build() { return new UserCreateCompleteEvent(user); }
  }
}
