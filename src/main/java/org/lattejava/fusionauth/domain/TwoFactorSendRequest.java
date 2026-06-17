/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwoFactorSendRequestJSON;

@JSON
public record TwoFactorSendRequest(
    UUID applicationId,
    String email,
    MessageType messageType,
    String method,
    String methodId,
    String mobilePhone,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwoFactorSendRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TwoFactorSendRequestJSON.toJSONBytes(this);
  }
  
  public static TwoFactorSendRequest fromJSON(String json) {
    return TwoFactorSendRequestJSON.fromJSON(json);
  }
  
  public static TwoFactorSendRequest fromJSONBytes(byte[] json) {
    return TwoFactorSendRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String email;
    private MessageType messageType;
    private String method;
    private String methodId;
    private String mobilePhone;
    private UUID userId;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder email(String email) { this.email = email; return this; }
    public Builder messageType(MessageType messageType) { this.messageType = messageType; return this; }
    public Builder method(String method) { this.method = method; return this; }
    public Builder methodId(String methodId) { this.methodId = methodId; return this; }
    public Builder mobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public TwoFactorSendRequest build() { return new TwoFactorSendRequest(applicationId, email, messageType, method, methodId, mobilePhone, userId); }
  }
}
