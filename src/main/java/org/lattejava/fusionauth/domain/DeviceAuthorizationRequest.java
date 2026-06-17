/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DeviceAuthorizationRequestJSON;

@JSON
public record DeviceAuthorizationRequest(
    String client_id,
    String client_secret,
    String scope,
    UUID tenantId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DeviceAuthorizationRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return DeviceAuthorizationRequestJSON.toJSONBytes(this);
  }
  
  public static DeviceAuthorizationRequest fromJSON(String json) {
    return DeviceAuthorizationRequestJSON.fromJSON(json);
  }
  
  public static DeviceAuthorizationRequest fromJSONBytes(byte[] json) {
    return DeviceAuthorizationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String client_secret;
    private String scope;
    private UUID tenantId;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public DeviceAuthorizationRequest build() { return new DeviceAuthorizationRequest(client_id, client_secret, scope, tenantId); }
  }
}
