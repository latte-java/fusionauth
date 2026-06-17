/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserLoginFailedReasonCodeJSON;

@JSON
public record UserLoginFailedReasonCode() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserLoginFailedReasonCodeJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserLoginFailedReasonCodeJSON.toJSONBytes(this);
  }
  
  public static UserLoginFailedReasonCode fromJSON(String json) {
    return UserLoginFailedReasonCodeJSON.fromJSON(json);
  }
  
  public static UserLoginFailedReasonCode fromJSONBytes(byte[] json) {
    return UserLoginFailedReasonCodeJSON.fromJSON(json);
  }

  public static final class Builder {
    public UserLoginFailedReasonCode build() { return new UserLoginFailedReasonCode(); }
  }
}
