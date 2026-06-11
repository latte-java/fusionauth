/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2IdPInitiatedIdentityProviderJSON;

@JSON
@JSONSubtype("SAMLv2IdPInitiated")
public record SAMLv2IdPInitiatedIdentityProvider(
    String issuer,
    SAMLv2AssertionDecryptionConfiguration assertionDecryptionConfiguration,
    String emailClaim,
    UUID keyId,
    String uniqueIdClaim,
    Boolean useNameIdForEmail,
    String usernameClaim) implements IdentityProviderField {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2IdPInitiatedIdentityProviderJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SAMLv2IdPInitiatedIdentityProviderJSON.toJSONBytes(this);
  }

  public static SAMLv2IdPInitiatedIdentityProvider fromJSON(String json) {
    return SAMLv2IdPInitiatedIdentityProviderJSON.fromJSON(json);
  }

  public static SAMLv2IdPInitiatedIdentityProvider fromJSONBytes(byte[] json) {
    return SAMLv2IdPInitiatedIdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    private String issuer;
    private SAMLv2AssertionDecryptionConfiguration assertionDecryptionConfiguration;
    private String emailClaim;
    private UUID keyId;
    private String uniqueIdClaim;
    private Boolean useNameIdForEmail;
    private String usernameClaim;
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder assertionDecryptionConfiguration(SAMLv2AssertionDecryptionConfiguration assertionDecryptionConfiguration) { this.assertionDecryptionConfiguration = assertionDecryptionConfiguration; return this; }
    public Builder emailClaim(String emailClaim) { this.emailClaim = emailClaim; return this; }
    public Builder keyId(UUID keyId) { this.keyId = keyId; return this; }
    public Builder uniqueIdClaim(String uniqueIdClaim) { this.uniqueIdClaim = uniqueIdClaim; return this; }
    public Builder useNameIdForEmail(Boolean useNameIdForEmail) { this.useNameIdForEmail = useNameIdForEmail; return this; }
    public Builder usernameClaim(String usernameClaim) { this.usernameClaim = usernameClaim; return this; }
    public SAMLv2IdPInitiatedIdentityProvider build() { return new SAMLv2IdPInitiatedIdentityProvider(issuer, assertionDecryptionConfiguration, emailClaim, keyId, uniqueIdClaim, useNameIdForEmail, usernameClaim); }
  }
}
