/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ExternalJWTApplicationConfigurationJSON;

@JSON
public record ExternalJWTApplicationConfiguration(
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ExternalJWTApplicationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ExternalJWTApplicationConfigurationJSON.toJSONBytes(this);
  }

  public static ExternalJWTApplicationConfiguration fromJSON(String json) {
    return ExternalJWTApplicationConfigurationJSON.fromJSON(json);
  }

  public static ExternalJWTApplicationConfiguration fromJSONBytes(byte[] json) {
    return ExternalJWTApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public ExternalJWTApplicationConfiguration build() { return new ExternalJWTApplicationConfiguration(data, createRegistration); }
  }
}
