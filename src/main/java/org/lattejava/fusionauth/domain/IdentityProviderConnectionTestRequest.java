/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderConnectionTestRequestJSON;

@JSON
public record IdentityProviderConnectionTestRequest(
    UUID identityProviderId,
    UUID tenantId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderConnectionTestRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderConnectionTestRequestJSON.toJSONBytes(this);
  }

  public static IdentityProviderConnectionTestRequest fromJSON(String json) {
    return IdentityProviderConnectionTestRequestJSON.fromJSON(json);
  }

  public static IdentityProviderConnectionTestRequest fromJSONBytes(byte[] json) {
    return IdentityProviderConnectionTestRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID identityProviderId;
    private UUID tenantId;
    public Builder identityProviderId(UUID identityProviderId) { this.identityProviderId = identityProviderId; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public IdentityProviderConnectionTestRequest build() { return new IdentityProviderConnectionTestRequest(identityProviderId, tenantId); }
  }
}
