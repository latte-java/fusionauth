/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RequiresCORSConfigurationJSON;

@JSON
public record RequiresCORSConfiguration() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RequiresCORSConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RequiresCORSConfigurationJSON.toJSONBytes(this);
  }
  
  public static RequiresCORSConfiguration fromJSON(String json) {
    return RequiresCORSConfigurationJSON.fromJSON(json);
  }
  
  public static RequiresCORSConfiguration fromJSONBytes(byte[] json) {
    return RequiresCORSConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    public RequiresCORSConfiguration build() { return new RequiresCORSConfiguration(); }
  }
}
