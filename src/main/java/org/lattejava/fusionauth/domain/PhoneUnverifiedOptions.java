/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PhoneUnverifiedOptionsJSON;

@JSON
public record PhoneUnverifiedOptions(
    Boolean allowPhoneNumberChangeWhenGated,
    UnverifiedBehavior behavior) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PhoneUnverifiedOptionsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PhoneUnverifiedOptionsJSON.toJSONBytes(this);
  }

  public static PhoneUnverifiedOptions fromJSON(String json) {
    return PhoneUnverifiedOptionsJSON.fromJSON(json);
  }

  public static PhoneUnverifiedOptions fromJSONBytes(byte[] json) {
    return PhoneUnverifiedOptionsJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean allowPhoneNumberChangeWhenGated;
    private UnverifiedBehavior behavior;
    public Builder allowPhoneNumberChangeWhenGated(Boolean allowPhoneNumberChangeWhenGated) { this.allowPhoneNumberChangeWhenGated = allowPhoneNumberChangeWhenGated; return this; }
    public Builder behavior(UnverifiedBehavior behavior) { this.behavior = behavior; return this; }
    public PhoneUnverifiedOptions build() { return new PhoneUnverifiedOptions(allowPhoneNumberChangeWhenGated, behavior); }
  }
}
