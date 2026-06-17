/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordValidationRulesResponseJSON;

@JSON
public record PasswordValidationRulesResponse(
    PasswordValidationRules passwordValidationRules) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordValidationRulesResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PasswordValidationRulesResponseJSON.toJSONBytes(this);
  }
  
  public static PasswordValidationRulesResponse fromJSON(String json) {
    return PasswordValidationRulesResponseJSON.fromJSON(json);
  }
  
  public static PasswordValidationRulesResponse fromJSONBytes(byte[] json) {
    return PasswordValidationRulesResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private PasswordValidationRules passwordValidationRules;
    public Builder passwordValidationRules(PasswordValidationRules passwordValidationRules) { this.passwordValidationRules = passwordValidationRules; return this; }
    public PasswordValidationRulesResponse build() { return new PasswordValidationRulesResponse(passwordValidationRules); }
  }
}
