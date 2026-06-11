/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DisplayableRawLoginJSON;

@JSON
public record DisplayableRawLogin(
    String applicationName,
    Location location,
    String loginId,
    IdentityType loginIdType,
    UUID applicationId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant instant,
    String ipAddress,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DisplayableRawLoginJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return DisplayableRawLoginJSON.toJSONBytes(this);
  }

  public static DisplayableRawLogin fromJSON(String json) {
    return DisplayableRawLoginJSON.fromJSON(json);
  }

  public static DisplayableRawLogin fromJSONBytes(byte[] json) {
    return DisplayableRawLoginJSON.fromJSON(json);
  }

  public static final class Builder {
    private String applicationName;
    private Location location;
    private String loginId;
    private IdentityType loginIdType;
    private UUID applicationId;
    private Instant instant;
    private String ipAddress;
    private UUID userId;
    public Builder applicationName(String applicationName) { this.applicationName = applicationName; return this; }
    public Builder location(Location location) { this.location = location; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdType(IdentityType loginIdType) { this.loginIdType = loginIdType; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder instant(Instant instant) { this.instant = instant; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public DisplayableRawLogin build() { return new DisplayableRawLogin(applicationName, location, loginId, loginIdType, applicationId, instant, ipAddress, userId); }
  }
}
