/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantSearchRequestJSON;

@JSON
public record TenantSearchRequest(
    TenantSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantSearchRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantSearchRequestJSON.toJSONBytes(this);
  }

  public static TenantSearchRequest fromJSON(String json) {
    return TenantSearchRequestJSON.fromJSON(json);
  }

  public static TenantSearchRequest fromJSONBytes(byte[] json) {
    return TenantSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private TenantSearchCriteria search;
    public Builder search(TenantSearchCriteria search) { this.search = search; return this; }
    public TenantSearchRequest build() { return new TenantSearchRequest(search); }
  }
}
