/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.GroupJSON;

@JSON
public record Group(
    Map<String, Object> data,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    Map<String, List<ApplicationRole>> roles,
    UUID tenantId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return GroupJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return GroupJSON.toJSONBytes(this);
  }
  
  public static Group fromJSON(String json) {
    return GroupJSON.fromJSON(json);
  }
  
  public static Group fromJSONBytes(byte[] json) {
    return GroupJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    private Map<String, List<ApplicationRole>> roles;
    private UUID tenantId;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder roles(Map<String, List<ApplicationRole>> roles) { this.roles = roles; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Group build() { return new Group(data, id, insertInstant, lastUpdateInstant, name, roles, tenantId); }
  }
}
