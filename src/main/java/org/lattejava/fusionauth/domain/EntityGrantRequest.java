/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityGrantRequestJSON;

@JSON
public record EntityGrantRequest(
    EntityGrant grant) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityGrantRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EntityGrantRequestJSON.toJSONBytes(this);
  }

  public static EntityGrantRequest fromJSON(String json) {
    return EntityGrantRequestJSON.fromJSON(json);
  }

  public static EntityGrantRequest fromJSONBytes(byte[] json) {
    return EntityGrantRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EntityGrant grant;
    public Builder grant(EntityGrant grant) { this.grant = grant; return this; }
    public EntityGrantRequest build() { return new EntityGrantRequest(grant); }
  }
}
