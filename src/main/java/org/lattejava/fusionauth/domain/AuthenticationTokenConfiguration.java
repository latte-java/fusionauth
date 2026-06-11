/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuthenticationTokenConfigurationJSON;

@JSON
public record AuthenticationTokenConfiguration(
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuthenticationTokenConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AuthenticationTokenConfigurationJSON.toJSONBytes(this);
  }

  public static AuthenticationTokenConfiguration fromJSON(String json) {
    return AuthenticationTokenConfigurationJSON.fromJSON(json);
  }

  public static AuthenticationTokenConfiguration fromJSONBytes(byte[] json) {
    return AuthenticationTokenConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean enabled;
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public AuthenticationTokenConfiguration build() { return new AuthenticationTokenConfiguration(enabled); }
  }
}
