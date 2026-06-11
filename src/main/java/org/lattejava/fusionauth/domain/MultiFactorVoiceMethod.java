/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MultiFactorVoiceMethodJSON;

@JSON
public record MultiFactorVoiceMethod(
    UUID messengerId,
    UUID templateId,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MultiFactorVoiceMethodJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MultiFactorVoiceMethodJSON.toJSONBytes(this);
  }

  public static MultiFactorVoiceMethod fromJSON(String json) {
    return MultiFactorVoiceMethodJSON.fromJSON(json);
  }

  public static MultiFactorVoiceMethod fromJSONBytes(byte[] json) {
    return MultiFactorVoiceMethodJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID messengerId;
    private UUID templateId;
    private Boolean enabled;
    public Builder messengerId(UUID messengerId) { this.messengerId = messengerId; return this; }
    public Builder templateId(UUID templateId) { this.templateId = templateId; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public MultiFactorVoiceMethod build() { return new MultiFactorVoiceMethod(messengerId, templateId, enabled); }
  }
}
