/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantAccessControlConfigurationJSON;

@JSON
public record TenantAccessControlConfiguration(
    UUID uiIPAccessControlListId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantAccessControlConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantAccessControlConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantAccessControlConfiguration fromJSON(String json) {
    return TenantAccessControlConfigurationJSON.fromJSON(json);
  }
  
  public static TenantAccessControlConfiguration fromJSONBytes(byte[] json) {
    return TenantAccessControlConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID uiIPAccessControlListId;
    public Builder uiIPAccessControlListId(UUID uiIPAccessControlListId) { this.uiIPAccessControlListId = uiIPAccessControlListId; return this; }
    public TenantAccessControlConfiguration build() { return new TenantAccessControlConfiguration(uiIPAccessControlListId); }
  }
}
