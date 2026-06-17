/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorEnableDisableSendRequestJSON;

@JSON
public record TwoFactorEnableDisableSendRequest(
    String email,
    String method,
    String methodId,
    String mobilePhone) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorEnableDisableSendRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TwoFactorEnableDisableSendRequestJSON.toJSONBytes(this);
  }
  
  public static TwoFactorEnableDisableSendRequest fromJSON(String json) {
    return TwoFactorEnableDisableSendRequestJSON.fromJSON(json);
  }
  
  public static TwoFactorEnableDisableSendRequest fromJSONBytes(byte[] json) {
    return TwoFactorEnableDisableSendRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String email;
    private String method;
    private String methodId;
    private String mobilePhone;
    public Builder email(String email) { this.email = email; return this; }
    public Builder method(String method) { this.method = method; return this; }
    public Builder methodId(String methodId) { this.methodId = methodId; return this; }
    public Builder mobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; return this; }
    public TwoFactorEnableDisableSendRequest build() { return new TwoFactorEnableDisableSendRequest(email, method, methodId, mobilePhone); }
  }
}
