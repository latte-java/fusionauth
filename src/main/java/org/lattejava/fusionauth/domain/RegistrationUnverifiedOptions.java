/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RegistrationUnverifiedOptionsJSON;

@JSON
public record RegistrationUnverifiedOptions(
    UnverifiedBehavior behavior) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RegistrationUnverifiedOptionsJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RegistrationUnverifiedOptionsJSON.toJSONBytes(this);
  }
  
  public static RegistrationUnverifiedOptions fromJSON(String json) {
    return RegistrationUnverifiedOptionsJSON.fromJSON(json);
  }
  
  public static RegistrationUnverifiedOptions fromJSONBytes(byte[] json) {
    return RegistrationUnverifiedOptionsJSON.fromJSON(json);
  }

  public static final class Builder {
    private UnverifiedBehavior behavior;
    public Builder behavior(UnverifiedBehavior behavior) { this.behavior = behavior; return this; }
    public RegistrationUnverifiedOptions build() { return new RegistrationUnverifiedOptions(behavior); }
  }
}
