/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ErrorsJSON;

@JSON
public record Errors(
    Map<String, List<Error>> fieldErrors,
    List<Error> generalErrors) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ErrorsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ErrorsJSON.toJSONBytes(this);
  }

  public static Errors fromJSON(String json) {
    return ErrorsJSON.fromJSON(json);
  }

  public static Errors fromJSONBytes(byte[] json) {
    return ErrorsJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, List<Error>> fieldErrors;
    private List<Error> generalErrors;
    public Builder fieldErrors(Map<String, List<Error>> fieldErrors) { this.fieldErrors = fieldErrors; return this; }
    public Builder generalErrors(List<Error> generalErrors) { this.generalErrors = generalErrors; return this; }
    public Errors build() { return new Errors(fieldErrors, generalErrors); }
  }
}
