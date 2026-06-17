/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationOAuthScopeJSON;

@JSON
public record ApplicationOAuthScope(
    UUID applicationId,
    Map<String, Object> data,
    String defaultConsentDetail,
    String defaultConsentMessage,
    String description,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    Boolean required) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationOAuthScopeJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationOAuthScopeJSON.toJSONBytes(this);
  }
  
  public static ApplicationOAuthScope fromJSON(String json) {
    return ApplicationOAuthScopeJSON.fromJSON(json);
  }
  
  public static ApplicationOAuthScope fromJSONBytes(byte[] json) {
    return ApplicationOAuthScopeJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private Map<String, Object> data;
    private String defaultConsentDetail;
    private String defaultConsentMessage;
    private String description;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    private Boolean required;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder defaultConsentDetail(String defaultConsentDetail) { this.defaultConsentDetail = defaultConsentDetail; return this; }
    public Builder defaultConsentMessage(String defaultConsentMessage) { this.defaultConsentMessage = defaultConsentMessage; return this; }
    public Builder description(String description) { this.description = description; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder required(Boolean required) { this.required = required; return this; }
    public ApplicationOAuthScope build() { return new ApplicationOAuthScope(applicationId, data, defaultConsentDetail, defaultConsentMessage, description, id, insertInstant, lastUpdateInstant, name, required); }
  }
}
