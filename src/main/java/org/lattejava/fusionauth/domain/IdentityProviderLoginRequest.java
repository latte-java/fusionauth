/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderLoginRequestJSON;

@JSON
public record IdentityProviderLoginRequest(
    String connectionTestId,
    Map<String, String> data,
    UUID identityProviderId,
    Boolean noLink,
    String encodedJWT,
    UUID applicationId,
    String ipAddress,
    MetaData metaData,
    Boolean newDevice,
    Boolean noJWT) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderLoginRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderLoginRequestJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderLoginRequest fromJSON(String json) {
    return IdentityProviderLoginRequestJSON.fromJSON(json);
  }
  
  public static IdentityProviderLoginRequest fromJSONBytes(byte[] json) {
    return IdentityProviderLoginRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String connectionTestId;
    private Map<String, String> data;
    private UUID identityProviderId;
    private Boolean noLink;
    private String encodedJWT;
    private UUID applicationId;
    private String ipAddress;
    private MetaData metaData;
    private Boolean newDevice;
    private Boolean noJWT;
    public Builder connectionTestId(String connectionTestId) { this.connectionTestId = connectionTestId; return this; }
    public Builder data(Map<String, String> data) { this.data = data; return this; }
    public Builder identityProviderId(UUID identityProviderId) { this.identityProviderId = identityProviderId; return this; }
    public Builder noLink(Boolean noLink) { this.noLink = noLink; return this; }
    public Builder encodedJWT(String encodedJWT) { this.encodedJWT = encodedJWT; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder newDevice(Boolean newDevice) { this.newDevice = newDevice; return this; }
    public Builder noJWT(Boolean noJWT) { this.noJWT = noJWT; return this; }
    public IdentityProviderLoginRequest build() { return new IdentityProviderLoginRequest(connectionTestId, data, identityProviderId, noLink, encodedJWT, applicationId, ipAddress, metaData, newDevice, noJWT); }
  }
}
