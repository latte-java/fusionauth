/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2DestinationAssertionConfigurationJSON;

@JSON
public record SAMLv2DestinationAssertionConfiguration(
    List<String> alternates,
    SAMLv2DestinationAssertionPolicy policy) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2DestinationAssertionConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SAMLv2DestinationAssertionConfigurationJSON.toJSONBytes(this);
  }
  
  public static SAMLv2DestinationAssertionConfiguration fromJSON(String json) {
    return SAMLv2DestinationAssertionConfigurationJSON.fromJSON(json);
  }
  
  public static SAMLv2DestinationAssertionConfiguration fromJSONBytes(byte[] json) {
    return SAMLv2DestinationAssertionConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<String> alternates;
    private SAMLv2DestinationAssertionPolicy policy;
    public Builder alternates(List<String> alternates) { this.alternates = alternates; return this; }
    public Builder policy(SAMLv2DestinationAssertionPolicy policy) { this.policy = policy; return this; }
    public SAMLv2DestinationAssertionConfiguration build() { return new SAMLv2DestinationAssertionConfiguration(alternates, policy); }
  }
}
