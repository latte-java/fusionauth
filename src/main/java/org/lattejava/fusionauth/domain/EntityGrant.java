/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityGrantJSON;

@JSON
public record EntityGrant(
    Map<String, Object> data,
    Entity entity,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Set<String> permissions,
    UUID recipientEntityId,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityGrantJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityGrantJSON.toJSONBytes(this);
  }
  
  public static EntityGrant fromJSON(String json) {
    return EntityGrantJSON.fromJSON(json);
  }
  
  public static EntityGrant fromJSONBytes(byte[] json) {
    return EntityGrantJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Entity entity;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private Set<String> permissions;
    private UUID recipientEntityId;
    private UUID userId;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder entity(Entity entity) { this.entity = entity; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder permissions(Set<String> permissions) { this.permissions = permissions; return this; }
    public Builder recipientEntityId(UUID recipientEntityId) { this.recipientEntityId = recipientEntityId; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public EntityGrant build() { return new EntityGrant(data, entity, id, insertInstant, lastUpdateInstant, permissions, recipientEntityId, userId); }
  }
}
