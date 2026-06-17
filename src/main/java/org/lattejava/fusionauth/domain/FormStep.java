/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FormStepJSON;

@JSON
public record FormStep(
    List<UUID> fields,
    FormStepType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FormStepJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FormStepJSON.toJSONBytes(this);
  }
  
  public static FormStep fromJSON(String json) {
    return FormStepJSON.fromJSON(json);
  }
  
  public static FormStep fromJSONBytes(byte[] json) {
    return FormStepJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<UUID> fields;
    private FormStepType type;
    public Builder fields(List<UUID> fields) { this.fields = fields; return this; }
    public Builder type(FormStepType type) { this.type = type; return this; }
    public FormStep build() { return new FormStep(fields, type); }
  }
}
