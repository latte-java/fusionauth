/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionResponseJSON;

@JSON
public record UserActionResponse(
    UserAction userAction,
    List<UserAction> userActions) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserActionResponseJSON.toJSONBytes(this);
  }
  
  public static UserActionResponse fromJSON(String json) {
    return UserActionResponseJSON.fromJSON(json);
  }
  
  public static UserActionResponse fromJSONBytes(byte[] json) {
    return UserActionResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserAction userAction;
    private List<UserAction> userActions;
    public Builder userAction(UserAction userAction) { this.userAction = userAction; return this; }
    public Builder userActions(List<UserAction> userActions) { this.userActions = userActions; return this; }
    public UserActionResponse build() { return new UserActionResponse(userAction, userActions); }
  }
}
