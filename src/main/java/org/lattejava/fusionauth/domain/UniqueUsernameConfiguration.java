/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UniqueUsernameConfigurationJSON;

@JSON
public record UniqueUsernameConfiguration(
    Integer numberOfDigits,
    String separator,
    UniqueUsernameStrategy strategy,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UniqueUsernameConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UniqueUsernameConfigurationJSON.toJSONBytes(this);
  }
  
  public static UniqueUsernameConfiguration fromJSON(String json) {
    return UniqueUsernameConfigurationJSON.fromJSON(json);
  }
  
  public static UniqueUsernameConfiguration fromJSONBytes(byte[] json) {
    return UniqueUsernameConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer numberOfDigits;
    private String separator;
    private UniqueUsernameStrategy strategy;
    private Boolean enabled;
    public Builder numberOfDigits(Integer numberOfDigits) { this.numberOfDigits = numberOfDigits; return this; }
    public Builder separator(String separator) { this.separator = separator; return this; }
    public Builder strategy(UniqueUsernameStrategy strategy) { this.strategy = strategy; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public UniqueUsernameConfiguration build() { return new UniqueUsernameConfiguration(numberOfDigits, separator, strategy, enabled); }
  }
}
