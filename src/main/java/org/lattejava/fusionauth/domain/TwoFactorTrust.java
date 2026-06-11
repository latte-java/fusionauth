/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorTrustJSON;

@JSON
public record TwoFactorTrust(
    UUID applicationId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expiration,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant startInstant) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorTrustJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorTrustJSON.toJSONBytes(this);
  }

  public static TwoFactorTrust fromJSON(String json) {
    return TwoFactorTrustJSON.fromJSON(json);
  }

  public static TwoFactorTrust fromJSONBytes(byte[] json) {
    return TwoFactorTrustJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private Instant expiration;
    private Instant startInstant;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder expiration(Instant expiration) { this.expiration = expiration; return this; }
    public Builder startInstant(Instant startInstant) { this.startInstant = startInstant; return this; }
    public TwoFactorTrust build() { return new TwoFactorTrust(applicationId, expiration, startInstant); }
  }
}
