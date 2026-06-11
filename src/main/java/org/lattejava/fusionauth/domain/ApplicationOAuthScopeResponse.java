/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationOAuthScopeResponseJSON;

@JSON
public record ApplicationOAuthScopeResponse(
    ApplicationOAuthScope scope) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationOAuthScopeResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationOAuthScopeResponseJSON.toJSONBytes(this);
  }

  public static ApplicationOAuthScopeResponse fromJSON(String json) {
    return ApplicationOAuthScopeResponseJSON.fromJSON(json);
  }

  public static ApplicationOAuthScopeResponse fromJSONBytes(byte[] json) {
    return ApplicationOAuthScopeResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private ApplicationOAuthScope scope;
    public Builder scope(ApplicationOAuthScope scope) { this.scope = scope; return this; }
    public ApplicationOAuthScopeResponse build() { return new ApplicationOAuthScopeResponse(scope); }
  }
}
