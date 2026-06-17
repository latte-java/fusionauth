/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserPasswordResetSuccessEventJSON;

@JSON
public record UserPasswordResetSuccessEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserPasswordResetSuccessEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserPasswordResetSuccessEventJSON.toJSONBytes(this);
  }
  
  public static UserPasswordResetSuccessEvent fromJSON(String json) {
    return UserPasswordResetSuccessEventJSON.fromJSON(json);
  }
  
  public static UserPasswordResetSuccessEvent fromJSONBytes(byte[] json) {
    return UserPasswordResetSuccessEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserPasswordResetSuccessEvent build() { return new UserPasswordResetSuccessEvent(user); }
  }
}
