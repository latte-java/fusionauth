/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserIdentityProviderLinkEventJSON;

@JSON
public record UserIdentityProviderLinkEvent(
    IdentityProviderLink identityProviderLink,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserIdentityProviderLinkEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserIdentityProviderLinkEventJSON.toJSONBytes(this);
  }

  public static UserIdentityProviderLinkEvent fromJSON(String json) {
    return UserIdentityProviderLinkEventJSON.fromJSON(json);
  }

  public static UserIdentityProviderLinkEvent fromJSONBytes(byte[] json) {
    return UserIdentityProviderLinkEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private IdentityProviderLink identityProviderLink;
    private User user;
    public Builder identityProviderLink(IdentityProviderLink identityProviderLink) { this.identityProviderLink = identityProviderLink; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserIdentityProviderLinkEvent build() { return new UserIdentityProviderLinkEvent(identityProviderLink, user); }
  }
}
