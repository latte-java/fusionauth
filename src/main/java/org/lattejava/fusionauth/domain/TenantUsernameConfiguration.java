/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantUsernameConfigurationJSON;

@JSON
public record TenantUsernameConfiguration(
    UniqueUsernameConfiguration unique) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantUsernameConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantUsernameConfigurationJSON.toJSONBytes(this);
  }

  public static TenantUsernameConfiguration fromJSON(String json) {
    return TenantUsernameConfigurationJSON.fromJSON(json);
  }

  public static TenantUsernameConfiguration fromJSONBytes(byte[] json) {
    return TenantUsernameConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UniqueUsernameConfiguration unique;
    public Builder unique(UniqueUsernameConfiguration unique) { this.unique = unique; return this; }
    public TenantUsernameConfiguration build() { return new TenantUsernameConfiguration(unique); }
  }
}
