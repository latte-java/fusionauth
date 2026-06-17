/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2AssertionEncryptionConfigurationJSON;

@JSON
public record SAMLv2AssertionEncryptionConfiguration(
    String digestAlgorithm,
    String encryptionAlgorithm,
    String keyLocation,
    String keyTransportAlgorithm,
    UUID keyTransportEncryptionKeyId,
    String maskGenerationFunction,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2AssertionEncryptionConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SAMLv2AssertionEncryptionConfigurationJSON.toJSONBytes(this);
  }
  
  public static SAMLv2AssertionEncryptionConfiguration fromJSON(String json) {
    return SAMLv2AssertionEncryptionConfigurationJSON.fromJSON(json);
  }
  
  public static SAMLv2AssertionEncryptionConfiguration fromJSONBytes(byte[] json) {
    return SAMLv2AssertionEncryptionConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String digestAlgorithm;
    private String encryptionAlgorithm;
    private String keyLocation;
    private String keyTransportAlgorithm;
    private UUID keyTransportEncryptionKeyId;
    private String maskGenerationFunction;
    private Boolean enabled;
    public Builder digestAlgorithm(String digestAlgorithm) { this.digestAlgorithm = digestAlgorithm; return this; }
    public Builder encryptionAlgorithm(String encryptionAlgorithm) { this.encryptionAlgorithm = encryptionAlgorithm; return this; }
    public Builder keyLocation(String keyLocation) { this.keyLocation = keyLocation; return this; }
    public Builder keyTransportAlgorithm(String keyTransportAlgorithm) { this.keyTransportAlgorithm = keyTransportAlgorithm; return this; }
    public Builder keyTransportEncryptionKeyId(UUID keyTransportEncryptionKeyId) { this.keyTransportEncryptionKeyId = keyTransportEncryptionKeyId; return this; }
    public Builder maskGenerationFunction(String maskGenerationFunction) { this.maskGenerationFunction = maskGenerationFunction; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public SAMLv2AssertionEncryptionConfiguration build() { return new SAMLv2AssertionEncryptionConfiguration(digestAlgorithm, encryptionAlgorithm, keyLocation, keyTransportAlgorithm, keyTransportEncryptionKeyId, maskGenerationFunction, enabled); }
  }
}
