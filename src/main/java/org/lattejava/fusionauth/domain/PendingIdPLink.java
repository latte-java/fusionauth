/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PendingIdPLinkJSON;

@JSON
public record PendingIdPLink(
    String displayName,
    String email,
    UUID identityProviderId,
    List<IdentityProviderLink> identityProviderLinks,
    String identityProviderName,
    IdentityProviderTenantConfiguration identityProviderTenantConfiguration,
    IdentityProviderType identityProviderType,
    String identityProviderUserId,
    User user,
    String username) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PendingIdPLinkJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PendingIdPLinkJSON.toJSONBytes(this);
  }

  public static PendingIdPLink fromJSON(String json) {
    return PendingIdPLinkJSON.fromJSON(json);
  }

  public static PendingIdPLink fromJSONBytes(byte[] json) {
    return PendingIdPLinkJSON.fromJSON(json);
  }

  public static final class Builder {
    private String displayName;
    private String email;
    private UUID identityProviderId;
    private List<IdentityProviderLink> identityProviderLinks;
    private String identityProviderName;
    private IdentityProviderTenantConfiguration identityProviderTenantConfiguration;
    private IdentityProviderType identityProviderType;
    private String identityProviderUserId;
    private User user;
    private String username;
    public Builder displayName(String displayName) { this.displayName = displayName; return this; }
    public Builder email(String email) { this.email = email; return this; }
    public Builder identityProviderId(UUID identityProviderId) { this.identityProviderId = identityProviderId; return this; }
    public Builder identityProviderLinks(List<IdentityProviderLink> identityProviderLinks) { this.identityProviderLinks = identityProviderLinks; return this; }
    public Builder identityProviderName(String identityProviderName) { this.identityProviderName = identityProviderName; return this; }
    public Builder identityProviderTenantConfiguration(IdentityProviderTenantConfiguration identityProviderTenantConfiguration) { this.identityProviderTenantConfiguration = identityProviderTenantConfiguration; return this; }
    public Builder identityProviderType(IdentityProviderType identityProviderType) { this.identityProviderType = identityProviderType; return this; }
    public Builder identityProviderUserId(String identityProviderUserId) { this.identityProviderUserId = identityProviderUserId; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public Builder username(String username) { this.username = username; return this; }
    public PendingIdPLink build() { return new PendingIdPLink(displayName, email, identityProviderId, identityProviderLinks, identityProviderName, identityProviderTenantConfiguration, identityProviderType, identityProviderUserId, user, username); }
  }
}
