/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SystemConfigurationRequestJSON;

@JSON
public record SystemConfigurationRequest(
    SystemConfiguration systemConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SystemConfigurationRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SystemConfigurationRequestJSON.toJSONBytes(this);
  }
  
  public static SystemConfigurationRequest fromJSON(String json) {
    return SystemConfigurationRequestJSON.fromJSON(json);
  }
  
  public static SystemConfigurationRequest fromJSONBytes(byte[] json) {
    return SystemConfigurationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private SystemConfiguration systemConfiguration;
    public Builder systemConfiguration(SystemConfiguration systemConfiguration) { this.systemConfiguration = systemConfiguration; return this; }
    public SystemConfigurationRequest build() { return new SystemConfigurationRequest(systemConfiguration); }
  }
}
