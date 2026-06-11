/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserLoginSuspiciousEventJSON;

@JSON
public record UserLoginSuspiciousEvent(
    Set<String> threatsDetected,
    UUID applicationId,
    String authenticationType,
    UUID connectorId,
    UUID identityProviderId,
    String identityProviderName,
    String ipAddress) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserLoginSuspiciousEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserLoginSuspiciousEventJSON.toJSONBytes(this);
  }

  public static UserLoginSuspiciousEvent fromJSON(String json) {
    return UserLoginSuspiciousEventJSON.fromJSON(json);
  }

  public static UserLoginSuspiciousEvent fromJSONBytes(byte[] json) {
    return UserLoginSuspiciousEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private Set<String> threatsDetected;
    private UUID applicationId;
    private String authenticationType;
    private UUID connectorId;
    private UUID identityProviderId;
    private String identityProviderName;
    private String ipAddress;
    public Builder threatsDetected(Set<String> threatsDetected) { this.threatsDetected = threatsDetected; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder authenticationType(String authenticationType) { this.authenticationType = authenticationType; return this; }
    public Builder connectorId(UUID connectorId) { this.connectorId = connectorId; return this; }
    public Builder identityProviderId(UUID identityProviderId) { this.identityProviderId = identityProviderId; return this; }
    public Builder identityProviderName(String identityProviderName) { this.identityProviderName = identityProviderName; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public UserLoginSuspiciousEvent build() { return new UserLoginSuspiciousEvent(threatsDetected, applicationId, authenticationType, connectorId, identityProviderId, identityProviderName, ipAddress); }
  }
}
