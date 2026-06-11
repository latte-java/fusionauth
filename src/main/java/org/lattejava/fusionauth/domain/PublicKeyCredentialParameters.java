/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PublicKeyCredentialParametersJSON;

@JSON
public record PublicKeyCredentialParameters(
    CoseAlgorithmIdentifier alg,
    PublicKeyCredentialType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PublicKeyCredentialParametersJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PublicKeyCredentialParametersJSON.toJSONBytes(this);
  }

  public static PublicKeyCredentialParameters fromJSON(String json) {
    return PublicKeyCredentialParametersJSON.fromJSON(json);
  }

  public static PublicKeyCredentialParameters fromJSONBytes(byte[] json) {
    return PublicKeyCredentialParametersJSON.fromJSON(json);
  }

  public static final class Builder {
    private CoseAlgorithmIdentifier alg;
    private PublicKeyCredentialType type;
    public Builder alg(CoseAlgorithmIdentifier alg) { this.alg = alg; return this; }
    public Builder type(PublicKeyCredentialType type) { this.type = type; return this; }
    public PublicKeyCredentialParameters build() { return new PublicKeyCredentialParameters(alg, type); }
  }
}
