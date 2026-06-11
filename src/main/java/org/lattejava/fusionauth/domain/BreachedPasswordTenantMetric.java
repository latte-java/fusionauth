/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BreachedPasswordTenantMetricJSON;

@JSON
public record BreachedPasswordTenantMetric(
    Integer actionRequired,
    Integer matchedCommonPasswordCount,
    Integer matchedExactCount,
    Integer matchedPasswordCount,
    Integer matchedSubAddressCount,
    Integer passwordsCheckedCount) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BreachedPasswordTenantMetricJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return BreachedPasswordTenantMetricJSON.toJSONBytes(this);
  }

  public static BreachedPasswordTenantMetric fromJSON(String json) {
    return BreachedPasswordTenantMetricJSON.fromJSON(json);
  }

  public static BreachedPasswordTenantMetric fromJSONBytes(byte[] json) {
    return BreachedPasswordTenantMetricJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer actionRequired;
    private Integer matchedCommonPasswordCount;
    private Integer matchedExactCount;
    private Integer matchedPasswordCount;
    private Integer matchedSubAddressCount;
    private Integer passwordsCheckedCount;
    public Builder actionRequired(Integer actionRequired) { this.actionRequired = actionRequired; return this; }
    public Builder matchedCommonPasswordCount(Integer matchedCommonPasswordCount) { this.matchedCommonPasswordCount = matchedCommonPasswordCount; return this; }
    public Builder matchedExactCount(Integer matchedExactCount) { this.matchedExactCount = matchedExactCount; return this; }
    public Builder matchedPasswordCount(Integer matchedPasswordCount) { this.matchedPasswordCount = matchedPasswordCount; return this; }
    public Builder matchedSubAddressCount(Integer matchedSubAddressCount) { this.matchedSubAddressCount = matchedSubAddressCount; return this; }
    public Builder passwordsCheckedCount(Integer passwordsCheckedCount) { this.passwordsCheckedCount = passwordsCheckedCount; return this; }
    public BreachedPasswordTenantMetric build() { return new BreachedPasswordTenantMetric(actionRequired, matchedCommonPasswordCount, matchedExactCount, matchedPasswordCount, matchedSubAddressCount, passwordsCheckedCount); }
  }
}
