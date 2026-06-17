/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AppleIdentityProviderJSON;

@JSON
@JSONSubtype("Apple")
public record AppleIdentityProvider(
    String bundleId,
    String buttonText,
    UUID keyId,
    String scope,
    String servicesId,
    String teamId,
    Map<String, Object> data,
    Map<String, AppleApplicationConfiguration> applicationConfiguration,
    Map<String, String> attributeMappings,
    Boolean debug,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    ProviderLambdaConfiguration lambdaConfiguration,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    IdentityProviderLinkingStrategy linkingStrategy,
    String name,
    String source,
    Map<String, IdentityProviderTenantConfiguration> tenantConfiguration,
    UUID tenantId) implements IdentityProviderField {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AppleIdentityProviderJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return AppleIdentityProviderJSON.toJSONBytes(this);
  }
  
  public static AppleIdentityProvider fromJSON(String json) {
    return AppleIdentityProviderJSON.fromJSON(json);
  }
  
  public static AppleIdentityProvider fromJSONBytes(byte[] json) {
    return AppleIdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    private String bundleId;
    private String buttonText;
    private UUID keyId;
    private String scope;
    private String servicesId;
    private String teamId;
    private Map<String, Object> data;
    private Map<String, AppleApplicationConfiguration> applicationConfiguration;
    private Map<String, String> attributeMappings;
    private Boolean debug;
    private UUID id;
    private Instant insertInstant;
    private ProviderLambdaConfiguration lambdaConfiguration;
    private Instant lastUpdateInstant;
    private IdentityProviderLinkingStrategy linkingStrategy;
    private String name;
    private String source;
    private Map<String, IdentityProviderTenantConfiguration> tenantConfiguration;
    private UUID tenantId;
    public Builder bundleId(String bundleId) { this.bundleId = bundleId; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder keyId(UUID keyId) { this.keyId = keyId; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder servicesId(String servicesId) { this.servicesId = servicesId; return this; }
    public Builder teamId(String teamId) { this.teamId = teamId; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder applicationConfiguration(Map<String, AppleApplicationConfiguration> applicationConfiguration) { this.applicationConfiguration = applicationConfiguration; return this; }
    public Builder attributeMappings(Map<String, String> attributeMappings) { this.attributeMappings = attributeMappings; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lambdaConfiguration(ProviderLambdaConfiguration lambdaConfiguration) { this.lambdaConfiguration = lambdaConfiguration; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder linkingStrategy(IdentityProviderLinkingStrategy linkingStrategy) { this.linkingStrategy = linkingStrategy; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder source(String source) { this.source = source; return this; }
    public Builder tenantConfiguration(Map<String, IdentityProviderTenantConfiguration> tenantConfiguration) { this.tenantConfiguration = tenantConfiguration; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public AppleIdentityProvider build() { return new AppleIdentityProvider(bundleId, buttonText, keyId, scope, servicesId, teamId, data, applicationConfiguration, attributeMappings, debug, id, insertInstant, lambdaConfiguration, lastUpdateInstant, linkingStrategy, name, source, tenantConfiguration, tenantId); }
  }
}
