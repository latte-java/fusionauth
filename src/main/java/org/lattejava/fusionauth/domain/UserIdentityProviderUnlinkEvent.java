/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserIdentityProviderUnlinkEventJSON;

@JSON
public record UserIdentityProviderUnlinkEvent(
    IdentityProviderLink identityProviderLink,
    User user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserIdentityProviderUnlinkEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserIdentityProviderUnlinkEventJSON.toJSONBytes(this);
  }
  
  public static UserIdentityProviderUnlinkEvent fromJSON(String json) {
    return UserIdentityProviderUnlinkEventJSON.fromJSON(json);
  }
  
  public static UserIdentityProviderUnlinkEvent fromJSONBytes(byte[] json) {
    return UserIdentityProviderUnlinkEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private IdentityProviderLink identityProviderLink;
    private User user;
    public Builder identityProviderLink(IdentityProviderLink identityProviderLink) { this.identityProviderLink = identityProviderLink; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public UserIdentityProviderUnlinkEvent build() { return new UserIdentityProviderUnlinkEvent(identityProviderLink, user); }
  }
}
