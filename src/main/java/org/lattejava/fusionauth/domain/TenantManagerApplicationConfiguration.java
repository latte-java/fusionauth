/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantManagerApplicationConfigurationJSON;

@JSON
public record TenantManagerApplicationConfiguration(
    UUID applicationId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantManagerApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantManagerApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantManagerApplicationConfiguration fromJSON(String json) {
    return TenantManagerApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static TenantManagerApplicationConfiguration fromJSONBytes(byte[] json) {
    return TenantManagerApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public TenantManagerApplicationConfiguration build() { return new TenantManagerApplicationConfiguration(applicationId); }
  }
}
