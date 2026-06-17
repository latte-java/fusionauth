/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FacebookIdentityProviderJSON;

@JSON
@JSONSubtype("Facebook")
public record FacebookIdentityProvider(
    String appId,
    String buttonText,
    String client_secret,
    String fields,
    IdentityProviderLoginMethod loginMethod,
    String permissions,
    Map<String, Object> data,
    Map<String, FacebookApplicationConfiguration> applicationConfiguration,
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
    return FacebookIdentityProviderJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FacebookIdentityProviderJSON.toJSONBytes(this);
  }
  
  public static FacebookIdentityProvider fromJSON(String json) {
    return FacebookIdentityProviderJSON.fromJSON(json);
  }
  
  public static FacebookIdentityProvider fromJSONBytes(byte[] json) {
    return FacebookIdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    private String appId;
    private String buttonText;
    private String client_secret;
    private String fields;
    private IdentityProviderLoginMethod loginMethod;
    private String permissions;
    private Map<String, Object> data;
    private Map<String, FacebookApplicationConfiguration> applicationConfiguration;
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
    public Builder appId(String appId) { this.appId = appId; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder fields(String fields) { this.fields = fields; return this; }
    public Builder loginMethod(IdentityProviderLoginMethod loginMethod) { this.loginMethod = loginMethod; return this; }
    public Builder permissions(String permissions) { this.permissions = permissions; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder applicationConfiguration(Map<String, FacebookApplicationConfiguration> applicationConfiguration) { this.applicationConfiguration = applicationConfiguration; return this; }
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
    public FacebookIdentityProvider build() { return new FacebookIdentityProvider(appId, buttonText, client_secret, fields, loginMethod, permissions, data, applicationConfiguration, attributeMappings, debug, id, insertInstant, lambdaConfiguration, lastUpdateInstant, linkingStrategy, name, source, tenantConfiguration, tenantId); }
  }
}
