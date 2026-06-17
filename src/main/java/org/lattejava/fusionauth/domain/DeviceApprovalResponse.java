/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DeviceApprovalResponseJSON;

@JSON
public record DeviceApprovalResponse(
    String deviceGrantStatus,
    DeviceInfo deviceInfo,
    IdentityProviderLink identityProviderLink,
    UUID tenantId,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DeviceApprovalResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return DeviceApprovalResponseJSON.toJSONBytes(this);
  }
  
  public static DeviceApprovalResponse fromJSON(String json) {
    return DeviceApprovalResponseJSON.fromJSON(json);
  }
  
  public static DeviceApprovalResponse fromJSONBytes(byte[] json) {
    return DeviceApprovalResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String deviceGrantStatus;
    private DeviceInfo deviceInfo;
    private IdentityProviderLink identityProviderLink;
    private UUID tenantId;
    private UUID userId;
    public Builder deviceGrantStatus(String deviceGrantStatus) { this.deviceGrantStatus = deviceGrantStatus; return this; }
    public Builder deviceInfo(DeviceInfo deviceInfo) { this.deviceInfo = deviceInfo; return this; }
    public Builder identityProviderLink(IdentityProviderLink identityProviderLink) { this.identityProviderLink = identityProviderLink; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public DeviceApprovalResponse build() { return new DeviceApprovalResponse(deviceGrantStatus, deviceInfo, identityProviderLink, tenantId, userId); }
  }
}
