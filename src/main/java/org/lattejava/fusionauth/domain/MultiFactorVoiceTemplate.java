/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MultiFactorVoiceTemplateJSON;

@JSON
public record MultiFactorVoiceTemplate(
    UUID templateId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MultiFactorVoiceTemplateJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MultiFactorVoiceTemplateJSON.toJSONBytes(this);
  }
  
  public static MultiFactorVoiceTemplate fromJSON(String json) {
    return MultiFactorVoiceTemplateJSON.fromJSON(json);
  }
  
  public static MultiFactorVoiceTemplate fromJSONBytes(byte[] json) {
    return MultiFactorVoiceTemplateJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID templateId;
    public Builder templateId(UUID templateId) { this.templateId = templateId; return this; }
    public MultiFactorVoiceTemplate build() { return new MultiFactorVoiceTemplate(templateId); }
  }
}
