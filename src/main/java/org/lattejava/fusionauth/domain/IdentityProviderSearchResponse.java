/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderSearchResponseJSON;

@JSON
public record IdentityProviderSearchResponse(
    List<IdentityProviderField> identityProviders,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderSearchResponseJSON.toJSONBytes(this);
  }

  public static IdentityProviderSearchResponse fromJSON(String json) {
    return IdentityProviderSearchResponseJSON.fromJSON(json);
  }

  public static IdentityProviderSearchResponse fromJSONBytes(byte[] json) {
    return IdentityProviderSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<IdentityProviderField> identityProviders;
    private Long total;
    public Builder identityProviders(List<IdentityProviderField> identityProviders) { this.identityProviders = identityProviders; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public IdentityProviderSearchResponse build() { return new IdentityProviderSearchResponse(identityProviders, total); }
  }
}
