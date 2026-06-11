/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantableJSON;

@JSON
public record Tenantable() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantableJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantableJSON.toJSONBytes(this);
  }

  public static Tenantable fromJSON(String json) {
    return TenantableJSON.fromJSON(json);
  }

  public static Tenantable fromJSONBytes(byte[] json) {
    return TenantableJSON.fromJSON(json);
  }

  public static final class Builder {
    public Tenantable build() { return new Tenantable(); }
  }
}
