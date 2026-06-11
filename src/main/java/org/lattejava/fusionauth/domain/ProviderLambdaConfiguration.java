/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ProviderLambdaConfigurationJSON;

@JSON
public record ProviderLambdaConfiguration(
    UUID reconcileId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ProviderLambdaConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ProviderLambdaConfigurationJSON.toJSONBytes(this);
  }

  public static ProviderLambdaConfiguration fromJSON(String json) {
    return ProviderLambdaConfigurationJSON.fromJSON(json);
  }

  public static ProviderLambdaConfiguration fromJSONBytes(byte[] json) {
    return ProviderLambdaConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID reconcileId;
    public Builder reconcileId(UUID reconcileId) { this.reconcileId = reconcileId; return this; }
    public ProviderLambdaConfiguration build() { return new ProviderLambdaConfiguration(reconcileId); }
  }
}
