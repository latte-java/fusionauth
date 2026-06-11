/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserConsentJSON;

@JSON
public record UserConsent(
    Map<String, Object> data,
    Consent consent,
    UUID consentId,
    UUID giverUserId,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    ConsentStatus status,
    UUID userId,
    List<String> values) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserConsentJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserConsentJSON.toJSONBytes(this);
  }

  public static UserConsent fromJSON(String json) {
    return UserConsentJSON.fromJSON(json);
  }

  public static UserConsent fromJSONBytes(byte[] json) {
    return UserConsentJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Consent consent;
    private UUID consentId;
    private UUID giverUserId;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private ConsentStatus status;
    private UUID userId;
    private List<String> values;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder consent(Consent consent) { this.consent = consent; return this; }
    public Builder consentId(UUID consentId) { this.consentId = consentId; return this; }
    public Builder giverUserId(UUID giverUserId) { this.giverUserId = giverUserId; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder status(ConsentStatus status) { this.status = status; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder values(List<String> values) { this.values = values; return this; }
    public UserConsent build() { return new UserConsent(data, consent, consentId, giverUserId, id, insertInstant, lastUpdateInstant, status, userId, values); }
  }
}
