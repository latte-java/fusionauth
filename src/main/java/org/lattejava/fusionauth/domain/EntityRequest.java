/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityRequestJSON;

@JSON
public record EntityRequest(
    Entity entity) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityRequestJSON.toJSONBytes(this);
  }
  
  public static EntityRequest fromJSON(String json) {
    return EntityRequestJSON.fromJSON(json);
  }
  
  public static EntityRequest fromJSONBytes(byte[] json) {
    return EntityRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Entity entity;
    public Builder entity(Entity entity) { this.entity = entity; return this; }
    public EntityRequest build() { return new EntityRequest(entity); }
  }
}
