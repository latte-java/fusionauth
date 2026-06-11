/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PublicKeyCredentialRequestOptionsJSON;

@JSON
public record PublicKeyCredentialRequestOptions(
    List<PublicKeyCredentialDescriptor> allowCredentials,
    String challenge,
    String rpId,
    Long timeout,
    UserVerificationRequirement userVerification) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PublicKeyCredentialRequestOptionsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PublicKeyCredentialRequestOptionsJSON.toJSONBytes(this);
  }

  public static PublicKeyCredentialRequestOptions fromJSON(String json) {
    return PublicKeyCredentialRequestOptionsJSON.fromJSON(json);
  }

  public static PublicKeyCredentialRequestOptions fromJSONBytes(byte[] json) {
    return PublicKeyCredentialRequestOptionsJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<PublicKeyCredentialDescriptor> allowCredentials;
    private String challenge;
    private String rpId;
    private Long timeout;
    private UserVerificationRequirement userVerification;
    public Builder allowCredentials(List<PublicKeyCredentialDescriptor> allowCredentials) { this.allowCredentials = allowCredentials; return this; }
    public Builder challenge(String challenge) { this.challenge = challenge; return this; }
    public Builder rpId(String rpId) { this.rpId = rpId; return this; }
    public Builder timeout(Long timeout) { this.timeout = timeout; return this; }
    public Builder userVerification(UserVerificationRequirement userVerification) { this.userVerification = userVerification; return this; }
    public PublicKeyCredentialRequestOptions build() { return new PublicKeyCredentialRequestOptions(allowCredentials, challenge, rpId, timeout, userVerification); }
  }
}
