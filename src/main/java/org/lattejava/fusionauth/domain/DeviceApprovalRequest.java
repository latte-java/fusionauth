/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DeviceApprovalRequestJSON;

@JSON
public record DeviceApprovalRequest(
    String client_id,
    String client_secret,
    UUID tenantId,
    String token,
    String user_code) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DeviceApprovalRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return DeviceApprovalRequestJSON.toJSONBytes(this);
  }
  
  public static DeviceApprovalRequest fromJSON(String json) {
    return DeviceApprovalRequestJSON.fromJSON(json);
  }
  
  public static DeviceApprovalRequest fromJSONBytes(byte[] json) {
    return DeviceApprovalRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String client_secret;
    private UUID tenantId;
    private String token;
    private String user_code;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder token(String token) { this.token = token; return this; }
    public Builder user_code(String user_code) { this.user_code = user_code; return this; }
    public DeviceApprovalRequest build() { return new DeviceApprovalRequest(client_id, client_secret, tenantId, token, user_code); }
  }
}
