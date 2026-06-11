/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuthenticatorSelectionCriteriaJSON;

@JSON
public record AuthenticatorSelectionCriteria(
    AuthenticatorAttachment authenticatorAttachment,
    Boolean requireResidentKey,
    ResidentKeyRequirement residentKey,
    UserVerificationRequirement userVerification) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuthenticatorSelectionCriteriaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AuthenticatorSelectionCriteriaJSON.toJSONBytes(this);
  }

  public static AuthenticatorSelectionCriteria fromJSON(String json) {
    return AuthenticatorSelectionCriteriaJSON.fromJSON(json);
  }

  public static AuthenticatorSelectionCriteria fromJSONBytes(byte[] json) {
    return AuthenticatorSelectionCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuthenticatorAttachment authenticatorAttachment;
    private Boolean requireResidentKey;
    private ResidentKeyRequirement residentKey;
    private UserVerificationRequirement userVerification;
    public Builder authenticatorAttachment(AuthenticatorAttachment authenticatorAttachment) { this.authenticatorAttachment = authenticatorAttachment; return this; }
    public Builder requireResidentKey(Boolean requireResidentKey) { this.requireResidentKey = requireResidentKey; return this; }
    public Builder residentKey(ResidentKeyRequirement residentKey) { this.residentKey = residentKey; return this; }
    public Builder userVerification(UserVerificationRequirement userVerification) { this.userVerification = userVerification; return this; }
    public AuthenticatorSelectionCriteria build() { return new AuthenticatorSelectionCriteria(authenticatorAttachment, requireResidentKey, residentKey, userVerification); }
  }
}
