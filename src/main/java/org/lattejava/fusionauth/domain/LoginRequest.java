/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginRequestJSON;

@JSON
public record LoginRequest(
    String loginId,
    List<String> loginIdTypes,
    String oneTimePassword,
    String password,
    String twoFactorTrustId,
    UUID applicationId,
    String ipAddress,
    MetaData metaData,
    Boolean newDevice,
    Boolean noJWT) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LoginRequestJSON.toJSONBytes(this);
  }

  public static LoginRequest fromJSON(String json) {
    return LoginRequestJSON.fromJSON(json);
  }

  public static LoginRequest fromJSONBytes(byte[] json) {
    return LoginRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String loginId;
    private List<String> loginIdTypes;
    private String oneTimePassword;
    private String password;
    private String twoFactorTrustId;
    private UUID applicationId;
    private String ipAddress;
    private MetaData metaData;
    private Boolean newDevice;
    private Boolean noJWT;
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdTypes(List<String> loginIdTypes) { this.loginIdTypes = loginIdTypes; return this; }
    public Builder oneTimePassword(String oneTimePassword) { this.oneTimePassword = oneTimePassword; return this; }
    public Builder password(String password) { this.password = password; return this; }
    public Builder twoFactorTrustId(String twoFactorTrustId) { this.twoFactorTrustId = twoFactorTrustId; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder newDevice(Boolean newDevice) { this.newDevice = newDevice; return this; }
    public Builder noJWT(Boolean noJWT) { this.noJWT = noJWT; return this; }
    public LoginRequest build() { return new LoginRequest(loginId, loginIdTypes, oneTimePassword, password, twoFactorTrustId, applicationId, ipAddress, metaData, newDevice, noJWT); }
  }
}
