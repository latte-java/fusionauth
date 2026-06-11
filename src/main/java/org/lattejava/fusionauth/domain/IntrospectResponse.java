/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IntrospectResponseJSON;

@JSON
public record IntrospectResponse() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IntrospectResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IntrospectResponseJSON.toJSONBytes(this);
  }

  public static IntrospectResponse fromJSON(String json) {
    return IntrospectResponseJSON.fromJSON(json);
  }

  public static IntrospectResponse fromJSONBytes(byte[] json) {
    return IntrospectResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    public IntrospectResponse build() { return new IntrospectResponse(); }
  }
}
