/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IntegrationsJSON;

@JSON
public record Integrations(
    CleanSpeakConfiguration cleanspeak,
    KafkaConfiguration kafka) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IntegrationsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IntegrationsJSON.toJSONBytes(this);
  }

  public static Integrations fromJSON(String json) {
    return IntegrationsJSON.fromJSON(json);
  }

  public static Integrations fromJSONBytes(byte[] json) {
    return IntegrationsJSON.fromJSON(json);
  }

  public static final class Builder {
    private CleanSpeakConfiguration cleanspeak;
    private KafkaConfiguration kafka;
    public Builder cleanspeak(CleanSpeakConfiguration cleanspeak) { this.cleanspeak = cleanspeak; return this; }
    public Builder kafka(KafkaConfiguration kafka) { this.kafka = kafka; return this; }
    public Integrations build() { return new Integrations(cleanspeak, kafka); }
  }
}
