/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupMemberJSON;

@JSON
public record GroupMember(
    Map<String, Object> data,
    UUID groupId,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupMemberJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupMemberJSON.toJSONBytes(this);
  }
  
  public static GroupMember fromJSON(String json) {
    return GroupMemberJSON.fromJSON(json);
  }
  
  public static GroupMember fromJSONBytes(byte[] json) {
    return GroupMemberJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private UUID groupId;
    private UUID id;
    private Instant insertInstant;
    private UUID userId;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder groupId(UUID groupId) { this.groupId = groupId; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public GroupMember build() { return new GroupMember(data, groupId, id, insertInstant, userId); }
  }
}
