/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.APIKeyJSON;

@JSON
public record APIKey(
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expirationInstant,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    UUID ipAccessControlListId,
    String key,
    Boolean keyManager,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    APIKeyMetaData metaData,
    String name,
    APIKeyPermissions permissions,
    Boolean retrievable,
    UUID tenantId) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Instant expirationInstant;
    private UUID id;
    private Instant insertInstant;
    private UUID ipAccessControlListId;
    private String key;
    private Boolean keyManager;
    private Instant lastUpdateInstant;
    private APIKeyMetaData metaData;
    private String name;
    private APIKeyPermissions permissions;
    private Boolean retrievable;
    private UUID tenantId;

    public Builder expirationInstant(Instant expirationInstant) { this.expirationInstant = expirationInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder ipAccessControlListId(UUID ipAccessControlListId) { this.ipAccessControlListId = ipAccessControlListId; return this; }
    public Builder key(String key) { this.key = key; return this; }
    public Builder keyManager(Boolean keyManager) { this.keyManager = keyManager; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder metaData(APIKeyMetaData metaData) { this.metaData = metaData; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder permissions(APIKeyPermissions permissions) { this.permissions = permissions; return this; }
    public Builder retrievable(Boolean retrievable) { this.retrievable = retrievable; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }

    public APIKey build() {
      return new APIKey(expirationInstant, id, insertInstant, ipAccessControlListId, key, keyManager,
          lastUpdateInstant, metaData, name, permissions, retrievable, tenantId);
    }
  }

  public String toJSON() {
    return APIKeyJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return APIKeyJSON.toJSONBytes(this);
  }

  public static APIKey fromJSON(String json) {
    return APIKeyJSON.fromJSON(json);
  }

  public static APIKey fromJSONBytes(byte[] json) {
    return APIKeyJSON.fromJSON(json);
  }
}
