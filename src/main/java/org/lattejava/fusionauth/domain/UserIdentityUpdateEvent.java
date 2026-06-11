/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserIdentityUpdateEventJSON;

@JSON
public record UserIdentityUpdateEvent(
    String loginIdType,
    String newLoginId,
    String previousLoginId,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserIdentityUpdateEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserIdentityUpdateEventJSON.toJSONBytes(this);
  }

  public static UserIdentityUpdateEvent fromJSON(String json) {
    return UserIdentityUpdateEventJSON.fromJSON(json);
  }

  public static UserIdentityUpdateEvent fromJSONBytes(byte[] json) {
    return UserIdentityUpdateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private String loginIdType;
    private String newLoginId;
    private String previousLoginId;
    private User user;
    public Builder loginIdType(String loginIdType) { this.loginIdType = loginIdType; return this; }
    public Builder newLoginId(String newLoginId) { this.newLoginId = newLoginId; return this; }
    public Builder previousLoginId(String previousLoginId) { this.previousLoginId = previousLoginId; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserIdentityUpdateEvent build() { return new UserIdentityUpdateEvent(loginIdType, newLoginId, previousLoginId, user); }
  }
}
