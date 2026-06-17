/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConsentJSON;

@JSON
public record Consent(
    Map<String, Object> data,
    UUID consentEmailTemplateId,
    LocalizedIntegers countryMinimumAgeForSelfConsent,
    Integer defaultMinimumAgeForSelfConsent,
    EmailPlus emailPlus,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Boolean multipleValuesAllowed,
    String name,
    List<String> values) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConsentJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ConsentJSON.toJSONBytes(this);
  }
  
  public static Consent fromJSON(String json) {
    return ConsentJSON.fromJSON(json);
  }
  
  public static Consent fromJSONBytes(byte[] json) {
    return ConsentJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private UUID consentEmailTemplateId;
    private LocalizedIntegers countryMinimumAgeForSelfConsent;
    private Integer defaultMinimumAgeForSelfConsent;
    private EmailPlus emailPlus;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private Boolean multipleValuesAllowed;
    private String name;
    private List<String> values;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder consentEmailTemplateId(UUID consentEmailTemplateId) { this.consentEmailTemplateId = consentEmailTemplateId; return this; }
    public Builder countryMinimumAgeForSelfConsent(LocalizedIntegers countryMinimumAgeForSelfConsent) { this.countryMinimumAgeForSelfConsent = countryMinimumAgeForSelfConsent; return this; }
    public Builder defaultMinimumAgeForSelfConsent(Integer defaultMinimumAgeForSelfConsent) { this.defaultMinimumAgeForSelfConsent = defaultMinimumAgeForSelfConsent; return this; }
    public Builder emailPlus(EmailPlus emailPlus) { this.emailPlus = emailPlus; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder multipleValuesAllowed(Boolean multipleValuesAllowed) { this.multipleValuesAllowed = multipleValuesAllowed; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder values(List<String> values) { this.values = values; return this; }
    public Consent build() { return new Consent(data, consentEmailTemplateId, countryMinimumAgeForSelfConsent, defaultMinimumAgeForSelfConsent, emailPlus, id, insertInstant, lastUpdateInstant, multipleValuesAllowed, name, values); }
  }
}
