/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RefreshTokenImportRequestJSON;

@JSON
public record RefreshTokenImportRequest(
    List<RefreshToken> refreshTokens,
    Boolean validateDbConstraints) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RefreshTokenImportRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RefreshTokenImportRequestJSON.toJSONBytes(this);
  }

  public static RefreshTokenImportRequest fromJSON(String json) {
    return RefreshTokenImportRequestJSON.fromJSON(json);
  }

  public static RefreshTokenImportRequest fromJSONBytes(byte[] json) {
    return RefreshTokenImportRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<RefreshToken> refreshTokens;
    private Boolean validateDbConstraints;
    public Builder refreshTokens(List<RefreshToken> refreshTokens) { this.refreshTokens = refreshTokens; return this; }
    public Builder validateDbConstraints(Boolean validateDbConstraints) { this.validateDbConstraints = validateDbConstraints; return this; }
    public RefreshTokenImportRequest build() { return new RefreshTokenImportRequest(refreshTokens, validateDbConstraints); }
  }
}
