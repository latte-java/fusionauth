/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordlessConfigurationJSON;

@JSON
public record PasswordlessConfiguration(
    PasswordlessStrategy emailLoginStrategy,
    PasswordlessStrategy phoneLoginStrategy,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordlessConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PasswordlessConfigurationJSON.toJSONBytes(this);
  }

  public static PasswordlessConfiguration fromJSON(String json) {
    return PasswordlessConfigurationJSON.fromJSON(json);
  }

  public static PasswordlessConfiguration fromJSONBytes(byte[] json) {
    return PasswordlessConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private PasswordlessStrategy emailLoginStrategy;
    private PasswordlessStrategy phoneLoginStrategy;
    private Boolean enabled;
    public Builder emailLoginStrategy(PasswordlessStrategy emailLoginStrategy) { this.emailLoginStrategy = emailLoginStrategy; return this; }
    public Builder phoneLoginStrategy(PasswordlessStrategy phoneLoginStrategy) { this.phoneLoginStrategy = phoneLoginStrategy; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public PasswordlessConfiguration build() { return new PasswordlessConfiguration(emailLoginStrategy, phoneLoginStrategy, enabled); }
  }
}
