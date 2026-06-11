/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OpenIdConnectIdentityProviderJSON;

@JSON
@JSONSubtype("OpenIdConnect")
public record OpenIdConnectIdentityProvider(
    Set<String> domains,
    String buttonImageURL,
    String buttonText,
    IdentityProviderOauth2Configuration oauth2,
    Boolean postRequest,
    Map<String, Object> data,
    Map<String, OpenIdConnectApplicationConfiguration> applicationConfiguration,
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
    return OpenIdConnectIdentityProviderJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return OpenIdConnectIdentityProviderJSON.toJSONBytes(this);
  }

  public static OpenIdConnectIdentityProvider fromJSON(String json) {
    return OpenIdConnectIdentityProviderJSON.fromJSON(json);
  }

  public static OpenIdConnectIdentityProvider fromJSONBytes(byte[] json) {
    return OpenIdConnectIdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    private Set<String> domains;
    private String buttonImageURL;
    private String buttonText;
    private IdentityProviderOauth2Configuration oauth2;
    private Boolean postRequest;
    private Map<String, Object> data;
    private Map<String, OpenIdConnectApplicationConfiguration> applicationConfiguration;
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
    public Builder domains(Set<String> domains) { this.domains = domains; return this; }
    public Builder buttonImageURL(String buttonImageURL) { this.buttonImageURL = buttonImageURL; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder oauth2(IdentityProviderOauth2Configuration oauth2) { this.oauth2 = oauth2; return this; }
    public Builder postRequest(Boolean postRequest) { this.postRequest = postRequest; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder applicationConfiguration(Map<String, OpenIdConnectApplicationConfiguration> applicationConfiguration) { this.applicationConfiguration = applicationConfiguration; return this; }
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
    public OpenIdConnectIdentityProvider build() { return new OpenIdConnectIdentityProvider(domains, buttonImageURL, buttonText, oauth2, postRequest, data, applicationConfiguration, attributeMappings, debug, id, insertInstant, lambdaConfiguration, lastUpdateInstant, linkingStrategy, name, source, tenantConfiguration, tenantId); }
  }
}
