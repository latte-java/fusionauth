/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordEncryptionConfigurationJSON;

@JSON
public record PasswordEncryptionConfiguration(
    String encryptionScheme,
    Integer encryptionSchemeFactor,
    Boolean modifyEncryptionSchemeOnLogin) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordEncryptionConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PasswordEncryptionConfigurationJSON.toJSONBytes(this);
  }

  public static PasswordEncryptionConfiguration fromJSON(String json) {
    return PasswordEncryptionConfigurationJSON.fromJSON(json);
  }

  public static PasswordEncryptionConfiguration fromJSONBytes(byte[] json) {
    return PasswordEncryptionConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String encryptionScheme;
    private Integer encryptionSchemeFactor;
    private Boolean modifyEncryptionSchemeOnLogin;
    public Builder encryptionScheme(String encryptionScheme) { this.encryptionScheme = encryptionScheme; return this; }
    public Builder encryptionSchemeFactor(Integer encryptionSchemeFactor) { this.encryptionSchemeFactor = encryptionSchemeFactor; return this; }
    public Builder modifyEncryptionSchemeOnLogin(Boolean modifyEncryptionSchemeOnLogin) { this.modifyEncryptionSchemeOnLogin = modifyEncryptionSchemeOnLogin; return this; }
    public PasswordEncryptionConfiguration build() { return new PasswordEncryptionConfiguration(encryptionScheme, encryptionSchemeFactor, modifyEncryptionSchemeOnLogin); }
  }
}
