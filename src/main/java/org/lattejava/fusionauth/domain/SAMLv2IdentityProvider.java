/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2IdentityProviderJSON;

@JSON
@JSONSubtype("SAMLv2")
public record SAMLv2IdentityProvider(
    Set<String> domains,
    SAMLv2AssertionConfiguration assertionConfiguration,
    String buttonImageURL,
    String buttonText,
    String idpEndpoint,
    SAMLv2IdpInitiatedConfiguration idpInitiatedConfiguration,
    String issuer,
    LoginHintConfiguration loginHintConfiguration,
    String nameIdFormat,
    Boolean postRequest,
    UUID requestSigningKeyId,
    Boolean signRequest,
    CanonicalizationMethod xmlSignatureC14nMethod,
    SAMLv2AssertionDecryptionConfiguration assertionDecryptionConfiguration,
    String emailClaim,
    UUID keyId,
    String uniqueIdClaim,
    Boolean useNameIdForEmail,
    String usernameClaim) implements IdentityProviderField {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2IdentityProviderJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SAMLv2IdentityProviderJSON.toJSONBytes(this);
  }

  public static SAMLv2IdentityProvider fromJSON(String json) {
    return SAMLv2IdentityProviderJSON.fromJSON(json);
  }

  public static SAMLv2IdentityProvider fromJSONBytes(byte[] json) {
    return SAMLv2IdentityProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    private Set<String> domains;
    private SAMLv2AssertionConfiguration assertionConfiguration;
    private String buttonImageURL;
    private String buttonText;
    private String idpEndpoint;
    private SAMLv2IdpInitiatedConfiguration idpInitiatedConfiguration;
    private String issuer;
    private LoginHintConfiguration loginHintConfiguration;
    private String nameIdFormat;
    private Boolean postRequest;
    private UUID requestSigningKeyId;
    private Boolean signRequest;
    private CanonicalizationMethod xmlSignatureC14nMethod;
    private SAMLv2AssertionDecryptionConfiguration assertionDecryptionConfiguration;
    private String emailClaim;
    private UUID keyId;
    private String uniqueIdClaim;
    private Boolean useNameIdForEmail;
    private String usernameClaim;
    public Builder domains(Set<String> domains) { this.domains = domains; return this; }
    public Builder assertionConfiguration(SAMLv2AssertionConfiguration assertionConfiguration) { this.assertionConfiguration = assertionConfiguration; return this; }
    public Builder buttonImageURL(String buttonImageURL) { this.buttonImageURL = buttonImageURL; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder idpEndpoint(String idpEndpoint) { this.idpEndpoint = idpEndpoint; return this; }
    public Builder idpInitiatedConfiguration(SAMLv2IdpInitiatedConfiguration idpInitiatedConfiguration) { this.idpInitiatedConfiguration = idpInitiatedConfiguration; return this; }
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder loginHintConfiguration(LoginHintConfiguration loginHintConfiguration) { this.loginHintConfiguration = loginHintConfiguration; return this; }
    public Builder nameIdFormat(String nameIdFormat) { this.nameIdFormat = nameIdFormat; return this; }
    public Builder postRequest(Boolean postRequest) { this.postRequest = postRequest; return this; }
    public Builder requestSigningKeyId(UUID requestSigningKeyId) { this.requestSigningKeyId = requestSigningKeyId; return this; }
    public Builder signRequest(Boolean signRequest) { this.signRequest = signRequest; return this; }
    public Builder xmlSignatureC14nMethod(CanonicalizationMethod xmlSignatureC14nMethod) { this.xmlSignatureC14nMethod = xmlSignatureC14nMethod; return this; }
    public Builder assertionDecryptionConfiguration(SAMLv2AssertionDecryptionConfiguration assertionDecryptionConfiguration) { this.assertionDecryptionConfiguration = assertionDecryptionConfiguration; return this; }
    public Builder emailClaim(String emailClaim) { this.emailClaim = emailClaim; return this; }
    public Builder keyId(UUID keyId) { this.keyId = keyId; return this; }
    public Builder uniqueIdClaim(String uniqueIdClaim) { this.uniqueIdClaim = uniqueIdClaim; return this; }
    public Builder useNameIdForEmail(Boolean useNameIdForEmail) { this.useNameIdForEmail = useNameIdForEmail; return this; }
    public Builder usernameClaim(String usernameClaim) { this.usernameClaim = usernameClaim; return this; }
    public SAMLv2IdentityProvider build() { return new SAMLv2IdentityProvider(domains, assertionConfiguration, buttonImageURL, buttonText, idpEndpoint, idpInitiatedConfiguration, issuer, loginHintConfiguration, nameIdFormat, postRequest, requestSigningKeyId, signRequest, xmlSignatureC14nMethod, assertionDecryptionConfiguration, emailClaim, keyId, uniqueIdClaim, useNameIdForEmail, usernameClaim); }
  }
}
