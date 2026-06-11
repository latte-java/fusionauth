/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SystemConfigurationResponseJSON;

@JSON
public record SystemConfigurationResponse(
    SystemConfiguration systemConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SystemConfigurationResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SystemConfigurationResponseJSON.toJSONBytes(this);
  }

  public static SystemConfigurationResponse fromJSON(String json) {
    return SystemConfigurationResponseJSON.fromJSON(json);
  }

  public static SystemConfigurationResponse fromJSONBytes(byte[] json) {
    return SystemConfigurationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private SystemConfiguration systemConfiguration;
    public Builder systemConfiguration(SystemConfiguration systemConfiguration) { this.systemConfiguration = systemConfiguration; return this; }
    public SystemConfigurationResponse build() { return new SystemConfigurationResponse(systemConfiguration); }
  }
}
