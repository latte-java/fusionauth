/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityTypeJSON;

@JSON
public record EntityType(
    Map<String, Object> data,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    EntityJWTConfiguration jwtConfiguration,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    List<EntityTypePermission> permissions) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityTypeJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntityTypeJSON.toJSONBytes(this);
  }

  public static EntityType fromJSON(String json) {
    return EntityTypeJSON.fromJSON(json);
  }

  public static EntityType fromJSONBytes(byte[] json) {
    return EntityTypeJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private UUID id;
    private Instant insertInstant;
    private EntityJWTConfiguration jwtConfiguration;
    private Instant lastUpdateInstant;
    private String name;
    private List<EntityTypePermission> permissions;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder jwtConfiguration(EntityJWTConfiguration jwtConfiguration) { this.jwtConfiguration = jwtConfiguration; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder permissions(List<EntityTypePermission> permissions) { this.permissions = permissions; return this; }
    public EntityType build() { return new EntityType(data, id, insertInstant, jwtConfiguration, lastUpdateInstant, name, permissions); }
  }
}
