/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserPasswordBreachEventJSON;

@JSON
public record UserPasswordBreachEvent(
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserPasswordBreachEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserPasswordBreachEventJSON.toJSONBytes(this);
  }
  
  public static UserPasswordBreachEvent fromJSON(String json) {
    return UserPasswordBreachEventJSON.fromJSON(json);
  }
  
  public static UserPasswordBreachEvent fromJSONBytes(byte[] json) {
    return UserPasswordBreachEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User user;
    public Builder user(User user) { this.user = user; return this; }
    public UserPasswordBreachEvent build() { return new UserPasswordBreachEvent(user); }
  }
}
