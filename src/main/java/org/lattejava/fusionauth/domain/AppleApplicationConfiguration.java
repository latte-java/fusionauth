/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AppleApplicationConfigurationJSON;

@JSON
public record AppleApplicationConfiguration(
    String bundleId,
    String buttonText,
    UUID keyId,
    String scope,
    String servicesId,
    String teamId,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AppleApplicationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AppleApplicationConfigurationJSON.toJSONBytes(this);
  }

  public static AppleApplicationConfiguration fromJSON(String json) {
    return AppleApplicationConfigurationJSON.fromJSON(json);
  }

  public static AppleApplicationConfiguration fromJSONBytes(byte[] json) {
    return AppleApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String bundleId;
    private String buttonText;
    private UUID keyId;
    private String scope;
    private String servicesId;
    private String teamId;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder bundleId(String bundleId) { this.bundleId = bundleId; return this; }
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder keyId(UUID keyId) { this.keyId = keyId; return this; }
    public Builder scope(String scope) { this.scope = scope; return this; }
    public Builder servicesId(String servicesId) { this.servicesId = servicesId; return this; }
    public Builder teamId(String teamId) { this.teamId = teamId; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public AppleApplicationConfiguration build() { return new AppleApplicationConfiguration(bundleId, buttonText, keyId, scope, servicesId, teamId, data, createRegistration); }
  }
}
