/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationFormConfigurationJSON;

@JSON
public record ApplicationFormConfiguration(
    UUID adminRegistrationFormId,
    SelfServiceFormConfiguration selfServiceFormConfiguration,
    UUID selfServiceFormId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationFormConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationFormConfigurationJSON.toJSONBytes(this);
  }
  
  public static ApplicationFormConfiguration fromJSON(String json) {
    return ApplicationFormConfigurationJSON.fromJSON(json);
  }
  
  public static ApplicationFormConfiguration fromJSONBytes(byte[] json) {
    return ApplicationFormConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID adminRegistrationFormId;
    private SelfServiceFormConfiguration selfServiceFormConfiguration;
    private UUID selfServiceFormId;
    public Builder adminRegistrationFormId(UUID adminRegistrationFormId) { this.adminRegistrationFormId = adminRegistrationFormId; return this; }
    public Builder selfServiceFormConfiguration(SelfServiceFormConfiguration selfServiceFormConfiguration) { this.selfServiceFormConfiguration = selfServiceFormConfiguration; return this; }
    public Builder selfServiceFormId(UUID selfServiceFormId) { this.selfServiceFormId = selfServiceFormId; return this; }
    public ApplicationFormConfiguration build() { return new ApplicationFormConfiguration(adminRegistrationFormId, selfServiceFormConfiguration, selfServiceFormId); }
  }
}
