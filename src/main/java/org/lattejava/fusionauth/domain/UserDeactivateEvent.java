/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserDeactivateEventJSON;

@JSON
public record UserDeactivateEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserDeactivateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserDeactivateEventJSON.toJSONBytes(this);
  }
  
  public static UserDeactivateEvent fromJSON(String json) {
    return UserDeactivateEventJSON.fromJSON(json);
  }
  
  public static UserDeactivateEvent fromJSONBytes(byte[] json) {
    return UserDeactivateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserDeactivateEvent build() { return new UserDeactivateEvent(user); }
  }
}
