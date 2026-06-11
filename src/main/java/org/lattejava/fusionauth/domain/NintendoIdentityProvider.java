/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.NintendoIdentityProviderJSON;

@JSON
@JSONSubtype("Nintendo")
public record NintendoIdentityProvider(
    String buttonText,
    String client_id,
    String client_secret,
    String emailClaim,
    String scope,
    String uniqueIdClaim,
    String usernameClaim,
    Map<String, Object> data,
    Map<String, NintendoApplicationConfiguration> applicationConfiguration,
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
    return NintendoIdentityProviderJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return NintendoIdentityProviderJSON.toJSONBytes(this);
  }

  public static NintendoIdentityProvider fromJSON(String json) {
    return NintendoIdentityProviderJSON.fromJSON(json);
  }

  public static NintendoIdentityProvider fromJSONBytes(byte[] json) {
    return NintendoIdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    private String buttonText;
    private String client_id;
    private String client_secret;
    private String emailClaim;
    private String scope;
    private String uniqueIdClaim;
    private String usernameClaim;
    private Map<String, Object> data;
    private Map<String, NintendoApplicationConfiguration> applicationConfiguration;
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
    public Builder emailClaim(String emailClaim) { this.emailClaim = emailClaim; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder uniqueIdClaim(String uniqueIdClaim) { this.uniqueIdClaim = uniqueIdClaim; return this; }
    public Builder usernameClaim(String usernameClaim) { this.usernameClaim = usernameClaim; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder applicationConfiguration(Map<String, NintendoApplicationConfiguration> applicationConfiguration) { this.applicationConfiguration = applicationConfiguration; return this; }
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
    public NintendoIdentityProvider build() { return new NintendoIdentityProvider(buttonText, client_id, client_secret, emailClaim, scope, uniqueIdClaim, usernameClaim, data, applicationConfiguration, attributeMappings, debug, id, insertInstant, lambdaConfiguration, lastUpdateInstant, linkingStrategy, name, source, tenantConfiguration, tenantId); }
  }
}
