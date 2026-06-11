/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantRequestJSON;

@JSON
public record TenantRequest(
    UUID sourceTenantId,
    Tenant tenant,
    List<UUID> webhookIds,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantRequestJSON.toJSONBytes(this);
  }

  public static TenantRequest fromJSON(String json) {
    return TenantRequestJSON.fromJSON(json);
  }

  public static TenantRequest fromJSONBytes(byte[] json) {
    return TenantRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID sourceTenantId;
    private Tenant tenant;
    private List<UUID> webhookIds;
    private EventInfo eventInfo;
    public Builder sourceTenantId(UUID sourceTenantId) { this.sourceTenantId = sourceTenantId; return this; }
    public Builder tenant(Tenant tenant) { this.tenant = tenant; return this; }
    public Builder webhookIds(List<UUID> webhookIds) { this.webhookIds = webhookIds; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public TenantRequest build() { return new TenantRequest(sourceTenantId, tenant, webhookIds, eventInfo); }
  }
}
