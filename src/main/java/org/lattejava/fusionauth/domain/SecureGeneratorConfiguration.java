/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SecureGeneratorConfigurationJSON;

@JSON
public record SecureGeneratorConfiguration(
    Integer length,
    SecureGeneratorType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SecureGeneratorConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SecureGeneratorConfigurationJSON.toJSONBytes(this);
  }
  
  public static SecureGeneratorConfiguration fromJSON(String json) {
    return SecureGeneratorConfigurationJSON.fromJSON(json);
  }
  
  public static SecureGeneratorConfiguration fromJSONBytes(byte[] json) {
    return SecureGeneratorConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer length;
    private SecureGeneratorType type;
    public Builder length(Integer length) { this.length = length; return this; }
    public Builder type(SecureGeneratorType type) { this.type = type; return this; }
    public SecureGeneratorConfiguration build() { return new SecureGeneratorConfiguration(length, type); }
  }
}
