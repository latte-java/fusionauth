/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderStartLoginRequestJSON;

@JSON
public record IdentityProviderStartLoginRequest(
    String connectionTestId,
    Map<String, String> data,
    UUID identityProviderId,
    String loginId,
    List<String> loginIdTypes,
    Map<String, Object> state,
    UUID applicationId,
    String ipAddress,
    MetaData metaData,
    Boolean newDevice,
    Boolean noJWT) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderStartLoginRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderStartLoginRequestJSON.toJSONBytes(this);
  }

  public static IdentityProviderStartLoginRequest fromJSON(String json) {
    return IdentityProviderStartLoginRequestJSON.fromJSON(json);
  }

  public static IdentityProviderStartLoginRequest fromJSONBytes(byte[] json) {
    return IdentityProviderStartLoginRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String connectionTestId;
    private Map<String, String> data;
    private UUID identityProviderId;
    private String loginId;
    private List<String> loginIdTypes;
    private Map<String, Object> state;
    private UUID applicationId;
    private String ipAddress;
    private MetaData metaData;
    private Boolean newDevice;
    private Boolean noJWT;
    public Builder connectionTestId(String connectionTestId) { this.connectionTestId = connectionTestId; return this; }
    public Builder data(Map<String, String> data) { this.data = data; return this; }
    public Builder identityProviderId(UUID identityProviderId) { this.identityProviderId = identityProviderId; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdTypes(List<String> loginIdTypes) { this.loginIdTypes = loginIdTypes; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder newDevice(Boolean newDevice) { this.newDevice = newDevice; return this; }
    public Builder noJWT(Boolean noJWT) { this.noJWT = noJWT; return this; }
    public IdentityProviderStartLoginRequest build() { return new IdentityProviderStartLoginRequest(connectionTestId, data, identityProviderId, loginId, loginIdTypes, state, applicationId, ipAddress, metaData, newDevice, noJWT); }
  }
}
