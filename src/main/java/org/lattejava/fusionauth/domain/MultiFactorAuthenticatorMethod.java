/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MultiFactorAuthenticatorMethodJSON;

@JSON
public record MultiFactorAuthenticatorMethod(
    TOTPAlgorithm algorithm,
    Integer codeLength,
    Integer timeStep,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MultiFactorAuthenticatorMethodJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MultiFactorAuthenticatorMethodJSON.toJSONBytes(this);
  }
  
  public static MultiFactorAuthenticatorMethod fromJSON(String json) {
    return MultiFactorAuthenticatorMethodJSON.fromJSON(json);
  }
  
  public static MultiFactorAuthenticatorMethod fromJSONBytes(byte[] json) {
    return MultiFactorAuthenticatorMethodJSON.fromJSON(json);
  }

  public static final class Builder {
    private TOTPAlgorithm algorithm;
    private Integer codeLength;
    private Integer timeStep;
    private Boolean enabled;
    public Builder algorithm(TOTPAlgorithm algorithm) { this.algorithm = algorithm; return this; }
    public Builder codeLength(Integer codeLength) { this.codeLength = codeLength; return this; }
    public Builder timeStep(Integer timeStep) { this.timeStep = timeStep; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public MultiFactorAuthenticatorMethod build() { return new MultiFactorAuthenticatorMethod(algorithm, codeLength, timeStep, enabled); }
  }
}
