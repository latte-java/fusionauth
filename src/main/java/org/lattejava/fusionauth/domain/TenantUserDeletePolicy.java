/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantUserDeletePolicyJSON;

@JSON
public record TenantUserDeletePolicy(
    TimeBasedDeletePolicy unverified) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantUserDeletePolicyJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantUserDeletePolicyJSON.toJSONBytes(this);
  }
  
  public static TenantUserDeletePolicy fromJSON(String json) {
    return TenantUserDeletePolicyJSON.fromJSON(json);
  }
  
  public static TenantUserDeletePolicy fromJSONBytes(byte[] json) {
    return TenantUserDeletePolicyJSON.fromJSON(json);
  }

  public static final class Builder {
    private TimeBasedDeletePolicy unverified;
    public Builder unverified(TimeBasedDeletePolicy unverified) { this.unverified = unverified; return this; }
    public TenantUserDeletePolicy build() { return new TenantUserDeletePolicy(unverified); }
  }
}
