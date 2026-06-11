/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MultiFactorEmailMethodJSON;

@JSON
public record MultiFactorEmailMethod(
    UUID templateId,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MultiFactorEmailMethodJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MultiFactorEmailMethodJSON.toJSONBytes(this);
  }

  public static MultiFactorEmailMethod fromJSON(String json) {
    return MultiFactorEmailMethodJSON.fromJSON(json);
  }

  public static MultiFactorEmailMethod fromJSONBytes(byte[] json) {
    return MultiFactorEmailMethodJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID templateId;
    private Boolean enabled;
    public Builder templateId(UUID templateId) { this.templateId = templateId; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public MultiFactorEmailMethod build() { return new MultiFactorEmailMethod(templateId, enabled); }
  }
}
