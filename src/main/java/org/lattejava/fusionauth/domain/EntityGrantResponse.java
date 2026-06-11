/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityGrantResponseJSON;

@JSON
public record EntityGrantResponse(
    List<EntityGrant> grants,
    EntityGrant grant) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityGrantResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntityGrantResponseJSON.toJSONBytes(this);
  }

  public static EntityGrantResponse fromJSON(String json) {
    return EntityGrantResponseJSON.fromJSON(json);
  }

  public static EntityGrantResponse fromJSONBytes(byte[] json) {
    return EntityGrantResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<EntityGrant> grants;
    private EntityGrant grant;
    public Builder grants(List<EntityGrant> grants) { this.grants = grants; return this; }
    public Builder grant(EntityGrant grant) { this.grant = grant; return this; }
    public EntityGrantResponse build() { return new EntityGrantResponse(grants, grant); }
  }
}
