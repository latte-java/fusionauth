/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DeviceUserCodeResponseJSON;

@JSON
public record DeviceUserCodeResponse(
    String client_id,
    DeviceInfo deviceInfo,
    Integer expires_in,
    PendingIdPLink pendingIdPLink,
    String scope,
    UUID tenantId,
    String user_code) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DeviceUserCodeResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return DeviceUserCodeResponseJSON.toJSONBytes(this);
  }
  
  public static DeviceUserCodeResponse fromJSON(String json) {
    return DeviceUserCodeResponseJSON.fromJSON(json);
  }
  
  public static DeviceUserCodeResponse fromJSONBytes(byte[] json) {
    return DeviceUserCodeResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private DeviceInfo deviceInfo;
    private Integer expires_in;
    private PendingIdPLink pendingIdPLink;
    private String scope;
    private UUID tenantId;
    private String user_code;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder deviceInfo(DeviceInfo deviceInfo) { this.deviceInfo = deviceInfo; return this; }
    public Builder expires_in(Integer expires_in) { this.expires_in = expires_in; return this; }
    public Builder pendingIdPLink(PendingIdPLink pendingIdPLink) { this.pendingIdPLink = pendingIdPLink; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder user_code(String user_code) { this.user_code = user_code; return this; }
    public DeviceUserCodeResponse build() { return new DeviceUserCodeResponse(client_id, deviceInfo, expires_in, pendingIdPLink, scope, tenantId, user_code); }
  }
}
