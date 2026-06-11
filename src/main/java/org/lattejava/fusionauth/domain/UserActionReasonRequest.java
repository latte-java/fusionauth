/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionReasonRequestJSON;

@JSON
public record UserActionReasonRequest(
    UserActionReason userActionReason) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionReasonRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserActionReasonRequestJSON.toJSONBytes(this);
  }

  public static UserActionReasonRequest fromJSON(String json) {
    return UserActionReasonRequestJSON.fromJSON(json);
  }

  public static UserActionReasonRequest fromJSONBytes(byte[] json) {
    return UserActionReasonRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserActionReason userActionReason;
    public Builder userActionReason(UserActionReason userActionReason) { this.userActionReason = userActionReason; return this; }
    public UserActionReasonRequest build() { return new UserActionReasonRequest(userActionReason); }
  }
}
