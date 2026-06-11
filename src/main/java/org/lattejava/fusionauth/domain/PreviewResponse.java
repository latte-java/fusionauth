/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PreviewResponseJSON;

@JSON
public record PreviewResponse(
    Email email,
    Errors errors) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PreviewResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PreviewResponseJSON.toJSONBytes(this);
  }

  public static PreviewResponse fromJSON(String json) {
    return PreviewResponseJSON.fromJSON(json);
  }

  public static PreviewResponse fromJSONBytes(byte[] json) {
    return PreviewResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Email email;
    private Errors errors;
    public Builder email(Email email) { this.email = email; return this; }
    public Builder errors(Errors errors) { this.errors = errors; return this; }
    public PreviewResponse build() { return new PreviewResponse(email, errors); }
  }
}
