/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MultiFactorSMSMethodJSON;

@JSON
public record MultiFactorSMSMethod(
    UUID messengerId,
    UUID templateId,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MultiFactorSMSMethodJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MultiFactorSMSMethodJSON.toJSONBytes(this);
  }
  
  public static MultiFactorSMSMethod fromJSON(String json) {
    return MultiFactorSMSMethodJSON.fromJSON(json);
  }
  
  public static MultiFactorSMSMethod fromJSONBytes(byte[] json) {
    return MultiFactorSMSMethodJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID messengerId;
    private UUID templateId;
    private Boolean enabled;
    public Builder messengerId(UUID messengerId) { this.messengerId = messengerId; return this; }
    public Builder templateId(UUID templateId) { this.templateId = templateId; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public MultiFactorSMSMethod build() { return new MultiFactorSMSMethod(messengerId, templateId, enabled); }
  }
}
