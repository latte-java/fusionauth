/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LDAPConnectorConfigurationJSON;

@JSON
public record LDAPConnectorConfiguration(
    String authenticationURL,
    String baseStructure,
    Integer connectTimeout,
    String identifyingAttribute,
    ConnectorLambdaConfiguration lambdaConfiguration,
    String loginIdAttribute,
    Integer readTimeout,
    List<String> requestedAttributes,
    LDAPSecurityMethod securityMethod,
    String systemAccountDN,
    String systemAccountPassword,
    Map<String, Object> data,
    Boolean debug,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    ConnectorType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LDAPConnectorConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LDAPConnectorConfigurationJSON.toJSONBytes(this);
  }

  public static LDAPConnectorConfiguration fromJSON(String json) {
    return LDAPConnectorConfigurationJSON.fromJSON(json);
  }

  public static LDAPConnectorConfiguration fromJSONBytes(byte[] json) {
    return LDAPConnectorConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String authenticationURL;
    private String baseStructure;
    private Integer connectTimeout;
    private String identifyingAttribute;
    private ConnectorLambdaConfiguration lambdaConfiguration;
    private String loginIdAttribute;
    private Integer readTimeout;
    private List<String> requestedAttributes;
    private LDAPSecurityMethod securityMethod;
    private String systemAccountDN;
    private String systemAccountPassword;
    private Map<String, Object> data;
    private Boolean debug;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    private ConnectorType type;
    public Builder authenticationURL(String authenticationURL) { this.authenticationURL = authenticationURL; return this; }
    public Builder baseStructure(String baseStructure) { this.baseStructure = baseStructure; return this; }
    public Builder connectTimeout(Integer connectTimeout) { this.connectTimeout = connectTimeout; return this; }
    public Builder identifyingAttribute(String identifyingAttribute) { this.identifyingAttribute = identifyingAttribute; return this; }
    public Builder lambdaConfiguration(ConnectorLambdaConfiguration lambdaConfiguration) { this.lambdaConfiguration = lambdaConfiguration; return this; }
    public Builder loginIdAttribute(String loginIdAttribute) { this.loginIdAttribute = loginIdAttribute; return this; }
    public Builder readTimeout(Integer readTimeout) { this.readTimeout = readTimeout; return this; }
    public Builder requestedAttributes(List<String> requestedAttributes) { this.requestedAttributes = requestedAttributes; return this; }
    public Builder securityMethod(LDAPSecurityMethod securityMethod) { this.securityMethod = securityMethod; return this; }
    public Builder systemAccountDN(String systemAccountDN) { this.systemAccountDN = systemAccountDN; return this; }
    public Builder systemAccountPassword(String systemAccountPassword) { this.systemAccountPassword = systemAccountPassword; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(ConnectorType type) { this.type = type; return this; }
    public LDAPConnectorConfiguration build() { return new LDAPConnectorConfiguration(authenticationURL, baseStructure, connectTimeout, identifyingAttribute, lambdaConfiguration, loginIdAttribute, readTimeout, requestedAttributes, securityMethod, systemAccountDN, systemAccountPassword, data, debug, id, insertInstant, lastUpdateInstant, name, type); }
  }
}
