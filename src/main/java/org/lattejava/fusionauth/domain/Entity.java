/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EntityJSON;

@JSON
public record Entity(
    Map<String, Object> data,
    String clientId,
    String clientSecret,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    UUID parentId,
    UUID tenantId,
    EntityType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EntityJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EntityJSON.toJSONBytes(this);
  }
  
  public static Entity fromJSON(String json) {
    return EntityJSON.fromJSON(json);
  }
  
  public static Entity fromJSONBytes(byte[] json) {
    return EntityJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private String clientId;
    private String clientSecret;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    private UUID parentId;
    private UUID tenantId;
    private EntityType type;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder clientId(String clientId) { this.clientId = clientId; return this; }
    public Builder clientSecret(String clientSecret) { this.clientSecret = clientSecret; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder parentId(UUID parentId) { this.parentId = parentId; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EntityType type) { this.type = type; return this; }
    public Entity build() { return new Entity(data, clientId, clientSecret, id, insertInstant, lastUpdateInstant, name, parentId, tenantId, type); }
  }
}
