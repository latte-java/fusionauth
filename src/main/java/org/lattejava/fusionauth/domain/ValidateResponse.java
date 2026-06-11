/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ValidateResponseJSON;

@JSON
public record ValidateResponse(
    JWT jwt) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ValidateResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ValidateResponseJSON.toJSONBytes(this);
  }

  public static ValidateResponse fromJSON(String json) {
    return ValidateResponseJSON.fromJSON(json);
  }

  public static ValidateResponse fromJSONBytes(byte[] json) {
    return ValidateResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private JWT jwt;
    public Builder jwt(JWT jwt) { this.jwt = jwt; return this; }
    public ValidateResponse build() { return new ValidateResponse(jwt); }
  }
}
