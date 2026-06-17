/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginPingRequestJSON;

@JSON
public record LoginPingRequest(
    UUID userId,
    UUID applicationId,
    String ipAddress,
    MetaData metaData,
    Boolean newDevice,
    Boolean noJWT) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginPingRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginPingRequestJSON.toJSONBytes(this);
  }
  
  public static LoginPingRequest fromJSON(String json) {
    return LoginPingRequestJSON.fromJSON(json);
  }
  
  public static LoginPingRequest fromJSONBytes(byte[] json) {
    return LoginPingRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID userId;
    private UUID applicationId;
    private String ipAddress;
    private MetaData metaData;
    private Boolean newDevice;
    private Boolean noJWT;
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder newDevice(Boolean newDevice) { this.newDevice = newDevice; return this; }
    public Builder noJWT(Boolean noJWT) { this.noJWT = noJWT; return this; }
    public LoginPingRequest build() { return new LoginPingRequest(userId, applicationId, ipAddress, metaData, newDevice, noJWT); }
  }
}
