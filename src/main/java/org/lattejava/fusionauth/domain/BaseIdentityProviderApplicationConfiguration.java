/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseIdentityProviderApplicationConfigurationJSON;

@JSON
public record BaseIdentityProviderApplicationConfiguration(
    Map<String, Object> data,
    Boolean createRegistration,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseIdentityProviderApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return BaseIdentityProviderApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static BaseIdentityProviderApplicationConfiguration fromJSON(String json) {
    return BaseIdentityProviderApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static BaseIdentityProviderApplicationConfiguration fromJSONBytes(byte[] json) {
    return BaseIdentityProviderApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private Boolean createRegistration;
    private Boolean enabled;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public BaseIdentityProviderApplicationConfiguration build() { return new BaseIdentityProviderApplicationConfiguration(data, createRegistration, enabled); }
  }
}
