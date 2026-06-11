/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserUpdateCompleteEventJSON;

@JSON
public record UserUpdateCompleteEvent(
    User original,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserUpdateCompleteEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserUpdateCompleteEventJSON.toJSONBytes(this);
  }

  public static UserUpdateCompleteEvent fromJSON(String json) {
    return UserUpdateCompleteEventJSON.fromJSON(json);
  }

  public static UserUpdateCompleteEvent fromJSONBytes(byte[] json) {
    return UserUpdateCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User original;
    private User user;
    public Builder original(User original) { this.original = original; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserUpdateCompleteEvent build() { return new UserUpdateCompleteEvent(original, user); }
  }
}
