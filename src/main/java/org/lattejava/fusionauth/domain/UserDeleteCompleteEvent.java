/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserDeleteCompleteEventJSON;

@JSON
public record UserDeleteCompleteEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserDeleteCompleteEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserDeleteCompleteEventJSON.toJSONBytes(this);
  }
  
  public static UserDeleteCompleteEvent fromJSON(String json) {
    return UserDeleteCompleteEventJSON.fromJSON(json);
  }
  
  public static UserDeleteCompleteEvent fromJSONBytes(byte[] json) {
    return UserDeleteCompleteEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserDeleteCompleteEvent build() { return new UserDeleteCompleteEvent(user); }
  }
}
