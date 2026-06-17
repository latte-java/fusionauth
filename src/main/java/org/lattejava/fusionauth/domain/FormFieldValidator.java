/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FormFieldValidatorJSON;

@JSON
public record FormFieldValidator(
    String expression,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FormFieldValidatorJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FormFieldValidatorJSON.toJSONBytes(this);
  }
  
  public static FormFieldValidator fromJSON(String json) {
    return FormFieldValidatorJSON.fromJSON(json);
  }
  
  public static FormFieldValidator fromJSONBytes(byte[] json) {
    return FormFieldValidatorJSON.fromJSON(json);
  }

  public static final class Builder {
    private String expression;
    private Boolean enabled;
    public Builder expression(String expression) { this.expression = expression; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public FormFieldValidator build() { return new FormFieldValidator(expression, enabled); }
  }
}
