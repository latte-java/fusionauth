/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnLoginRequestJSON;

@JSON
public record WebAuthnLoginRequest(
    WebAuthnPublicKeyAuthenticationRequest credential,
    String origin,
    String rpId,
    String twoFactorTrustId,
    UUID applicationId,
    String ipAddress,
    MetaData metaData,
    Boolean newDevice,
    Boolean noJWT) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnLoginRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnLoginRequestJSON.toJSONBytes(this);
  }
  
  public static WebAuthnLoginRequest fromJSON(String json) {
    return WebAuthnLoginRequestJSON.fromJSON(json);
  }
  
  public static WebAuthnLoginRequest fromJSONBytes(byte[] json) {
    return WebAuthnLoginRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private WebAuthnPublicKeyAuthenticationRequest credential;
    private String origin;
    private String rpId;
    private String twoFactorTrustId;
    private UUID applicationId;
    private String ipAddress;
    private MetaData metaData;
    private Boolean newDevice;
    private Boolean noJWT;
    public Builder credential(WebAuthnPublicKeyAuthenticationRequest credential) { this.credential = credential; return this; }
    public Builder origin(String origin) { this.origin = origin; return this; }
    public Builder rpId(String rpId) { this.rpId = rpId; return this; }
    public Builder twoFactorTrustId(String twoFactorTrustId) { this.twoFactorTrustId = twoFactorTrustId; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder newDevice(Boolean newDevice) { this.newDevice = newDevice; return this; }
    public Builder noJWT(Boolean noJWT) { this.noJWT = noJWT; return this; }
    public WebAuthnLoginRequest build() { return new WebAuthnLoginRequest(credential, origin, rpId, twoFactorTrustId, applicationId, ipAddress, metaData, newDevice, noJWT); }
  }
}
