/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FormFieldRequestJSON;

@JSON
public record FormFieldRequest(
    FormField field,
    List<FormField> fields) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FormFieldRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FormFieldRequestJSON.toJSONBytes(this);
  }

  public static FormFieldRequest fromJSON(String json) {
    return FormFieldRequestJSON.fromJSON(json);
  }

  public static FormFieldRequest fromJSONBytes(byte[] json) {
    return FormFieldRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private FormField field;
    private List<FormField> fields;
    public Builder field(FormField field) { this.field = field; return this; }
    public Builder fields(List<FormField> fields) { this.fields = fields; return this; }
    public FormFieldRequest build() { return new FormFieldRequest(field, fields); }
  }
}
