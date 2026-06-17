/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserConsentResponseJSON;

@JSON
public record UserConsentResponse(
    UserConsent userConsent,
    List<UserConsent> userConsents) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserConsentResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserConsentResponseJSON.toJSONBytes(this);
  }
  
  public static UserConsentResponse fromJSON(String json) {
    return UserConsentResponseJSON.fromJSON(json);
  }
  
  public static UserConsentResponse fromJSONBytes(byte[] json) {
    return UserConsentResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserConsent userConsent;
    private List<UserConsent> userConsents;
    public Builder userConsent(UserConsent userConsent) { this.userConsent = userConsent; return this; }
    public Builder userConsents(List<UserConsent> userConsents) { this.userConsents = userConsents; return this; }
    public UserConsentResponse build() { return new UserConsentResponse(userConsent, userConsents); }
  }
}
