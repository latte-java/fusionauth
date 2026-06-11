/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantWebAuthnWorkflowConfigurationJSON;

@JSON
public record TenantWebAuthnWorkflowConfiguration(
    AuthenticatorAttachmentPreference authenticatorAttachmentPreference,
    UserVerificationRequirement userVerificationRequirement,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantWebAuthnWorkflowConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantWebAuthnWorkflowConfigurationJSON.toJSONBytes(this);
  }

  public static TenantWebAuthnWorkflowConfiguration fromJSON(String json) {
    return TenantWebAuthnWorkflowConfigurationJSON.fromJSON(json);
  }

  public static TenantWebAuthnWorkflowConfiguration fromJSONBytes(byte[] json) {
    return TenantWebAuthnWorkflowConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuthenticatorAttachmentPreference authenticatorAttachmentPreference;
    private UserVerificationRequirement userVerificationRequirement;
    private Boolean enabled;
    public Builder authenticatorAttachmentPreference(AuthenticatorAttachmentPreference authenticatorAttachmentPreference) { this.authenticatorAttachmentPreference = authenticatorAttachmentPreference; return this; }
    public Builder userVerificationRequirement(UserVerificationRequirement userVerificationRequirement) { this.userVerificationRequirement = userVerificationRequirement; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public TenantWebAuthnWorkflowConfiguration build() { return new TenantWebAuthnWorkflowConfiguration(authenticatorAttachmentPreference, userVerificationRequirement, enabled); }
  }
}
