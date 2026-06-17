/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConnectorPolicyJSON;

@JSON
public record ConnectorPolicy(
    UUID connectorId,
    Map<String, Object> data,
    Set<String> domains,
    Boolean migrate) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConnectorPolicyJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ConnectorPolicyJSON.toJSONBytes(this);
  }
  
  public static ConnectorPolicy fromJSON(String json) {
    return ConnectorPolicyJSON.fromJSON(json);
  }
  
  public static ConnectorPolicy fromJSONBytes(byte[] json) {
    return ConnectorPolicyJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID connectorId;
    private Map<String, Object> data;
    private Set<String> domains;
    private Boolean migrate;
    public Builder connectorId(UUID connectorId) { this.connectorId = connectorId; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder domains(Set<String> domains) { this.domains = domains; return this; }
    public Builder migrate(Boolean migrate) { this.migrate = migrate; return this; }
    public ConnectorPolicy build() { return new ConnectorPolicy(connectorId, data, domains, migrate); }
  }
}
