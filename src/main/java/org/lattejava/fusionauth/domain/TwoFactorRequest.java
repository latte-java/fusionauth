/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorRequestJSON;

@JSON
public record TwoFactorRequest(
    UUID applicationId,
    String authenticatorId,
    String code,
    String email,
    String method,
    String mobilePhone,
    String secret,
    String secretBase32Encoded,
    String twoFactorId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TwoFactorRequestJSON.toJSONBytes(this);
  }
  
  public static TwoFactorRequest fromJSON(String json) {
    return TwoFactorRequestJSON.fromJSON(json);
  }
  
  public static TwoFactorRequest fromJSONBytes(byte[] json) {
    return TwoFactorRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String authenticatorId;
    private String code;
    private String email;
    private String method;
    private String mobilePhone;
    private String secret;
    private String secretBase32Encoded;
    private String twoFactorId;
    private EventInfo eventInfo;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder authenticatorId(String authenticatorId) { this.authenticatorId = authenticatorId; return this; }
    public Builder code(String code) { this.code = code; return this; }
    public Builder email(String email) { this.email = email; return this; }
    public Builder method(String method) { this.method = method; return this; }
    public Builder mobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; return this; }
    public Builder secret(String secret) { this.secret = secret; return this; }
    public Builder secretBase32Encoded(String secretBase32Encoded) { this.secretBase32Encoded = secretBase32Encoded; return this; }
    public Builder twoFactorId(String twoFactorId) { this.twoFactorId = twoFactorId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public TwoFactorRequest build() { return new TwoFactorRequest(applicationId, authenticatorId, code, email, method, mobilePhone, secret, secretBase32Encoded, twoFactorId, eventInfo); }
  }
}
