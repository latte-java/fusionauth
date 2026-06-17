/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FamilyJSON;

@JSON
public record Family(
    List<FamilyMember> members,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FamilyJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FamilyJSON.toJSONBytes(this);
  }
  
  public static Family fromJSON(String json) {
    return FamilyJSON.fromJSON(json);
  }
  
  public static Family fromJSONBytes(byte[] json) {
    return FamilyJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<FamilyMember> members;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    public Builder members(List<FamilyMember> members) { this.members = members; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Family build() { return new Family(members, id, insertInstant, lastUpdateInstant); }
  }
}
