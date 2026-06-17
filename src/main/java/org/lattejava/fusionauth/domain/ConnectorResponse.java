/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConnectorResponseJSON;

@JSON
public record ConnectorResponse(
    BaseConnectorConfiguration connector,
    List<BaseConnectorConfiguration> connectors) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConnectorResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ConnectorResponseJSON.toJSONBytes(this);
  }
  
  public static ConnectorResponse fromJSON(String json) {
    return ConnectorResponseJSON.fromJSON(json);
  }
  
  public static ConnectorResponse fromJSONBytes(byte[] json) {
    return ConnectorResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private BaseConnectorConfiguration connector;
    private List<BaseConnectorConfiguration> connectors;
    public Builder connector(BaseConnectorConfiguration connector) { this.connector = connector; return this; }
    public Builder connectors(List<BaseConnectorConfiguration> connectors) { this.connectors = connectors; return this; }
    public ConnectorResponse build() { return new ConnectorResponse(connector, connectors); }
  }
}
