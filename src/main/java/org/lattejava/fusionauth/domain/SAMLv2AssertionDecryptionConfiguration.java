/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2AssertionDecryptionConfigurationJSON;

@JSON
public record SAMLv2AssertionDecryptionConfiguration(
    UUID keyTransportDecryptionKeyId,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2AssertionDecryptionConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SAMLv2AssertionDecryptionConfigurationJSON.toJSONBytes(this);
  }

  public static SAMLv2AssertionDecryptionConfiguration fromJSON(String json) {
    return SAMLv2AssertionDecryptionConfigurationJSON.fromJSON(json);
  }

  public static SAMLv2AssertionDecryptionConfiguration fromJSONBytes(byte[] json) {
    return SAMLv2AssertionDecryptionConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID keyTransportDecryptionKeyId;
    private Boolean enabled;
    public Builder keyTransportDecryptionKeyId(UUID keyTransportDecryptionKeyId) { this.keyTransportDecryptionKeyId = keyTransportDecryptionKeyId; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public SAMLv2AssertionDecryptionConfiguration build() { return new SAMLv2AssertionDecryptionConfiguration(keyTransportDecryptionKeyId, enabled); }
  }
}
