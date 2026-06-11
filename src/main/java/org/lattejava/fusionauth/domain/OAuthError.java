/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.OAuthErrorJSON;

@JSON
public record OAuthError(
    String change_password_id,
    String error_description,
    OAuthErrorType error,
    String error_uri,
    List<TwoFactorMethod> two_factor_methods,
    OAuthErrorReason error_reason,
    String two_factor_id) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return OAuthErrorJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return OAuthErrorJSON.toJSONBytes(this);
  }

  public static OAuthError fromJSON(String json) {
    return OAuthErrorJSON.fromJSON(json);
  }

  public static OAuthError fromJSONBytes(byte[] json) {
    return OAuthErrorJSON.fromJSON(json);
  }

  public static final class Builder {
    private String change_password_id;
    private String error_description;
    private OAuthErrorType error;
    private String error_uri;
    private List<TwoFactorMethod> two_factor_methods;
    private OAuthErrorReason error_reason;
    private String two_factor_id;
    public Builder change_password_id(String change_password_id) { this.change_password_id = change_password_id; return this; }
    public Builder error_description(String error_description) { this.error_description = error_description; return this; }
    public Builder error(OAuthErrorType error) { this.error = error; return this; }
    public Builder error_uri(String error_uri) { this.error_uri = error_uri; return this; }
    public Builder two_factor_methods(List<TwoFactorMethod> two_factor_methods) { this.two_factor_methods = two_factor_methods; return this; }
    public Builder error_reason(OAuthErrorReason error_reason) { this.error_reason = error_reason; return this; }
    public Builder two_factor_id(String two_factor_id) { this.two_factor_id = two_factor_id; return this; }
    public OAuthError build() { return new OAuthError(change_password_id, error_description, error, error_uri, two_factor_methods, error_reason, two_factor_id); }
  }
}
