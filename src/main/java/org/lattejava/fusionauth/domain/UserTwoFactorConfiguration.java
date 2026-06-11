/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserTwoFactorConfigurationJSON;

@JSON
public record UserTwoFactorConfiguration(
    List<TwoFactorMethod> methods,
    List<String> recoveryCodes) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserTwoFactorConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserTwoFactorConfigurationJSON.toJSONBytes(this);
  }

  public static UserTwoFactorConfiguration fromJSON(String json) {
    return UserTwoFactorConfigurationJSON.fromJSON(json);
  }

  public static UserTwoFactorConfiguration fromJSONBytes(byte[] json) {
    return UserTwoFactorConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<TwoFactorMethod> methods;
    private List<String> recoveryCodes;
    public Builder methods(List<TwoFactorMethod> methods) { this.methods = methods; return this; }
    public Builder recoveryCodes(List<String> recoveryCodes) { this.recoveryCodes = recoveryCodes; return this; }
    public UserTwoFactorConfiguration build() { return new UserTwoFactorConfiguration(methods, recoveryCodes); }
  }
}
