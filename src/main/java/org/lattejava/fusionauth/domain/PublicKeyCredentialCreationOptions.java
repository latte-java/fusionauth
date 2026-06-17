/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PublicKeyCredentialCreationOptionsJSON;

@JSON
public record PublicKeyCredentialCreationOptions(
    AttestationConveyancePreference attestation,
    AuthenticatorSelectionCriteria authenticatorSelection,
    String challenge,
    List<PublicKeyCredentialDescriptor> excludeCredentials,
    WebAuthnRegistrationExtensionOptions extensions,
    List<PublicKeyCredentialParameters> pubKeyCredParams,
    PublicKeyCredentialRelyingPartyEntity rp,
    Long timeout,
    PublicKeyCredentialUserEntity user) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PublicKeyCredentialCreationOptionsJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PublicKeyCredentialCreationOptionsJSON.toJSONBytes(this);
  }
  
  public static PublicKeyCredentialCreationOptions fromJSON(String json) {
    return PublicKeyCredentialCreationOptionsJSON.fromJSON(json);
  }
  
  public static PublicKeyCredentialCreationOptions fromJSONBytes(byte[] json) {
    return PublicKeyCredentialCreationOptionsJSON.fromJSON(json);
  }

  public static final class Builder {
    private AttestationConveyancePreference attestation;
    private AuthenticatorSelectionCriteria authenticatorSelection;
    private String challenge;
    private List<PublicKeyCredentialDescriptor> excludeCredentials;
    private WebAuthnRegistrationExtensionOptions extensions;
    private List<PublicKeyCredentialParameters> pubKeyCredParams;
    private PublicKeyCredentialRelyingPartyEntity rp;
    private Long timeout;
    private PublicKeyCredentialUserEntity user;
    public Builder attestation(AttestationConveyancePreference attestation) { this.attestation = attestation; return this; }
    public Builder authenticatorSelection(AuthenticatorSelectionCriteria authenticatorSelection) { this.authenticatorSelection = authenticatorSelection; return this; }
    public Builder challenge(String challenge) { this.challenge = challenge; return this; }
    public Builder excludeCredentials(List<PublicKeyCredentialDescriptor> excludeCredentials) { this.excludeCredentials = excludeCredentials; return this; }
    public Builder extensions(WebAuthnRegistrationExtensionOptions extensions) { this.extensions = extensions; return this; }
    public Builder pubKeyCredParams(List<PublicKeyCredentialParameters> pubKeyCredParams) { this.pubKeyCredParams = pubKeyCredParams; return this; }
    public Builder rp(PublicKeyCredentialRelyingPartyEntity rp) { this.rp = rp; return this; }
    public Builder timeout(Long timeout) { this.timeout = timeout; return this; }
    public Builder user(PublicKeyCredentialUserEntity user) { this.user = user; return this; }
    public PublicKeyCredentialCreationOptions build() { return new PublicKeyCredentialCreationOptions(attestation, authenticatorSelection, challenge, excludeCredentials, extensions, pubKeyCredParams, rp, timeout, user); }
  }
}
