/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionReasonResponseJSON;

@JSON
public record UserActionReasonResponse(
    UserActionReason userActionReason,
    List<UserActionReason> userActionReasons) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionReasonResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserActionReasonResponseJSON.toJSONBytes(this);
  }
  
  public static UserActionReasonResponse fromJSON(String json) {
    return UserActionReasonResponseJSON.fromJSON(json);
  }
  
  public static UserActionReasonResponse fromJSONBytes(byte[] json) {
    return UserActionReasonResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserActionReason userActionReason;
    private List<UserActionReason> userActionReasons;
    public Builder userActionReason(UserActionReason userActionReason) { this.userActionReason = userActionReason; return this; }
    public Builder userActionReasons(List<UserActionReason> userActionReasons) { this.userActionReasons = userActionReasons; return this; }
    public UserActionReasonResponse build() { return new UserActionReasonResponse(userActionReason, userActionReasons); }
  }
}
