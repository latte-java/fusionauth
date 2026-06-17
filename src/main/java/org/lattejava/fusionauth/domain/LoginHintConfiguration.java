/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginHintConfigurationJSON;

@JSON
public record LoginHintConfiguration(
    String parameterName,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginHintConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginHintConfigurationJSON.toJSONBytes(this);
  }
  
  public static LoginHintConfiguration fromJSON(String json) {
    return LoginHintConfigurationJSON.fromJSON(json);
  }
  
  public static LoginHintConfiguration fromJSONBytes(byte[] json) {
    return LoginHintConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String parameterName;
    private Boolean enabled;
    public Builder parameterName(String parameterName) { this.parameterName = parameterName; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public LoginHintConfiguration build() { return new LoginHintConfiguration(parameterName, enabled); }
  }
}
