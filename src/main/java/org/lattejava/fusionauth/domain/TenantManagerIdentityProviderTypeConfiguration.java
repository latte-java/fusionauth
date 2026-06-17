/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantManagerIdentityProviderTypeConfigurationJSON;

@JSON
public record TenantManagerIdentityProviderTypeConfiguration(
    Map<String, String> defaultAttributeMappings,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    IdentityProviderLinkingStrategy linkingStrategy,
    IdentityProviderType type,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantManagerIdentityProviderTypeConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantManagerIdentityProviderTypeConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantManagerIdentityProviderTypeConfiguration fromJSON(String json) {
    return TenantManagerIdentityProviderTypeConfigurationJSON.fromJSON(json);
  }
  
  public static TenantManagerIdentityProviderTypeConfiguration fromJSONBytes(byte[] json) {
    return TenantManagerIdentityProviderTypeConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, String> defaultAttributeMappings;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private IdentityProviderLinkingStrategy linkingStrategy;
    private IdentityProviderType type;
    private Boolean enabled;
    public Builder defaultAttributeMappings(Map<String, String> defaultAttributeMappings) { this.defaultAttributeMappings = defaultAttributeMappings; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder linkingStrategy(IdentityProviderLinkingStrategy linkingStrategy) { this.linkingStrategy = linkingStrategy; return this; }
    public Builder type(IdentityProviderType type) { this.type = type; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public TenantManagerIdentityProviderTypeConfiguration build() { return new TenantManagerIdentityProviderTypeConfiguration(defaultAttributeMappings, insertInstant, lastUpdateInstant, linkingStrategy, type, enabled); }
  }
}
