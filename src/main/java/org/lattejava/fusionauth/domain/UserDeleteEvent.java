/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserDeleteEventJSON;

@JSON
public record UserDeleteEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserDeleteEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserDeleteEventJSON.toJSONBytes(this);
  }

  public static UserDeleteEvent fromJSON(String json) {
    return UserDeleteEventJSON.fromJSON(json);
  }

  public static UserDeleteEvent fromJSONBytes(byte[] json) {
    return UserDeleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserDeleteEvent build() { return new UserDeleteEvent(user); }
  }
}
