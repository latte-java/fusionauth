/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordlessSendRequestJSON;

@JSON
public record PasswordlessSendRequest(
    UUID applicationId,
    String code,
    String loginId,
    Map<String, Object> state) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordlessSendRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PasswordlessSendRequestJSON.toJSONBytes(this);
  }
  
  public static PasswordlessSendRequest fromJSON(String json) {
    return PasswordlessSendRequestJSON.fromJSON(json);
  }
  
  public static PasswordlessSendRequest fromJSONBytes(byte[] json) {
    return PasswordlessSendRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String code;
    private String loginId;
    private Map<String, Object> state;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder code(String code) { this.code = code; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public PasswordlessSendRequest build() { return new PasswordlessSendRequest(applicationId, code, loginId, state); }
  }
}
