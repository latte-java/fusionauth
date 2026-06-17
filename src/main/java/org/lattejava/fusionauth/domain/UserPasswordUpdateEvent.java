/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserPasswordUpdateEventJSON;

@JSON
public record UserPasswordUpdateEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserPasswordUpdateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserPasswordUpdateEventJSON.toJSONBytes(this);
  }
  
  public static UserPasswordUpdateEvent fromJSON(String json) {
    return UserPasswordUpdateEventJSON.fromJSON(json);
  }
  
  public static UserPasswordUpdateEvent fromJSONBytes(byte[] json) {
    return UserPasswordUpdateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserPasswordUpdateEvent build() { return new UserPasswordUpdateEvent(user); }
  }
}
