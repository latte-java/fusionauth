/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityTypeResponseJSON;

@JSON
public record EntityTypeResponse(
    EntityType entityType,
    List<EntityType> entityTypes,
    EntityTypePermission permission) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityTypeResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntityTypeResponseJSON.toJSONBytes(this);
  }

  public static EntityTypeResponse fromJSON(String json) {
    return EntityTypeResponseJSON.fromJSON(json);
  }

  public static EntityTypeResponse fromJSONBytes(byte[] json) {
    return EntityTypeResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private EntityType entityType;
    private List<EntityType> entityTypes;
    private EntityTypePermission permission;
    public Builder entityType(EntityType entityType) { this.entityType = entityType; return this; }
    public Builder entityTypes(List<EntityType> entityTypes) { this.entityTypes = entityTypes; return this; }
    public Builder permission(EntityTypePermission permission) { this.permission = permission; return this; }
    public EntityTypeResponse build() { return new EntityTypeResponse(entityType, entityTypes, permission); }
  }
}
