/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LambdaConfigurationJSON;

@JSON
public record LambdaConfiguration(
    UUID accessTokenPopulateId,
    UUID idTokenPopulateId,
    UUID multiFactorRequirementId,
    UUID samlv2PopulateId,
    UUID selfServiceRegistrationValidationId,
    UUID userinfoPopulateId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LambdaConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LambdaConfigurationJSON.toJSONBytes(this);
  }

  public static LambdaConfiguration fromJSON(String json) {
    return LambdaConfigurationJSON.fromJSON(json);
  }

  public static LambdaConfiguration fromJSONBytes(byte[] json) {
    return LambdaConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID accessTokenPopulateId;
    private UUID idTokenPopulateId;
    private UUID multiFactorRequirementId;
    private UUID samlv2PopulateId;
    private UUID selfServiceRegistrationValidationId;
    private UUID userinfoPopulateId;
    public Builder accessTokenPopulateId(UUID accessTokenPopulateId) { this.accessTokenPopulateId = accessTokenPopulateId; return this; }
    public Builder idTokenPopulateId(UUID idTokenPopulateId) { this.idTokenPopulateId = idTokenPopulateId; return this; }
    public Builder multiFactorRequirementId(UUID multiFactorRequirementId) { this.multiFactorRequirementId = multiFactorRequirementId; return this; }
    public Builder samlv2PopulateId(UUID samlv2PopulateId) { this.samlv2PopulateId = samlv2PopulateId; return this; }
    public Builder selfServiceRegistrationValidationId(UUID selfServiceRegistrationValidationId) { this.selfServiceRegistrationValidationId = selfServiceRegistrationValidationId; return this; }
    public Builder userinfoPopulateId(UUID userinfoPopulateId) { this.userinfoPopulateId = userinfoPopulateId; return this; }
    public LambdaConfiguration build() { return new LambdaConfiguration(accessTokenPopulateId, idTokenPopulateId, multiFactorRequirementId, samlv2PopulateId, selfServiceRegistrationValidationId, userinfoPopulateId); }
  }
}
