/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MultiFactorSMSTemplateJSON;

@JSON
public record MultiFactorSMSTemplate(
    UUID templateId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MultiFactorSMSTemplateJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MultiFactorSMSTemplateJSON.toJSONBytes(this);
  }

  public static MultiFactorSMSTemplate fromJSON(String json) {
    return MultiFactorSMSTemplateJSON.fromJSON(json);
  }

  public static MultiFactorSMSTemplate fromJSONBytes(byte[] json) {
    return MultiFactorSMSTemplateJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID templateId;
    public Builder templateId(UUID templateId) { this.templateId = templateId; return this; }
    public MultiFactorSMSTemplate build() { return new MultiFactorSMSTemplate(templateId); }
  }
}
