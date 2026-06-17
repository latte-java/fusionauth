/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PoliciesJSON;

@JSON
public record Policies(
    MultiFactorLoginPolicy applicationLoginPolicy,
    ApplicationMultiFactorTrustPolicy applicationMultiFactorTrustPolicy,
    MultiFactorLoginPolicy tenantLoginPolicy) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PoliciesJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PoliciesJSON.toJSONBytes(this);
  }
  
  public static Policies fromJSON(String json) {
    return PoliciesJSON.fromJSON(json);
  }
  
  public static Policies fromJSONBytes(byte[] json) {
    return PoliciesJSON.fromJSON(json);
  }

  public static final class Builder {
    private MultiFactorLoginPolicy applicationLoginPolicy;
    private ApplicationMultiFactorTrustPolicy applicationMultiFactorTrustPolicy;
    private MultiFactorLoginPolicy tenantLoginPolicy;
    public Builder applicationLoginPolicy(MultiFactorLoginPolicy applicationLoginPolicy) { this.applicationLoginPolicy = applicationLoginPolicy; return this; }
    public Builder applicationMultiFactorTrustPolicy(ApplicationMultiFactorTrustPolicy applicationMultiFactorTrustPolicy) { this.applicationMultiFactorTrustPolicy = applicationMultiFactorTrustPolicy; return this; }
    public Builder tenantLoginPolicy(MultiFactorLoginPolicy tenantLoginPolicy) { this.tenantLoginPolicy = tenantLoginPolicy; return this; }
    public Policies build() { return new Policies(applicationLoginPolicy, applicationMultiFactorTrustPolicy, tenantLoginPolicy); }
  }
}
