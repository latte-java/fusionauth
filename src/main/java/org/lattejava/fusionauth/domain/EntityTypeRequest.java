/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityTypeRequestJSON;

@JSON
public record EntityTypeRequest(
    EntityType entityType,
    EntityTypePermission permission) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityTypeRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityTypeRequestJSON.toJSONBytes(this);
  }
  
  public static EntityTypeRequest fromJSON(String json) {
    return EntityTypeRequestJSON.fromJSON(json);
  }
  
  public static EntityTypeRequest fromJSONBytes(byte[] json) {
    return EntityTypeRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EntityType entityType;
    private EntityTypePermission permission;
    public Builder entityType(EntityType entityType) { this.entityType = entityType; return this; }
    public Builder permission(EntityTypePermission permission) { this.permission = permission; return this; }
    public EntityTypeRequest build() { return new EntityTypeRequest(entityType, permission); }
  }
}
