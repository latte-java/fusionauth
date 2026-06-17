/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderResponseJSON;

@JSON
public record IdentityProviderResponse(
    IdentityProviderField identityProvider,
    List<IdentityProviderField> identityProviders) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderResponseJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderResponse fromJSON(String json) {
    return IdentityProviderResponseJSON.fromJSON(json);
  }
  
  public static IdentityProviderResponse fromJSONBytes(byte[] json) {
    return IdentityProviderResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private IdentityProviderField identityProvider;
    private List<IdentityProviderField> identityProviders;
    public Builder identityProvider(IdentityProviderField identityProvider) { this.identityProvider = identityProvider; return this; }
    public Builder identityProviders(List<IdentityProviderField> identityProviders) { this.identityProviders = identityProviders; return this; }
    public IdentityProviderResponse build() { return new IdentityProviderResponse(identityProvider, identityProviders); }
  }
}
