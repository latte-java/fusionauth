/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserTwoFactorMethodRemoveEventJSON;

@JSON
public record UserTwoFactorMethodRemoveEvent(
    TwoFactorMethod method,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserTwoFactorMethodRemoveEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserTwoFactorMethodRemoveEventJSON.toJSONBytes(this);
  }

  public static UserTwoFactorMethodRemoveEvent fromJSON(String json) {
    return UserTwoFactorMethodRemoveEventJSON.fromJSON(json);
  }

  public static UserTwoFactorMethodRemoveEvent fromJSONBytes(byte[] json) {
    return UserTwoFactorMethodRemoveEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private TwoFactorMethod method;
    private User user;
    public Builder method(TwoFactorMethod method) { this.method = method; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserTwoFactorMethodRemoveEvent build() { return new UserTwoFactorMethodRemoveEvent(method, user); }
  }
}
