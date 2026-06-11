/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.CredentialPropertiesOutputJSON;

@JSON
public record CredentialPropertiesOutput(
    Boolean rk) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return CredentialPropertiesOutputJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return CredentialPropertiesOutputJSON.toJSONBytes(this);
  }

  public static CredentialPropertiesOutput fromJSON(String json) {
    return CredentialPropertiesOutputJSON.fromJSON(json);
  }

  public static CredentialPropertiesOutput fromJSONBytes(byte[] json) {
    return CredentialPropertiesOutputJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean rk;
    public Builder rk(Boolean rk) { this.rk = rk; return this; }
    public CredentialPropertiesOutput build() { return new CredentialPropertiesOutput(rk); }
  }
}
