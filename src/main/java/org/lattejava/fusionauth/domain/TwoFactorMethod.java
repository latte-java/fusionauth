/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorMethodJSON;

@JSON
public record TwoFactorMethod(
    AuthenticatorConfiguration authenticator,
    String email,
    String id,
    Boolean lastUsed,
    String method,
    String mobilePhone,
    String secret) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorMethodJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TwoFactorMethodJSON.toJSONBytes(this);
  }
  
  public static TwoFactorMethod fromJSON(String json) {
    return TwoFactorMethodJSON.fromJSON(json);
  }
  
  public static TwoFactorMethod fromJSONBytes(byte[] json) {
    return TwoFactorMethodJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuthenticatorConfiguration authenticator;
    private String email;
    private String id;
    private Boolean lastUsed;
    private String method;
    private String mobilePhone;
    private String secret;
    public Builder authenticator(AuthenticatorConfiguration authenticator) { this.authenticator = authenticator; return this; }
    public Builder email(String email) { this.email = email; return this; }
    public Builder id(String id) { this.id = id; return this; }
    public Builder lastUsed(Boolean lastUsed) { this.lastUsed = lastUsed; return this; }
    public Builder method(String method) { this.method = method; return this; }
    public Builder mobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; return this; }
    public Builder secret(String secret) { this.secret = secret; return this; }
    public TwoFactorMethod build() { return new TwoFactorMethod(authenticator, email, id, lastUsed, method, mobilePhone, secret); }
  }
}
