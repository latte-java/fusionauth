/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordlessLoginRequestJSON;

@JSON
public record PasswordlessLoginRequest(
    String code,
    String oneTimeCode,
    String twoFactorTrustId,
    UUID applicationId,
    String ipAddress,
    MetaData metaData,
    Boolean newDevice,
    Boolean noJWT) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordlessLoginRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PasswordlessLoginRequestJSON.toJSONBytes(this);
  }

  public static PasswordlessLoginRequest fromJSON(String json) {
    return PasswordlessLoginRequestJSON.fromJSON(json);
  }

  public static PasswordlessLoginRequest fromJSONBytes(byte[] json) {
    return PasswordlessLoginRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private String oneTimeCode;
    private String twoFactorTrustId;
    private UUID applicationId;
    private String ipAddress;
    private MetaData metaData;
    private Boolean newDevice;
    private Boolean noJWT;
    public Builder code(String code) { this.code = code; return this; }
    public Builder oneTimeCode(String oneTimeCode) { this.oneTimeCode = oneTimeCode; return this; }
    public Builder twoFactorTrustId(String twoFactorTrustId) { this.twoFactorTrustId = twoFactorTrustId; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder newDevice(Boolean newDevice) { this.newDevice = newDevice; return this; }
    public Builder noJWT(Boolean noJWT) { this.noJWT = noJWT; return this; }
    public PasswordlessLoginRequest build() { return new PasswordlessLoginRequest(code, oneTimeCode, twoFactorTrustId, applicationId, ipAddress, metaData, newDevice, noJWT); }
  }
}
