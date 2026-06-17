/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConnectorRequestJSON;

@JSON
public record ConnectorRequest(
    BaseConnectorConfiguration connector) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConnectorRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ConnectorRequestJSON.toJSONBytes(this);
  }
  
  public static ConnectorRequest fromJSON(String json) {
    return ConnectorRequestJSON.fromJSON(json);
  }
  
  public static ConnectorRequest fromJSONBytes(byte[] json) {
    return ConnectorRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private BaseConnectorConfiguration connector;
    public Builder connector(BaseConnectorConfiguration connector) { this.connector = connector; return this; }
    public ConnectorRequest build() { return new ConnectorRequest(connector); }
  }
}
