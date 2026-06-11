/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FormRequestJSON;

@JSON
public record FormRequest(
    Form form) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FormRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FormRequestJSON.toJSONBytes(this);
  }

  public static FormRequest fromJSON(String json) {
    return FormRequestJSON.fromJSON(json);
  }

  public static FormRequest fromJSONBytes(byte[] json) {
    return FormRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Form form;
    public Builder form(Form form) { this.form = form; return this; }
    public FormRequest build() { return new FormRequest(form); }
  }
}
