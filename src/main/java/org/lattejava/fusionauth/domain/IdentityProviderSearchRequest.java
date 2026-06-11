/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderSearchRequestJSON;

@JSON
public record IdentityProviderSearchRequest(
    IdentityProviderSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderSearchRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderSearchRequestJSON.toJSONBytes(this);
  }

  public static IdentityProviderSearchRequest fromJSON(String json) {
    return IdentityProviderSearchRequestJSON.fromJSON(json);
  }

  public static IdentityProviderSearchRequest fromJSONBytes(byte[] json) {
    return IdentityProviderSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private IdentityProviderSearchCriteria search;
    public Builder search(IdentityProviderSearchCriteria search) { this.search = search; return this; }
    public IdentityProviderSearchRequest build() { return new IdentityProviderSearchRequest(search); }
  }
}
