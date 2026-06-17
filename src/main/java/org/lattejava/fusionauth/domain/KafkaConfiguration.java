/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KafkaConfigurationJSON;

@JSON
public record KafkaConfiguration(
    String defaultTopic,
    Map<String, String> producer,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return KafkaConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return KafkaConfigurationJSON.toJSONBytes(this);
  }
  
  public static KafkaConfiguration fromJSON(String json) {
    return KafkaConfigurationJSON.fromJSON(json);
  }
  
  public static KafkaConfiguration fromJSONBytes(byte[] json) {
    return KafkaConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String defaultTopic;
    private Map<String, String> producer;
    private Boolean enabled;
    public Builder defaultTopic(String defaultTopic) { this.defaultTopic = defaultTopic; return this; }
    public Builder producer(Map<String, String> producer) { this.producer = producer; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public KafkaConfiguration build() { return new KafkaConfiguration(defaultTopic, producer, enabled); }
  }
}
