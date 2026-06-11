/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GenericMessengerConfigurationJSON;

@JSON
public record GenericMessengerConfiguration(
    Integer connectTimeout,
    HTTPHeaders headers,
    String httpAuthenticationPassword,
    String httpAuthenticationUsername,
    Integer readTimeout,
    String sslCertificate,
    String url,
    Map<String, Object> data,
    Boolean debug,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Set<String> messageTypes,
    String name,
    String transport,
    MessengerType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GenericMessengerConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return GenericMessengerConfigurationJSON.toJSONBytes(this);
  }

  public static GenericMessengerConfiguration fromJSON(String json) {
    return GenericMessengerConfigurationJSON.fromJSON(json);
  }

  public static GenericMessengerConfiguration fromJSONBytes(byte[] json) {
    return GenericMessengerConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer connectTimeout;
    private HTTPHeaders headers;
    private String httpAuthenticationPassword;
    private String httpAuthenticationUsername;
    private Integer readTimeout;
    private String sslCertificate;
    private String url;
    private Map<String, Object> data;
    private Boolean debug;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private Set<String> messageTypes;
    private String name;
    private String transport;
    private MessengerType type;
    public Builder connectTimeout(Integer connectTimeout) { this.connectTimeout = connectTimeout; return this; }
    public Builder headers(HTTPHeaders headers) { this.headers = headers; return this; }
    public Builder httpAuthenticationPassword(String httpAuthenticationPassword) { this.httpAuthenticationPassword = httpAuthenticationPassword; return this; }
    public Builder httpAuthenticationUsername(String httpAuthenticationUsername) { this.httpAuthenticationUsername = httpAuthenticationUsername; return this; }
    public Builder readTimeout(Integer readTimeout) { this.readTimeout = readTimeout; return this; }
    public Builder sslCertificate(String sslCertificate) { this.sslCertificate = sslCertificate; return this; }
    public Builder url(String url) { this.url = url; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder messageTypes(Set<String> messageTypes) { this.messageTypes = messageTypes; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder transport(String transport) { this.transport = transport; return this; }
    public Builder type(MessengerType type) { this.type = type; return this; }
    public GenericMessengerConfiguration build() { return new GenericMessengerConfiguration(connectTimeout, headers, httpAuthenticationPassword, httpAuthenticationUsername, readTimeout, sslCertificate, url, data, debug, id, insertInstant, lastUpdateInstant, messageTypes, name, transport, type); }
  }
}
