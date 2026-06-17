/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderConnectionTestResponseJSON;

@JSON
public record IdentityProviderConnectionTestResponse(
    String connectionTestId,
    IdentityProviderConnectionTestResult result) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderConnectionTestResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderConnectionTestResponseJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderConnectionTestResponse fromJSON(String json) {
    return IdentityProviderConnectionTestResponseJSON.fromJSON(json);
  }
  
  public static IdentityProviderConnectionTestResponse fromJSONBytes(byte[] json) {
    return IdentityProviderConnectionTestResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String connectionTestId;
    private IdentityProviderConnectionTestResult result;
    public Builder connectionTestId(String connectionTestId) { this.connectionTestId = connectionTestId; return this; }
    public Builder result(IdentityProviderConnectionTestResult result) { this.result = result; return this; }
    public IdentityProviderConnectionTestResponse build() { return new IdentityProviderConnectionTestResponse(connectionTestId, result); }
  }
}
