/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserLoginNewDeviceEventJSON;

@JSON
public record UserLoginNewDeviceEvent(
    UUID applicationId,
    String authenticationType,
    UUID connectorId,
    UUID identityProviderId,
    String identityProviderName,
    String ipAddress) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserLoginNewDeviceEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserLoginNewDeviceEventJSON.toJSONBytes(this);
  }
  
  public static UserLoginNewDeviceEvent fromJSON(String json) {
    return UserLoginNewDeviceEventJSON.fromJSON(json);
  }
  
  public static UserLoginNewDeviceEvent fromJSONBytes(byte[] json) {
    return UserLoginNewDeviceEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String authenticationType;
    private UUID connectorId;
    private UUID identityProviderId;
    private String identityProviderName;
    private String ipAddress;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder authenticationType(String authenticationType) { this.authenticationType = authenticationType; return this; }
    public Builder connectorId(UUID connectorId) { this.connectorId = connectorId; return this; }
    public Builder identityProviderId(UUID identityProviderId) { this.identityProviderId = identityProviderId; return this; }
    public Builder identityProviderName(String identityProviderName) { this.identityProviderName = identityProviderName; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public UserLoginNewDeviceEvent build() { return new UserLoginNewDeviceEvent(applicationId, authenticationType, connectorId, identityProviderId, identityProviderName, ipAddress); }
  }
}
