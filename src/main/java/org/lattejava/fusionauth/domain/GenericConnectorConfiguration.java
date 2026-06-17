/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GenericConnectorConfigurationJSON;

@JSON
public record GenericConnectorConfiguration(
    String authenticationURL,
    Integer connectTimeout,
    HTTPHeaders headers,
    String httpAuthenticationPassword,
    String httpAuthenticationUsername,
    Integer readTimeout,
    UUID sslCertificateKeyId,
    Map<String, Object> data,
    Boolean debug,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    ConnectorType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GenericConnectorConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GenericConnectorConfigurationJSON.toJSONBytes(this);
  }
  
  public static GenericConnectorConfiguration fromJSON(String json) {
    return GenericConnectorConfigurationJSON.fromJSON(json);
  }
  
  public static GenericConnectorConfiguration fromJSONBytes(byte[] json) {
    return GenericConnectorConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String authenticationURL;
    private Integer connectTimeout;
    private HTTPHeaders headers;
    private String httpAuthenticationPassword;
    private String httpAuthenticationUsername;
    private Integer readTimeout;
    private UUID sslCertificateKeyId;
    private Map<String, Object> data;
    private Boolean debug;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    private ConnectorType type;
    public Builder authenticationURL(String authenticationURL) { this.authenticationURL = authenticationURL; return this; }
    public Builder connectTimeout(Integer connectTimeout) { this.connectTimeout = connectTimeout; return this; }
    public Builder headers(HTTPHeaders headers) { this.headers = headers; return this; }
    public Builder httpAuthenticationPassword(String httpAuthenticationPassword) { this.httpAuthenticationPassword = httpAuthenticationPassword; return this; }
    public Builder httpAuthenticationUsername(String httpAuthenticationUsername) { this.httpAuthenticationUsername = httpAuthenticationUsername; return this; }
    public Builder readTimeout(Integer readTimeout) { this.readTimeout = readTimeout; return this; }
    public Builder sslCertificateKeyId(UUID sslCertificateKeyId) { this.sslCertificateKeyId = sslCertificateKeyId; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(ConnectorType type) { this.type = type; return this; }
    public GenericConnectorConfiguration build() { return new GenericConnectorConfiguration(authenticationURL, connectTimeout, headers, httpAuthenticationPassword, httpAuthenticationUsername, readTimeout, sslCertificateKeyId, data, debug, id, insertInstant, lastUpdateInstant, name, type); }
  }
}
