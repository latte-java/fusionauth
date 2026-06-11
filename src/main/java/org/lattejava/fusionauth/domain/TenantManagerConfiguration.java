/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantManagerConfigurationJSON;

@JSON
public record TenantManagerConfiguration(
    List<TenantManagerApplicationConfiguration> applicationConfigurations,
    UUID attributeFormId,
    String brandName,
    Map<String, TenantManagerIdentityProviderTypeConfiguration> identityProviderTypeConfigurations,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantManagerConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantManagerConfigurationJSON.toJSONBytes(this);
  }

  public static TenantManagerConfiguration fromJSON(String json) {
    return TenantManagerConfigurationJSON.fromJSON(json);
  }

  public static TenantManagerConfiguration fromJSONBytes(byte[] json) {
    return TenantManagerConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<TenantManagerApplicationConfiguration> applicationConfigurations;
    private UUID attributeFormId;
    private String brandName;
    private Map<String, TenantManagerIdentityProviderTypeConfiguration> identityProviderTypeConfigurations;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    public Builder applicationConfigurations(List<TenantManagerApplicationConfiguration> applicationConfigurations) { this.applicationConfigurations = applicationConfigurations; return this; }
    public Builder attributeFormId(UUID attributeFormId) { this.attributeFormId = attributeFormId; return this; }
    public Builder brandName(String brandName) { this.brandName = brandName; return this; }
    public Builder identityProviderTypeConfigurations(Map<String, TenantManagerIdentityProviderTypeConfiguration> identityProviderTypeConfigurations) { this.identityProviderTypeConfigurations = identityProviderTypeConfigurations; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public TenantManagerConfiguration build() { return new TenantManagerConfiguration(applicationConfigurations, attributeFormId, brandName, identityProviderTypeConfigurations, insertInstant, lastUpdateInstant); }
  }
}
