/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConnectorLambdaConfigurationJSON;

@JSON
public record ConnectorLambdaConfiguration(
    UUID reconcileId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConnectorLambdaConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ConnectorLambdaConfigurationJSON.toJSONBytes(this);
  }

  public static ConnectorLambdaConfiguration fromJSON(String json) {
    return ConnectorLambdaConfigurationJSON.fromJSON(json);
  }

  public static ConnectorLambdaConfiguration fromJSONBytes(byte[] json) {
    return ConnectorLambdaConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID reconcileId;
    public Builder reconcileId(UUID reconcileId) { this.reconcileId = reconcileId; return this; }
    public ConnectorLambdaConfiguration build() { return new ConnectorLambdaConfiguration(reconcileId); }
  }
}
