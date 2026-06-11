/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SelfServiceFormConfigurationJSON;

@JSON
public record SelfServiceFormConfiguration(
    Boolean requireCurrentPasswordOnPasswordChange) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SelfServiceFormConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SelfServiceFormConfigurationJSON.toJSONBytes(this);
  }

  public static SelfServiceFormConfiguration fromJSON(String json) {
    return SelfServiceFormConfigurationJSON.fromJSON(json);
  }

  public static SelfServiceFormConfiguration fromJSONBytes(byte[] json) {
    return SelfServiceFormConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean requireCurrentPasswordOnPasswordChange;
    public Builder requireCurrentPasswordOnPasswordChange(Boolean requireCurrentPasswordOnPasswordChange) { this.requireCurrentPasswordOnPasswordChange = requireCurrentPasswordOnPasswordChange; return this; }
    public SelfServiceFormConfiguration build() { return new SelfServiceFormConfiguration(requireCurrentPasswordOnPasswordChange); }
  }
}
