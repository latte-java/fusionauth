/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuthenticatorConfigurationJSON;

@JSON
public record AuthenticatorConfiguration(
    TOTPAlgorithm algorithm,
    Integer codeLength,
    Integer timeStep) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuthenticatorConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AuthenticatorConfigurationJSON.toJSONBytes(this);
  }

  public static AuthenticatorConfiguration fromJSON(String json) {
    return AuthenticatorConfigurationJSON.fromJSON(json);
  }

  public static AuthenticatorConfiguration fromJSONBytes(byte[] json) {
    return AuthenticatorConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private TOTPAlgorithm algorithm;
    private Integer codeLength;
    private Integer timeStep;
    public Builder algorithm(TOTPAlgorithm algorithm) { this.algorithm = algorithm; return this; }
    public Builder codeLength(Integer codeLength) { this.codeLength = codeLength; return this; }
    public Builder timeStep(Integer timeStep) { this.timeStep = timeStep; return this; }
    public AuthenticatorConfiguration build() { return new AuthenticatorConfiguration(algorithm, codeLength, timeStep); }
  }
}
