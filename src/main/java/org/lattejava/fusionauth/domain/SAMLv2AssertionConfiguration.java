/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2AssertionConfigurationJSON;

@JSON
public record SAMLv2AssertionConfiguration(
    SAMLv2DestinationAssertionConfiguration destination) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2AssertionConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SAMLv2AssertionConfigurationJSON.toJSONBytes(this);
  }

  public static SAMLv2AssertionConfiguration fromJSON(String json) {
    return SAMLv2AssertionConfigurationJSON.fromJSON(json);
  }

  public static SAMLv2AssertionConfiguration fromJSONBytes(byte[] json) {
    return SAMLv2AssertionConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private SAMLv2DestinationAssertionConfiguration destination;
    public Builder destination(SAMLv2DestinationAssertionConfiguration destination) { this.destination = destination; return this; }
    public SAMLv2AssertionConfiguration build() { return new SAMLv2AssertionConfiguration(destination); }
  }
}
