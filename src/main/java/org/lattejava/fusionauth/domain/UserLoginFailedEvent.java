/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserLoginFailedEventJSON;

@JSON
public record UserLoginFailedEvent(
    UUID applicationId,
    String authenticationType,
    String ipAddress,
    UserLoginFailedReason reason,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserLoginFailedEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserLoginFailedEventJSON.toJSONBytes(this);
  }

  public static UserLoginFailedEvent fromJSON(String json) {
    return UserLoginFailedEventJSON.fromJSON(json);
  }

  public static UserLoginFailedEvent fromJSONBytes(byte[] json) {
    return UserLoginFailedEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String authenticationType;
    private String ipAddress;
    private UserLoginFailedReason reason;
    private User user;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder authenticationType(String authenticationType) { this.authenticationType = authenticationType; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder reason(UserLoginFailedReason reason) { this.reason = reason; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserLoginFailedEvent build() { return new UserLoginFailedEvent(applicationId, authenticationType, ipAddress, reason, user); }
  }
}
