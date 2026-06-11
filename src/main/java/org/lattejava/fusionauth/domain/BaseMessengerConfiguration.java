/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseMessengerConfigurationJSON;

@JSON
public record BaseMessengerConfiguration(
    Map<String, Object> data,
    Boolean debug,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Set<String> messageTypes,
    String name,
    String transport,
    MessengerType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseMessengerConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return BaseMessengerConfigurationJSON.toJSONBytes(this);
  }

  public static BaseMessengerConfiguration fromJSON(String json) {
    return BaseMessengerConfigurationJSON.fromJSON(json);
  }

  public static BaseMessengerConfiguration fromJSONBytes(byte[] json) {
    return BaseMessengerConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Boolean debug;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private Set<String> messageTypes;
    private String name;
    private String transport;
    private MessengerType type;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder messageTypes(Set<String> messageTypes) { this.messageTypes = messageTypes; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder transport(String transport) { this.transport = transport; return this; }
    public Builder type(MessengerType type) { this.type = type; return this; }
    public BaseMessengerConfiguration build() { return new BaseMessengerConfiguration(data, debug, id, insertInstant, lastUpdateInstant, messageTypes, name, transport, type); }
  }
}
