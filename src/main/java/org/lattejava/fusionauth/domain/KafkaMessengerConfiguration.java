/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KafkaMessengerConfigurationJSON;

@JSON
public record KafkaMessengerConfiguration(
    String defaultTopic,
    Map<String, String> producer,
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
    return KafkaMessengerConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return KafkaMessengerConfigurationJSON.toJSONBytes(this);
  }
  
  public static KafkaMessengerConfiguration fromJSON(String json) {
    return KafkaMessengerConfigurationJSON.fromJSON(json);
  }
  
  public static KafkaMessengerConfiguration fromJSONBytes(byte[] json) {
    return KafkaMessengerConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String defaultTopic;
    private Map<String, String> producer;
    private Map<String, Object> data;
    private Boolean debug;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private Set<String> messageTypes;
    private String name;
    private String transport;
    private MessengerType type;
    public Builder defaultTopic(String defaultTopic) { this.defaultTopic = defaultTopic; return this; }
    public Builder producer(Map<String, String> producer) { this.producer = producer; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder messageTypes(Set<String> messageTypes) { this.messageTypes = messageTypes; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder transport(String transport) { this.transport = transport; return this; }
    public Builder type(MessengerType type) { this.type = type; return this; }
    public KafkaMessengerConfiguration build() { return new KafkaMessengerConfiguration(defaultTopic, producer, data, debug, id, insertInstant, lastUpdateInstant, messageTypes, name, transport, type); }
  }
}
