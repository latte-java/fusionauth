/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationAccessControlConfigurationJSON;

@JSON
public record ApplicationAccessControlConfiguration(
    UUID uiIPAccessControlListId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationAccessControlConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationAccessControlConfigurationJSON.toJSONBytes(this);
  }
  
  public static ApplicationAccessControlConfiguration fromJSON(String json) {
    return ApplicationAccessControlConfigurationJSON.fromJSON(json);
  }
  
  public static ApplicationAccessControlConfiguration fromJSONBytes(byte[] json) {
    return ApplicationAccessControlConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID uiIPAccessControlListId;
    public Builder uiIPAccessControlListId(UUID uiIPAccessControlListId) { this.uiIPAccessControlListId = uiIPAccessControlListId; return this; }
    public ApplicationAccessControlConfiguration build() { return new ApplicationAccessControlConfiguration(uiIPAccessControlListId); }
  }
}
