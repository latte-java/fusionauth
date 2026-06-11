/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UniversalApplicationConfigurationJSON;

@JSON
public record UniversalApplicationConfiguration(
    Boolean universal) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UniversalApplicationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UniversalApplicationConfigurationJSON.toJSONBytes(this);
  }

  public static UniversalApplicationConfiguration fromJSON(String json) {
    return UniversalApplicationConfigurationJSON.fromJSON(json);
  }

  public static UniversalApplicationConfiguration fromJSONBytes(byte[] json) {
    return UniversalApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean universal;
    public Builder universal(Boolean universal) { this.universal = universal; return this; }
    public UniversalApplicationConfiguration build() { return new UniversalApplicationConfiguration(universal); }
  }
}
