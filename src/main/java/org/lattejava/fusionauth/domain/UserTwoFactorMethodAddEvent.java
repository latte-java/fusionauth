/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserTwoFactorMethodAddEventJSON;

@JSON
public record UserTwoFactorMethodAddEvent(
    TwoFactorMethod method,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserTwoFactorMethodAddEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserTwoFactorMethodAddEventJSON.toJSONBytes(this);
  }

  public static UserTwoFactorMethodAddEvent fromJSON(String json) {
    return UserTwoFactorMethodAddEventJSON.fromJSON(json);
  }

  public static UserTwoFactorMethodAddEvent fromJSONBytes(byte[] json) {
    return UserTwoFactorMethodAddEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private TwoFactorMethod method;
    private User user;
    public Builder method(TwoFactorMethod method) { this.method = method; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserTwoFactorMethodAddEvent build() { return new UserTwoFactorMethodAddEvent(method, user); }
  }
}
