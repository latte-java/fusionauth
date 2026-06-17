/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationRegistrationDeletePolicyJSON;

@JSON
public record ApplicationRegistrationDeletePolicy(
    TimeBasedDeletePolicy unverified) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationRegistrationDeletePolicyJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationRegistrationDeletePolicyJSON.toJSONBytes(this);
  }
  
  public static ApplicationRegistrationDeletePolicy fromJSON(String json) {
    return ApplicationRegistrationDeletePolicyJSON.fromJSON(json);
  }
  
  public static ApplicationRegistrationDeletePolicy fromJSONBytes(byte[] json) {
    return ApplicationRegistrationDeletePolicyJSON.fromJSON(json);
  }

  public static final class Builder {
    private TimeBasedDeletePolicy unverified;
    public Builder unverified(TimeBasedDeletePolicy unverified) { this.unverified = unverified; return this; }
    public ApplicationRegistrationDeletePolicy build() { return new ApplicationRegistrationDeletePolicy(unverified); }
  }
}
