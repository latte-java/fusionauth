/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionRequestJSON;

@JSON
public record UserActionRequest(
    UserAction userAction) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserActionRequestJSON.toJSONBytes(this);
  }

  public static UserActionRequest fromJSON(String json) {
    return UserActionRequestJSON.fromJSON(json);
  }

  public static UserActionRequest fromJSONBytes(byte[] json) {
    return UserActionRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserAction userAction;
    public Builder userAction(UserAction userAction) { this.userAction = userAction; return this; }
    public UserActionRequest build() { return new UserActionRequest(userAction); }
  }
}
