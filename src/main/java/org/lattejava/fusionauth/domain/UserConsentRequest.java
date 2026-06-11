/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserConsentRequestJSON;

@JSON
public record UserConsentRequest(
    UserConsent userConsent) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserConsentRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserConsentRequestJSON.toJSONBytes(this);
  }

  public static UserConsentRequest fromJSON(String json) {
    return UserConsentRequestJSON.fromJSON(json);
  }

  public static UserConsentRequest fromJSONBytes(byte[] json) {
    return UserConsentRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserConsent userConsent;
    public Builder userConsent(UserConsent userConsent) { this.userConsent = userConsent; return this; }
    public UserConsentRequest build() { return new UserConsentRequest(userConsent); }
  }
}
