/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantFormConfigurationJSON;

@JSON
public record TenantFormConfiguration(
    UUID adminUserFormId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantFormConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantFormConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantFormConfiguration fromJSON(String json) {
    return TenantFormConfigurationJSON.fromJSON(json);
  }
  
  public static TenantFormConfiguration fromJSONBytes(byte[] json) {
    return TenantFormConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID adminUserFormId;
    public Builder adminUserFormId(UUID adminUserFormId) { this.adminUserFormId = adminUserFormId; return this; }
    public TenantFormConfiguration build() { return new TenantFormConfiguration(adminUserFormId); }
  }
}
