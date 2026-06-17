/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantLambdaConfigurationJSON;

@JSON
public record TenantLambdaConfiguration(
    UUID loginValidationId,
    UUID multiFactorRequirementId,
    UUID scimEnterpriseUserRequestConverterId,
    UUID scimEnterpriseUserResponseConverterId,
    UUID scimGroupRequestConverterId,
    UUID scimGroupResponseConverterId,
    UUID scimUserRequestConverterId,
    UUID scimUserResponseConverterId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantLambdaConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantLambdaConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantLambdaConfiguration fromJSON(String json) {
    return TenantLambdaConfigurationJSON.fromJSON(json);
  }
  
  public static TenantLambdaConfiguration fromJSONBytes(byte[] json) {
    return TenantLambdaConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID loginValidationId;
    private UUID multiFactorRequirementId;
    private UUID scimEnterpriseUserRequestConverterId;
    private UUID scimEnterpriseUserResponseConverterId;
    private UUID scimGroupRequestConverterId;
    private UUID scimGroupResponseConverterId;
    private UUID scimUserRequestConverterId;
    private UUID scimUserResponseConverterId;
    public Builder loginValidationId(UUID loginValidationId) { this.loginValidationId = loginValidationId; return this; }
    public Builder multiFactorRequirementId(UUID multiFactorRequirementId) { this.multiFactorRequirementId = multiFactorRequirementId; return this; }
    public Builder scimEnterpriseUserRequestConverterId(UUID scimEnterpriseUserRequestConverterId) { this.scimEnterpriseUserRequestConverterId = scimEnterpriseUserRequestConverterId; return this; }
    public Builder scimEnterpriseUserResponseConverterId(UUID scimEnterpriseUserResponseConverterId) { this.scimEnterpriseUserResponseConverterId = scimEnterpriseUserResponseConverterId; return this; }
    public Builder scimGroupRequestConverterId(UUID scimGroupRequestConverterId) { this.scimGroupRequestConverterId = scimGroupRequestConverterId; return this; }
    public Builder scimGroupResponseConverterId(UUID scimGroupResponseConverterId) { this.scimGroupResponseConverterId = scimGroupResponseConverterId; return this; }
    public Builder scimUserRequestConverterId(UUID scimUserRequestConverterId) { this.scimUserRequestConverterId = scimUserRequestConverterId; return this; }
    public Builder scimUserResponseConverterId(UUID scimUserResponseConverterId) { this.scimUserResponseConverterId = scimUserResponseConverterId; return this; }
    public TenantLambdaConfiguration build() { return new TenantLambdaConfiguration(loginValidationId, multiFactorRequirementId, scimEnterpriseUserRequestConverterId, scimEnterpriseUserResponseConverterId, scimGroupRequestConverterId, scimGroupResponseConverterId, scimUserRequestConverterId, scimUserResponseConverterId); }
  }
}
