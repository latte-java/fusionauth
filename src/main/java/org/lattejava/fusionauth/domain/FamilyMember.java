/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FamilyMemberJSON;

@JSON
public record FamilyMember(
    Map<String, Object> data,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Boolean owner,
    FamilyRole role,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FamilyMemberJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FamilyMemberJSON.toJSONBytes(this);
  }

  public static FamilyMember fromJSON(String json) {
    return FamilyMemberJSON.fromJSON(json);
  }

  public static FamilyMember fromJSONBytes(byte[] json) {
    return FamilyMemberJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private Boolean owner;
    private FamilyRole role;
    private UUID userId;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder owner(Boolean owner) { this.owner = owner; return this; }
    public Builder role(FamilyRole role) { this.role = role; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public FamilyMember build() { return new FamilyMember(data, insertInstant, lastUpdateInstant, owner, role, userId); }
  }
}
