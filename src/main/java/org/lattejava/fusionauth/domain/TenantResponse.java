/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantResponseJSON;

@JSON
public record TenantResponse(
    Tenant tenant,
    List<Tenant> tenants) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantResponseJSON.toJSONBytes(this);
  }

  public static TenantResponse fromJSON(String json) {
    return TenantResponseJSON.fromJSON(json);
  }

  public static TenantResponse fromJSONBytes(byte[] json) {
    return TenantResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Tenant tenant;
    private List<Tenant> tenants;
    public Builder tenant(Tenant tenant) { this.tenant = tenant; return this; }
    public Builder tenants(List<Tenant> tenants) { this.tenants = tenants; return this; }
    public TenantResponse build() { return new TenantResponse(tenant, tenants); }
  }
}
