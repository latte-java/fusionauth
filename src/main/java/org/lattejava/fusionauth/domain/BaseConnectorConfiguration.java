/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseConnectorConfigurationJSON;

@JSON
public record BaseConnectorConfiguration(
    Map<String, Object> data,
    Boolean debug,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    ConnectorType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseConnectorConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return BaseConnectorConfigurationJSON.toJSONBytes(this);
  }

  public static BaseConnectorConfiguration fromJSON(String json) {
    return BaseConnectorConfigurationJSON.fromJSON(json);
  }

  public static BaseConnectorConfiguration fromJSONBytes(byte[] json) {
    return BaseConnectorConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Boolean debug;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    private ConnectorType type;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(ConnectorType type) { this.type = type; return this; }
    public BaseConnectorConfiguration build() { return new BaseConnectorConfiguration(data, debug, id, insertInstant, lastUpdateInstant, name, type); }
  }
}
