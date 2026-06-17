/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserIdentityJSON;

@JSON
public record UserIdentity(
    String displayValue,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastLoginInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    ContentStatus moderationStatus,
    Boolean primary,
    IdentityType type,
    String value,
    Boolean verified,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant verifiedInstant,
    IdentityVerifiedReason verifiedReason) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserIdentityJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserIdentityJSON.toJSONBytes(this);
  }
  
  public static UserIdentity fromJSON(String json) {
    return UserIdentityJSON.fromJSON(json);
  }
  
  public static UserIdentity fromJSONBytes(byte[] json) {
    return UserIdentityJSON.fromJSON(json);
  }

  public static final class Builder {
    private String displayValue;
    private Instant insertInstant;
    private Instant lastLoginInstant;
    private Instant lastUpdateInstant;
    private ContentStatus moderationStatus;
    private Boolean primary;
    private IdentityType type;
    private String value;
    private Boolean verified;
    private Instant verifiedInstant;
    private IdentityVerifiedReason verifiedReason;
    public Builder displayValue(String displayValue) { this.displayValue = displayValue; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastLoginInstant(Instant lastLoginInstant) { this.lastLoginInstant = lastLoginInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder moderationStatus(ContentStatus moderationStatus) { this.moderationStatus = moderationStatus; return this; }
    public Builder primary(Boolean primary) { this.primary = primary; return this; }
    public Builder type(IdentityType type) { this.type = type; return this; }
    public Builder value(String value) { this.value = value; return this; }
    public Builder verified(Boolean verified) { this.verified = verified; return this; }
    public Builder verifiedInstant(Instant verifiedInstant) { this.verifiedInstant = verifiedInstant; return this; }
    public Builder verifiedReason(IdentityVerifiedReason verifiedReason) { this.verifiedReason = verifiedReason; return this; }
    public UserIdentity build() { return new UserIdentity(displayValue, insertInstant, lastLoginInstant, lastUpdateInstant, moderationStatus, primary, type, value, verified, verifiedInstant, verifiedReason); }
  }
}
