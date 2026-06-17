/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationWebAuthnConfigurationJSON;

@JSON
public record ApplicationWebAuthnConfiguration(
    ApplicationWebAuthnWorkflowConfiguration bootstrapWorkflow,
    ApplicationWebAuthnWorkflowConfiguration reauthenticationWorkflow,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationWebAuthnConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationWebAuthnConfigurationJSON.toJSONBytes(this);
  }
  
  public static ApplicationWebAuthnConfiguration fromJSON(String json) {
    return ApplicationWebAuthnConfigurationJSON.fromJSON(json);
  }
  
  public static ApplicationWebAuthnConfiguration fromJSONBytes(byte[] json) {
    return ApplicationWebAuthnConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private ApplicationWebAuthnWorkflowConfiguration bootstrapWorkflow;
    private ApplicationWebAuthnWorkflowConfiguration reauthenticationWorkflow;
    private Boolean enabled;
    public Builder bootstrapWorkflow(ApplicationWebAuthnWorkflowConfiguration bootstrapWorkflow) { this.bootstrapWorkflow = bootstrapWorkflow; return this; }
    public Builder reauthenticationWorkflow(ApplicationWebAuthnWorkflowConfiguration reauthenticationWorkflow) { this.reauthenticationWorkflow = reauthenticationWorkflow; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public ApplicationWebAuthnConfiguration build() { return new ApplicationWebAuthnConfiguration(bootstrapWorkflow, reauthenticationWorkflow, enabled); }
  }
}
