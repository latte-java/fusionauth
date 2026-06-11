/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IntegrationRequestJSON;

@JSON
public record IntegrationRequest(
    Integrations integrations) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IntegrationRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IntegrationRequestJSON.toJSONBytes(this);
  }

  public static IntegrationRequest fromJSON(String json) {
    return IntegrationRequestJSON.fromJSON(json);
  }

  public static IntegrationRequest fromJSONBytes(byte[] json) {
    return IntegrationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integrations integrations;
    public Builder integrations(Integrations integrations) { this.integrations = integrations; return this; }
    public IntegrationRequest build() { return new IntegrationRequest(integrations); }
  }
}
