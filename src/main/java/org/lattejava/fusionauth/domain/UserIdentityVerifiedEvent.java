/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserIdentityVerifiedEventJSON;

@JSON
public record UserIdentityVerifiedEvent(
    String loginId,
    String loginIdType,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserIdentityVerifiedEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserIdentityVerifiedEventJSON.toJSONBytes(this);
  }

  public static UserIdentityVerifiedEvent fromJSON(String json) {
    return UserIdentityVerifiedEventJSON.fromJSON(json);
  }

  public static UserIdentityVerifiedEvent fromJSONBytes(byte[] json) {
    return UserIdentityVerifiedEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private String loginId;
    private String loginIdType;
    private User user;
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdType(String loginIdType) { this.loginIdType = loginIdType; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserIdentityVerifiedEvent build() { return new UserIdentityVerifiedEvent(loginId, loginIdType, user); }
  }
}
