/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserUpdateEventJSON;

@JSON
public record UserUpdateEvent(
    User original,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserUpdateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserUpdateEventJSON.toJSONBytes(this);
  }
  
  public static UserUpdateEvent fromJSON(String json) {
    return UserUpdateEventJSON.fromJSON(json);
  }
  
  public static UserUpdateEvent fromJSONBytes(byte[] json) {
    return UserUpdateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User original;
    private User user;
    public Builder original(User original) { this.original = original; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserUpdateEvent build() { return new UserUpdateEvent(original, user); }
  }
}
