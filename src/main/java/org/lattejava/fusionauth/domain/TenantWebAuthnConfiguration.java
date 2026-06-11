/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantWebAuthnConfigurationJSON;

@JSON
public record TenantWebAuthnConfiguration(
    TenantWebAuthnWorkflowConfiguration bootstrapWorkflow,
    Boolean debug,
    TenantWebAuthnWorkflowConfiguration reauthenticationWorkflow,
    String relyingPartyId,
    String relyingPartyName,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantWebAuthnConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantWebAuthnConfigurationJSON.toJSONBytes(this);
  }

  public static TenantWebAuthnConfiguration fromJSON(String json) {
    return TenantWebAuthnConfigurationJSON.fromJSON(json);
  }

  public static TenantWebAuthnConfiguration fromJSONBytes(byte[] json) {
    return TenantWebAuthnConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private TenantWebAuthnWorkflowConfiguration bootstrapWorkflow;
    private Boolean debug;
    private TenantWebAuthnWorkflowConfiguration reauthenticationWorkflow;
    private String relyingPartyId;
    private String relyingPartyName;
    private Boolean enabled;
    public Builder bootstrapWorkflow(TenantWebAuthnWorkflowConfiguration bootstrapWorkflow) { this.bootstrapWorkflow = bootstrapWorkflow; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder reauthenticationWorkflow(TenantWebAuthnWorkflowConfiguration reauthenticationWorkflow) { this.reauthenticationWorkflow = reauthenticationWorkflow; return this; }
    public Builder relyingPartyId(String relyingPartyId) { this.relyingPartyId = relyingPartyId; return this; }
    public Builder relyingPartyName(String relyingPartyName) { this.relyingPartyName = relyingPartyName; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public TenantWebAuthnConfiguration build() { return new TenantWebAuthnConfiguration(bootstrapWorkflow, debug, reauthenticationWorkflow, relyingPartyId, relyingPartyName, enabled); }
  }
}
