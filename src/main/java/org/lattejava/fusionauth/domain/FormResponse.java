/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FormResponseJSON;

@JSON
public record FormResponse(
    Form form,
    List<Form> forms) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FormResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FormResponseJSON.toJSONBytes(this);
  }
  
  public static FormResponse fromJSON(String json) {
    return FormResponseJSON.fromJSON(json);
  }
  
  public static FormResponse fromJSONBytes(byte[] json) {
    return FormResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Form form;
    private List<Form> forms;
    public Builder form(Form form) { this.form = form; return this; }
    public Builder forms(List<Form> forms) { this.forms = forms; return this; }
    public FormResponse build() { return new FormResponse(form, forms); }
  }
}
