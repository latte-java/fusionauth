/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MultiFactorEmailTemplateJSON;

@JSON
public record MultiFactorEmailTemplate(
    UUID templateId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MultiFactorEmailTemplateJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MultiFactorEmailTemplateJSON.toJSONBytes(this);
  }

  public static MultiFactorEmailTemplate fromJSON(String json) {
    return MultiFactorEmailTemplateJSON.fromJSON(json);
  }

  public static MultiFactorEmailTemplate fromJSONBytes(byte[] json) {
    return MultiFactorEmailTemplateJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID templateId;
    public Builder templateId(UUID templateId) { this.templateId = templateId; return this; }
    public MultiFactorEmailTemplate build() { return new MultiFactorEmailTemplate(templateId); }
  }
}
