/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FusionAuthConnectorConfigurationJSON;

@JSON
public record FusionAuthConnectorConfiguration(
    Map<String, Object> data,
    Boolean debug,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    ConnectorType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FusionAuthConnectorConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FusionAuthConnectorConfigurationJSON.toJSONBytes(this);
  }
  
  public static FusionAuthConnectorConfiguration fromJSON(String json) {
    return FusionAuthConnectorConfigurationJSON.fromJSON(json);
  }
  
  public static FusionAuthConnectorConfiguration fromJSONBytes(byte[] json) {
    return FusionAuthConnectorConfigurationJSON.fromJSON(json);
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
    public FusionAuthConnectorConfiguration build() { return new FusionAuthConnectorConfiguration(data, debug, id, insertInstant, lastUpdateInstant, name, type); }
  }
}
