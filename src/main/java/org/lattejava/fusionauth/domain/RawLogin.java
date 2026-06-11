/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RawLoginJSON;

@JSON
public record RawLogin(
    UUID applicationId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant instant,
    String ipAddress,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RawLoginJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RawLoginJSON.toJSONBytes(this);
  }

  public static RawLogin fromJSON(String json) {
    return RawLoginJSON.fromJSON(json);
  }

  public static RawLogin fromJSONBytes(byte[] json) {
    return RawLoginJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private Instant instant;
    private String ipAddress;
    private UUID userId;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder instant(Instant instant) { this.instant = instant; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public RawLogin build() { return new RawLogin(applicationId, instant, ipAddress, userId); }
  }
}
