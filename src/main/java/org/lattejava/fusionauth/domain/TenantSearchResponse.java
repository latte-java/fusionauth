/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantSearchResponseJSON;

@JSON
public record TenantSearchResponse(
    List<Tenant> tenants,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantSearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantSearchResponseJSON.toJSONBytes(this);
  }
  
  public static TenantSearchResponse fromJSON(String json) {
    return TenantSearchResponseJSON.fromJSON(json);
  }
  
  public static TenantSearchResponse fromJSONBytes(byte[] json) {
    return TenantSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Tenant> tenants;
    private Long total;
    public Builder tenants(List<Tenant> tenants) { this.tenants = tenants; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public TenantSearchResponse build() { return new TenantSearchResponse(tenants, total); }
  }
}
