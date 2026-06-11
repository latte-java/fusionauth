/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderPendingLinkResponseJSON;

@JSON
public record IdentityProviderPendingLinkResponse(
    IdentityProviderTenantConfiguration identityProviderTenantConfiguration,
    Integer linkCount,
    PendingIdPLink pendingIdPLink) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderPendingLinkResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderPendingLinkResponseJSON.toJSONBytes(this);
  }

  public static IdentityProviderPendingLinkResponse fromJSON(String json) {
    return IdentityProviderPendingLinkResponseJSON.fromJSON(json);
  }

  public static IdentityProviderPendingLinkResponse fromJSONBytes(byte[] json) {
    return IdentityProviderPendingLinkResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private IdentityProviderTenantConfiguration identityProviderTenantConfiguration;
    private Integer linkCount;
    private PendingIdPLink pendingIdPLink;
    public Builder identityProviderTenantConfiguration(IdentityProviderTenantConfiguration identityProviderTenantConfiguration) { this.identityProviderTenantConfiguration = identityProviderTenantConfiguration; return this; }
    public Builder linkCount(Integer linkCount) { this.linkCount = linkCount; return this; }
    public Builder pendingIdPLink(PendingIdPLink pendingIdPLink) { this.pendingIdPLink = pendingIdPLink; return this; }
    public IdentityProviderPendingLinkResponse build() { return new IdentityProviderPendingLinkResponse(identityProviderTenantConfiguration, linkCount, pendingIdPLink); }
  }
}
