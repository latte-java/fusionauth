/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifyCompleteResponseJSON;

@JSON
public record VerifyCompleteResponse(
    Map<String, Object> state) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifyCompleteResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return VerifyCompleteResponseJSON.toJSONBytes(this);
  }

  public static VerifyCompleteResponse fromJSON(String json) {
    return VerifyCompleteResponseJSON.fromJSON(json);
  }

  public static VerifyCompleteResponse fromJSONBytes(byte[] json) {
    return VerifyCompleteResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> state;
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public VerifyCompleteResponse build() { return new VerifyCompleteResponse(state); }
  }
}
