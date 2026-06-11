/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordValidationRulesJSON;

@JSON
public record PasswordValidationRules(
    PasswordBreachDetection breachDetection,
    Boolean disallowUserLoginId,
    Integer maxLength,
    Integer minLength,
    RememberPreviousPasswords rememberPreviousPasswords,
    Boolean requireMixedCase,
    Boolean requireNonAlpha,
    Boolean requireNumber,
    Boolean validateOnLogin) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordValidationRulesJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PasswordValidationRulesJSON.toJSONBytes(this);
  }

  public static PasswordValidationRules fromJSON(String json) {
    return PasswordValidationRulesJSON.fromJSON(json);
  }

  public static PasswordValidationRules fromJSONBytes(byte[] json) {
    return PasswordValidationRulesJSON.fromJSON(json);
  }

  public static final class Builder {
    private PasswordBreachDetection breachDetection;
    private Boolean disallowUserLoginId;
    private Integer maxLength;
    private Integer minLength;
    private RememberPreviousPasswords rememberPreviousPasswords;
    private Boolean requireMixedCase;
    private Boolean requireNonAlpha;
    private Boolean requireNumber;
    private Boolean validateOnLogin;
    public Builder breachDetection(PasswordBreachDetection breachDetection) { this.breachDetection = breachDetection; return this; }
    public Builder disallowUserLoginId(Boolean disallowUserLoginId) { this.disallowUserLoginId = disallowUserLoginId; return this; }
    public Builder maxLength(Integer maxLength) { this.maxLength = maxLength; return this; }
    public Builder minLength(Integer minLength) { this.minLength = minLength; return this; }
    public Builder rememberPreviousPasswords(RememberPreviousPasswords rememberPreviousPasswords) { this.rememberPreviousPasswords = rememberPreviousPasswords; return this; }
    public Builder requireMixedCase(Boolean requireMixedCase) { this.requireMixedCase = requireMixedCase; return this; }
    public Builder requireNonAlpha(Boolean requireNonAlpha) { this.requireNonAlpha = requireNonAlpha; return this; }
    public Builder requireNumber(Boolean requireNumber) { this.requireNumber = requireNumber; return this; }
    public Builder validateOnLogin(Boolean validateOnLogin) { this.validateOnLogin = validateOnLogin; return this; }
    public PasswordValidationRules build() { return new PasswordValidationRules(breachDetection, disallowUserLoginId, maxLength, minLength, rememberPreviousPasswords, requireMixedCase, requireNonAlpha, requireNumber, validateOnLogin); }
  }
}
