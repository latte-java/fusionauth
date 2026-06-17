/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityResponseJSON;

@JSON
public record EntityResponse(
    Entity entity) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityResponseJSON.toJSONBytes(this);
  }
  
  public static EntityResponse fromJSON(String json) {
    return EntityResponseJSON.fromJSON(json);
  }
  
  public static EntityResponse fromJSONBytes(byte[] json) {
    return EntityResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Entity entity;
    public Builder entity(Entity entity) { this.entity = entity; return this; }
    public EntityResponse build() { return new EntityResponse(entity); }
  }
}
