/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.HYPRApplicationConfigurationJSON;

@JSON
public record HYPRApplicationConfiguration(
    String relyingPartyApplicationId,
    String relyingPartyURL,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return HYPRApplicationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return HYPRApplicationConfigurationJSON.toJSONBytes(this);
  }

  public static HYPRApplicationConfiguration fromJSON(String json) {
    return HYPRApplicationConfigurationJSON.fromJSON(json);
  }

  public static HYPRApplicationConfiguration fromJSONBytes(byte[] json) {
    return HYPRApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String relyingPartyApplicationId;
    private String relyingPartyURL;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder relyingPartyApplicationId(String relyingPartyApplicationId) { this.relyingPartyApplicationId = relyingPartyApplicationId; return this; }
    public Builder relyingPartyURL(String relyingPartyURL) { this.relyingPartyURL = relyingPartyURL; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public HYPRApplicationConfiguration build() { return new HYPRApplicationConfiguration(relyingPartyApplicationId, relyingPartyURL, data, createRegistration); }
  }
}
