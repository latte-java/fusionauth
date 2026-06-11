/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DomainBasedIdentityProviderJSON;

@JSON
public record DomainBasedIdentityProvider() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DomainBasedIdentityProviderJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return DomainBasedIdentityProviderJSON.toJSONBytes(this);
  }

  public static DomainBasedIdentityProvider fromJSON(String json) {
    return DomainBasedIdentityProviderJSON.fromJSON(json);
  }

  public static DomainBasedIdentityProvider fromJSONBytes(byte[] json) {
    return DomainBasedIdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    public DomainBasedIdentityProvider build() { return new DomainBasedIdentityProvider(); }
  }
}
