/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TrustJSON;

@JSON
public record Trust(
    UUID applicationId,
    Map<String, String> attributes,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expirationInstant,
    String id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    StartInstant startInstants,
    Map<String, Object> state,
    UUID tenantId,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TrustJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TrustJSON.toJSONBytes(this);
  }

  public static Trust fromJSON(String json) {
    return TrustJSON.fromJSON(json);
  }

  public static Trust fromJSONBytes(byte[] json) {
    return TrustJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private Map<String, String> attributes;
    private Instant expirationInstant;
    private String id;
    private Instant insertInstant;
    private StartInstant startInstants;
    private Map<String, Object> state;
    private UUID tenantId;
    private UUID userId;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder attributes(Map<String, String> attributes) { this.attributes = attributes; return this; }
    public Builder expirationInstant(Instant expirationInstant) { this.expirationInstant = expirationInstant; return this; }
    public Builder id(String id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder startInstants(StartInstant startInstants) { this.startInstants = startInstants; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Trust build() { return new Trust(applicationId, attributes, expirationInstant, id, insertInstant, startInstants, state, tenantId, userId); }
  }
}
