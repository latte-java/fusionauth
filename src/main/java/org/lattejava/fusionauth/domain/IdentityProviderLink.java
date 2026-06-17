/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderLinkJSON;

@JSON
public record IdentityProviderLink(
    Map<String, Object> data,
    String displayName,
    UUID identityProviderId,
    String identityProviderName,
    IdentityProviderType identityProviderType,
    String identityProviderUserId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastLoginInstant,
    UUID tenantId,
    String token,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderLinkJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderLinkJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderLink fromJSON(String json) {
    return IdentityProviderLinkJSON.fromJSON(json);
  }
  
  public static IdentityProviderLink fromJSONBytes(byte[] json) {
    return IdentityProviderLinkJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private String displayName;
    private UUID identityProviderId;
    private String identityProviderName;
    private IdentityProviderType identityProviderType;
    private String identityProviderUserId;
    private Instant insertInstant;
    private Instant lastLoginInstant;
    private UUID tenantId;
    private String token;
    private UUID userId;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder displayName(String displayName) { this.displayName = displayName; return this; }
    public Builder identityProviderId(UUID identityProviderId) { this.identityProviderId = identityProviderId; return this; }
    public Builder identityProviderName(String identityProviderName) { this.identityProviderName = identityProviderName; return this; }
    public Builder identityProviderType(IdentityProviderType identityProviderType) { this.identityProviderType = identityProviderType; return this; }
    public Builder identityProviderUserId(String identityProviderUserId) { this.identityProviderUserId = identityProviderUserId; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastLoginInstant(Instant lastLoginInstant) { this.lastLoginInstant = lastLoginInstant; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public IdentityProviderLink build() { return new IdentityProviderLink(data, displayName, identityProviderId, identityProviderName, identityProviderType, identityProviderUserId, insertInstant, lastLoginInstant, tenantId, token, userId); }
  }
}
