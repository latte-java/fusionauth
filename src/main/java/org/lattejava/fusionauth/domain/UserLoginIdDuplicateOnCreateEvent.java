/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserLoginIdDuplicateOnCreateEventJSON;

@JSON
public record UserLoginIdDuplicateOnCreateEvent(
    User existing,
    String duplicateEmail,
    List<IdentityInfo> duplicateIdentities,
    String duplicatePhoneNumber,
    String duplicateUsername,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserLoginIdDuplicateOnCreateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserLoginIdDuplicateOnCreateEventJSON.toJSONBytes(this);
  }
  
  public static UserLoginIdDuplicateOnCreateEvent fromJSON(String json) {
    return UserLoginIdDuplicateOnCreateEventJSON.fromJSON(json);
  }
  
  public static UserLoginIdDuplicateOnCreateEvent fromJSONBytes(byte[] json) {
    return UserLoginIdDuplicateOnCreateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User existing;
    private String duplicateEmail;
    private List<IdentityInfo> duplicateIdentities;
    private String duplicatePhoneNumber;
    private String duplicateUsername;
    private User user;
    public Builder existing(User existing) { this.existing = existing; return this; }
    public Builder duplicateEmail(String duplicateEmail) { this.duplicateEmail = duplicateEmail; return this; }
    public Builder duplicateIdentities(List<IdentityInfo> duplicateIdentities) { this.duplicateIdentities = duplicateIdentities; return this; }
    public Builder duplicatePhoneNumber(String duplicatePhoneNumber) { this.duplicatePhoneNumber = duplicatePhoneNumber; return this; }
    public Builder duplicateUsername(String duplicateUsername) { this.duplicateUsername = duplicateUsername; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserLoginIdDuplicateOnCreateEvent build() { return new UserLoginIdDuplicateOnCreateEvent(existing, duplicateEmail, duplicateIdentities, duplicatePhoneNumber, duplicateUsername, user); }
  }
}
