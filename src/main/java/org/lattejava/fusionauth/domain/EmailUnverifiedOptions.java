/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailUnverifiedOptionsJSON;

@JSON
public record EmailUnverifiedOptions(
    Boolean allowEmailChangeWhenGated,
    UnverifiedBehavior behavior) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailUnverifiedOptionsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EmailUnverifiedOptionsJSON.toJSONBytes(this);
  }

  public static EmailUnverifiedOptions fromJSON(String json) {
    return EmailUnverifiedOptionsJSON.fromJSON(json);
  }

  public static EmailUnverifiedOptions fromJSONBytes(byte[] json) {
    return EmailUnverifiedOptionsJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean allowEmailChangeWhenGated;
    private UnverifiedBehavior behavior;
    public Builder allowEmailChangeWhenGated(Boolean allowEmailChangeWhenGated) { this.allowEmailChangeWhenGated = allowEmailChangeWhenGated; return this; }
    public Builder behavior(UnverifiedBehavior behavior) { this.behavior = behavior; return this; }
    public EmailUnverifiedOptions build() { return new EmailUnverifiedOptions(allowEmailChangeWhenGated, behavior); }
  }
}
