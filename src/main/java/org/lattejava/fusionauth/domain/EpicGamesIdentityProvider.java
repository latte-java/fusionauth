/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EpicGamesIdentityProviderJSON;

@JSON
@JSONSubtype("EpicGames")
public record EpicGamesIdentityProvider(
    String buttonText,
    String client_id,
    String client_secret,
    String scope,
    Map<String, Object> data,
    Map<String, EpicGamesApplicationConfiguration> applicationConfiguration,
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
    return EpicGamesIdentityProviderJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EpicGamesIdentityProviderJSON.toJSONBytes(this);
  }
  
  public static EpicGamesIdentityProvider fromJSON(String json) {
    return EpicGamesIdentityProviderJSON.fromJSON(json);
  }
  
  public static EpicGamesIdentityProvider fromJSONBytes(byte[] json) {
    return EpicGamesIdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    private String buttonText;
    private String client_id;
    private String client_secret;
    private String scope;
    private Map<String, Object> data;
    private Map<String, EpicGamesApplicationConfiguration> applicationConfiguration;
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
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder applicationConfiguration(Map<String, EpicGamesApplicationConfiguration> applicationConfiguration) { this.applicationConfiguration = applicationConfiguration; return this; }
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
    public EpicGamesIdentityProvider build() { return new EpicGamesIdentityProvider(buttonText, client_id, client_secret, scope, data, applicationConfiguration, attributeMappings, debug, id, insertInstant, lambdaConfiguration, lastUpdateInstant, linkingStrategy, name, source, tenantConfiguration, tenantId); }
  }
}
