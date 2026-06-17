/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationWebAuthnWorkflowConfigurationJSON;

@JSON
public record ApplicationWebAuthnWorkflowConfiguration(
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationWebAuthnWorkflowConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationWebAuthnWorkflowConfigurationJSON.toJSONBytes(this);
  }
  
  public static ApplicationWebAuthnWorkflowConfiguration fromJSON(String json) {
    return ApplicationWebAuthnWorkflowConfigurationJSON.fromJSON(json);
  }
  
  public static ApplicationWebAuthnWorkflowConfiguration fromJSONBytes(byte[] json) {
    return ApplicationWebAuthnWorkflowConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean enabled;
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public ApplicationWebAuthnWorkflowConfiguration build() { return new ApplicationWebAuthnWorkflowConfiguration(enabled); }
  }
}
