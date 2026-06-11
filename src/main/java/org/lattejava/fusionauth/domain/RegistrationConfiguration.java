/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RegistrationConfigurationJSON;

@JSON
public record RegistrationConfiguration(
    Requirable birthDate,
    Boolean completeRegistration,
    Boolean confirmPassword,
    Requirable firstName,
    UUID formId,
    Requirable fullName,
    Requirable lastName,
    LoginIdType loginIdType,
    Requirable middleName,
    Requirable mobilePhone,
    Requirable preferredLanguages,
    RegistrationType type,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RegistrationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RegistrationConfigurationJSON.toJSONBytes(this);
  }

  public static RegistrationConfiguration fromJSON(String json) {
    return RegistrationConfigurationJSON.fromJSON(json);
  }

  public static RegistrationConfiguration fromJSONBytes(byte[] json) {
    return RegistrationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Requirable birthDate;
    private Boolean completeRegistration;
    private Boolean confirmPassword;
    private Requirable firstName;
    private UUID formId;
    private Requirable fullName;
    private Requirable lastName;
    private LoginIdType loginIdType;
    private Requirable middleName;
    private Requirable mobilePhone;
    private Requirable preferredLanguages;
    private RegistrationType type;
    private Boolean enabled;
    public Builder birthDate(Requirable birthDate) { this.birthDate = birthDate; return this; }
    public Builder completeRegistration(Boolean completeRegistration) { this.completeRegistration = completeRegistration; return this; }
    public Builder confirmPassword(Boolean confirmPassword) { this.confirmPassword = confirmPassword; return this; }
    public Builder firstName(Requirable firstName) { this.firstName = firstName; return this; }
    public Builder formId(UUID formId) { this.formId = formId; return this; }
    public Builder fullName(Requirable fullName) { this.fullName = fullName; return this; }
    public Builder lastName(Requirable lastName) { this.lastName = lastName; return this; }
    public Builder loginIdType(LoginIdType loginIdType) { this.loginIdType = loginIdType; return this; }
    public Builder middleName(Requirable middleName) { this.middleName = middleName; return this; }
    public Builder mobilePhone(Requirable mobilePhone) { this.mobilePhone = mobilePhone; return this; }
    public Builder preferredLanguages(Requirable preferredLanguages) { this.preferredLanguages = preferredLanguages; return this; }
    public Builder type(RegistrationType type) { this.type = type; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public RegistrationConfiguration build() { return new RegistrationConfiguration(birthDate, completeRegistration, confirmPassword, firstName, formId, fullName, lastName, loginIdType, middleName, mobilePhone, preferredLanguages, type, enabled); }
  }
}
