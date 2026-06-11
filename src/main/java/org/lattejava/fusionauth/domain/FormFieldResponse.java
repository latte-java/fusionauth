/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FormFieldResponseJSON;

@JSON
public record FormFieldResponse(
    FormField field,
    List<FormField> fields) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FormFieldResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FormFieldResponseJSON.toJSONBytes(this);
  }

  public static FormFieldResponse fromJSON(String json) {
    return FormFieldResponseJSON.fromJSON(json);
  }

  public static FormFieldResponse fromJSONBytes(byte[] json) {
    return FormFieldResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private FormField field;
    private List<FormField> fields;
    public Builder field(FormField field) { this.field = field; return this; }
    public Builder fields(List<FormField> fields) { this.fields = fields; return this; }
    public FormFieldResponse build() { return new FormFieldResponse(field, fields); }
  }
}
