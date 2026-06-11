/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordlessIdentityProviderJSON;

@JSON
public record PasswordlessIdentityProvider() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordlessIdentityProviderJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PasswordlessIdentityProviderJSON.toJSONBytes(this);
  }

  public static PasswordlessIdentityProvider fromJSON(String json) {
    return PasswordlessIdentityProviderJSON.fromJSON(json);
  }

  public static PasswordlessIdentityProvider fromJSONBytes(byte[] json) {
    return PasswordlessIdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    public PasswordlessIdentityProvider build() { return new PasswordlessIdentityProvider(); }
  }
}
