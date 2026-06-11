/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationOAuthScopeRequestJSON;

@JSON
public record ApplicationOAuthScopeRequest(
    ApplicationOAuthScope scope) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationOAuthScopeRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationOAuthScopeRequestJSON.toJSONBytes(this);
  }

  public static ApplicationOAuthScopeRequest fromJSON(String json) {
    return ApplicationOAuthScopeRequestJSON.fromJSON(json);
  }

  public static ApplicationOAuthScopeRequest fromJSONBytes(byte[] json) {
    return ApplicationOAuthScopeRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private ApplicationOAuthScope scope;
    public Builder scope(ApplicationOAuthScope scope) { this.scope = scope; return this; }
    public ApplicationOAuthScopeRequest build() { return new ApplicationOAuthScopeRequest(scope); }
  }
}
