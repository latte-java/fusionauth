/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserReactivateEventJSON;

@JSON
public record UserReactivateEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserReactivateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserReactivateEventJSON.toJSONBytes(this);
  }
  
  public static UserReactivateEvent fromJSON(String json) {
    return UserReactivateEventJSON.fromJSON(json);
  }
  
  public static UserReactivateEvent fromJSONBytes(byte[] json) {
    return UserReactivateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserReactivateEvent build() { return new UserReactivateEvent(user); }
  }
}
