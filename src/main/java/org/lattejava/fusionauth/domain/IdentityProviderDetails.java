/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderDetailsJSON;

@JSON
public record IdentityProviderDetails(
    List<UUID> applicationIds,
    UUID id,
    String idpEndpoint,
    String name,
    IdentityProviderOauth2Configuration oauth2,
    UUID tenantId,
    IdentityProviderType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderDetailsJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderDetailsJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderDetails fromJSON(String json) {
    return IdentityProviderDetailsJSON.fromJSON(json);
  }
  
  public static IdentityProviderDetails fromJSONBytes(byte[] json) {
    return IdentityProviderDetailsJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<UUID> applicationIds;
    private UUID id;
    private String idpEndpoint;
    private String name;
    private IdentityProviderOauth2Configuration oauth2;
    private UUID tenantId;
    private IdentityProviderType type;
    public Builder applicationIds(List<UUID> applicationIds) { this.applicationIds = applicationIds; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder idpEndpoint(String idpEndpoint) { this.idpEndpoint = idpEndpoint; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder oauth2(IdentityProviderOauth2Configuration oauth2) { this.oauth2 = oauth2; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(IdentityProviderType type) { this.type = type; return this; }
    public IdentityProviderDetails build() { return new IdentityProviderDetails(applicationIds, id, idpEndpoint, name, oauth2, tenantId, type); }
  }
}
