/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityTypePermissionJSON;

@JSON
public record EntityTypePermission(
    Map<String, Object> data,
    String description,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    Boolean isDefault,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityTypePermissionJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntityTypePermissionJSON.toJSONBytes(this);
  }

  public static EntityTypePermission fromJSON(String json) {
    return EntityTypePermissionJSON.fromJSON(json);
  }

  public static EntityTypePermission fromJSONBytes(byte[] json) {
    return EntityTypePermissionJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private String description;
    private UUID id;
    private Instant insertInstant;
    private Boolean isDefault;
    private Instant lastUpdateInstant;
    private String name;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder description(String description) { this.description = description; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder isDefault(Boolean isDefault) { this.isDefault = isDefault; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public EntityTypePermission build() { return new EntityTypePermission(data, description, id, insertInstant, isDefault, lastUpdateInstant, name); }
  }
}
