/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookJSON;

@JSON
public record Webhook(
    Integer connectTimeout,
    Map<String, Object> data,
    String description,
    Map<String, Object> eventsEnabled,
    Boolean global,
    HTTPHeaders headers,
    String httpAuthenticationPassword,
    String httpAuthenticationUsername,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Integer readTimeout,
    WebhookSignatureConfiguration signatureConfiguration,
    String sslCertificate,
    UUID sslCertificateKeyId,
    List<UUID> tenantIds,
    String url) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebhookJSON.toJSONBytes(this);
  }
  
  public static Webhook fromJSON(String json) {
    return WebhookJSON.fromJSON(json);
  }
  
  public static Webhook fromJSONBytes(byte[] json) {
    return WebhookJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer connectTimeout;
    private Map<String, Object> data;
    private String description;
    private Map<String, Object> eventsEnabled;
    private Boolean global;
    private HTTPHeaders headers;
    private String httpAuthenticationPassword;
    private String httpAuthenticationUsername;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private Integer readTimeout;
    private WebhookSignatureConfiguration signatureConfiguration;
    private String sslCertificate;
    private UUID sslCertificateKeyId;
    private List<UUID> tenantIds;
    private String url;
    public Builder connectTimeout(Integer connectTimeout) { this.connectTimeout = connectTimeout; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder description(String description) { this.description = description; return this; }
    public Builder eventsEnabled(Map<String, Object> eventsEnabled) { this.eventsEnabled = eventsEnabled; return this; }
    public Builder global(Boolean global) { this.global = global; return this; }
    public Builder headers(HTTPHeaders headers) { this.headers = headers; return this; }
    public Builder httpAuthenticationPassword(String httpAuthenticationPassword) { this.httpAuthenticationPassword = httpAuthenticationPassword; return this; }
    public Builder httpAuthenticationUsername(String httpAuthenticationUsername) { this.httpAuthenticationUsername = httpAuthenticationUsername; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder readTimeout(Integer readTimeout) { this.readTimeout = readTimeout; return this; }
    public Builder signatureConfiguration(WebhookSignatureConfiguration signatureConfiguration) { this.signatureConfiguration = signatureConfiguration; return this; }
    public Builder sslCertificate(String sslCertificate) { this.sslCertificate = sslCertificate; return this; }
    public Builder sslCertificateKeyId(UUID sslCertificateKeyId) { this.sslCertificateKeyId = sslCertificateKeyId; return this; }
    public Builder tenantIds(List<UUID> tenantIds) { this.tenantIds = tenantIds; return this; }
    public Builder url(String url) { this.url = url; return this; }
    public Webhook build() { return new Webhook(connectTimeout, data, description, eventsEnabled, global, headers, httpAuthenticationPassword, httpAuthenticationUsername, id, insertInstant, lastUpdateInstant, readTimeout, signatureConfiguration, sslCertificate, sslCertificateKeyId, tenantIds, url); }
  }
}
