/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshResponseJSON;

@JSON
public record RefreshResponse() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RefreshResponseJSON.toJSONBytes(this);
  }

  public static RefreshResponse fromJSON(String json) {
    return RefreshResponseJSON.fromJSON(json);
  }

  public static RefreshResponse fromJSONBytes(byte[] json) {
    return RefreshResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    public RefreshResponse build() { return new RefreshResponse(); }
  }
}
