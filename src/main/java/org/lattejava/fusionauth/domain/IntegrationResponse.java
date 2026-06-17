/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IntegrationResponseJSON;

@JSON
public record IntegrationResponse(
    Integrations integrations) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IntegrationResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IntegrationResponseJSON.toJSONBytes(this);
  }
  
  public static IntegrationResponse fromJSON(String json) {
    return IntegrationResponseJSON.fromJSON(json);
  }
  
  public static IntegrationResponse fromJSONBytes(byte[] json) {
    return IntegrationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integrations integrations;
    public Builder integrations(Integrations integrations) { this.integrations = integrations; return this; }
    public IntegrationResponse build() { return new IntegrationResponse(integrations); }
  }
}
