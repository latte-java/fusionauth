/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationRoleJSON;

@JSON
public record ApplicationRole(
    String description,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    Boolean isDefault,
    Boolean isSuperRole,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationRoleJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationRoleJSON.toJSONBytes(this);
  }

  public static ApplicationRole fromJSON(String json) {
    return ApplicationRoleJSON.fromJSON(json);
  }

  public static ApplicationRole fromJSONBytes(byte[] json) {
    return ApplicationRoleJSON.fromJSON(json);
  }

  public static final class Builder {
    private String description;
    private UUID id;
    private Instant insertInstant;
    private Boolean isDefault;
    private Boolean isSuperRole;
    private Instant lastUpdateInstant;
    private String name;
    public Builder description(String description) { this.description = description; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder isDefault(Boolean isDefault) { this.isDefault = isDefault; return this; }
    public Builder isSuperRole(Boolean isSuperRole) { this.isSuperRole = isSuperRole; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public ApplicationRole build() { return new ApplicationRole(description, id, insertInstant, isDefault, isSuperRole, lastUpdateInstant, name); }
  }
}
