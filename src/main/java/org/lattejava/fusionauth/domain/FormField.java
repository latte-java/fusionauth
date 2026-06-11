/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FormFieldJSON;

@JSON
public record FormField(
    Boolean confirm,
    UUID consentId,
    FormControl control,
    Map<String, Object> data,
    String description,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    String key,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    List<String> options,
    Boolean required,
    FormDataType type,
    FormFieldValidator validator) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FormFieldJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FormFieldJSON.toJSONBytes(this);
  }

  public static FormField fromJSON(String json) {
    return FormFieldJSON.fromJSON(json);
  }

  public static FormField fromJSONBytes(byte[] json) {
    return FormFieldJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean confirm;
    private UUID consentId;
    private FormControl control;
    private Map<String, Object> data;
    private String description;
    private UUID id;
    private Instant insertInstant;
    private String key;
    private Instant lastUpdateInstant;
    private String name;
    private List<String> options;
    private Boolean required;
    private FormDataType type;
    private FormFieldValidator validator;
    public Builder confirm(Boolean confirm) { this.confirm = confirm; return this; }
    public Builder consentId(UUID consentId) { this.consentId = consentId; return this; }
    public Builder control(FormControl control) { this.control = control; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder description(String description) { this.description = description; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder key(String key) { this.key = key; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder options(List<String> options) { this.options = options; return this; }
    public Builder required(Boolean required) { this.required = required; return this; }
    public Builder type(FormDataType type) { this.type = type; return this; }
    public Builder validator(FormFieldValidator validator) { this.validator = validator; return this; }
    public FormField build() { return new FormField(confirm, consentId, control, data, description, id, insertInstant, key, lastUpdateInstant, name, options, required, type, validator); }
  }
}
