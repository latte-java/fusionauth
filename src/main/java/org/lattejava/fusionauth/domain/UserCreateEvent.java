/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCreateEventJSON;

@JSON
public record UserCreateEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCreateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserCreateEventJSON.toJSONBytes(this);
  }
  
  public static UserCreateEvent fromJSON(String json) {
    return UserCreateEventJSON.fromJSON(json);
  }
  
  public static UserCreateEvent fromJSONBytes(byte[] json) {
    return UserCreateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserCreateEvent build() { return new UserCreateEvent(user); }
  }
}
