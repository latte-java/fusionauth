/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserPasswordResetSendEventJSON;

@JSON
public record UserPasswordResetSendEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserPasswordResetSendEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserPasswordResetSendEventJSON.toJSONBytes(this);
  }
  
  public static UserPasswordResetSendEvent fromJSON(String json) {
    return UserPasswordResetSendEventJSON.fromJSON(json);
  }
  
  public static UserPasswordResetSendEvent fromJSONBytes(byte[] json) {
    return UserPasswordResetSendEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserPasswordResetSendEvent build() { return new UserPasswordResetSendEvent(user); }
  }
}
