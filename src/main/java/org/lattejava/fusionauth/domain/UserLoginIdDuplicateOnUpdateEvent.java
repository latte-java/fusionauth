/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserLoginIdDuplicateOnUpdateEventJSON;

@JSON
public record UserLoginIdDuplicateOnUpdateEvent(
    User existing,
    String duplicateEmail,
    List<IdentityInfo> duplicateIdentities,
    String duplicatePhoneNumber,
    String duplicateUsername) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserLoginIdDuplicateOnUpdateEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserLoginIdDuplicateOnUpdateEventJSON.toJSONBytes(this);
  }
  
  public static UserLoginIdDuplicateOnUpdateEvent fromJSON(String json) {
    return UserLoginIdDuplicateOnUpdateEventJSON.fromJSON(json);
  }
  
  public static UserLoginIdDuplicateOnUpdateEvent fromJSONBytes(byte[] json) {
    return UserLoginIdDuplicateOnUpdateEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private User existing;
    private String duplicateEmail;
    private List<IdentityInfo> duplicateIdentities;
    private String duplicatePhoneNumber;
    private String duplicateUsername;
    public Builder existing(User existing) { this.existing = existing; return this; }
    public Builder duplicateEmail(String duplicateEmail) { this.duplicateEmail = duplicateEmail; return this; }
    public Builder duplicateIdentities(List<IdentityInfo> duplicateIdentities) { this.duplicateIdentities = duplicateIdentities; return this; }
    public Builder duplicatePhoneNumber(String duplicatePhoneNumber) { this.duplicatePhoneNumber = duplicatePhoneNumber; return this; }
    public Builder duplicateUsername(String duplicateUsername) { this.duplicateUsername = duplicateUsername; return this; }
    public UserLoginIdDuplicateOnUpdateEvent build() { return new UserLoginIdDuplicateOnUpdateEvent(existing, duplicateEmail, duplicateIdentities, duplicatePhoneNumber, duplicateUsername); }
  }
}
