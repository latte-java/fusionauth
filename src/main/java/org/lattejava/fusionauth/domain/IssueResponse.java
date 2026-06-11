/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IssueResponseJSON;

@JSON
public record IssueResponse(
    String refreshToken,
    String token) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IssueResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IssueResponseJSON.toJSONBytes(this);
  }

  public static IssueResponse fromJSON(String json) {
    return IssueResponseJSON.fromJSON(json);
  }

  public static IssueResponse fromJSONBytes(byte[] json) {
    return IssueResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String refreshToken;
    private String token;
    public Builder refreshToken(String refreshToken) { this.refreshToken = refreshToken; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public IssueResponse build() { return new IssueResponse(refreshToken, token); }
  }
}
