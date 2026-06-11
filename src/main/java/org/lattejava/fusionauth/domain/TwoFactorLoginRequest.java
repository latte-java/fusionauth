/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorLoginRequestJSON;

@JSON
public record TwoFactorLoginRequest(
    String code,
    Boolean trustComputer,
    String twoFactorId,
    UUID userId,
    UUID applicationId,
    String ipAddress,
    MetaData metaData,
    Boolean newDevice,
    Boolean noJWT) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorLoginRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwoFactorLoginRequestJSON.toJSONBytes(this);
  }

  public static TwoFactorLoginRequest fromJSON(String json) {
    return TwoFactorLoginRequestJSON.fromJSON(json);
  }

  public static TwoFactorLoginRequest fromJSONBytes(byte[] json) {
    return TwoFactorLoginRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private Boolean trustComputer;
    private String twoFactorId;
    private UUID userId;
    private UUID applicationId;
    private String ipAddress;
    private MetaData metaData;
    private Boolean newDevice;
    private Boolean noJWT;
    public Builder code(String code) { this.code = code; return this; }
    public Builder trustComputer(Boolean trustComputer) { this.trustComputer = trustComputer; return this; }
    public Builder twoFactorId(String twoFactorId) { this.twoFactorId = twoFactorId; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder newDevice(Boolean newDevice) { this.newDevice = newDevice; return this; }
    public Builder noJWT(Boolean noJWT) { this.noJWT = noJWT; return this; }
    public TwoFactorLoginRequest build() { return new TwoFactorLoginRequest(code, trustComputer, twoFactorId, userId, applicationId, ipAddress, metaData, newDevice, noJWT); }
  }
}
