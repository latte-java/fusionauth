/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderRequestJSON;

@JSON
public record IdentityProviderRequest(
    IdentityProviderField identityProvider) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderRequestJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderRequest fromJSON(String json) {
    return IdentityProviderRequestJSON.fromJSON(json);
  }
  
  public static IdentityProviderRequest fromJSONBytes(byte[] json) {
    return IdentityProviderRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private IdentityProviderField identityProvider;
    public Builder identityProvider(IdentityProviderField identityProvider) { this.identityProvider = identityProvider; return this; }
    public IdentityProviderRequest build() { return new IdentityProviderRequest(identityProvider); }
  }
}
