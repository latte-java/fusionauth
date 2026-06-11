/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordlessStartRequestJSON;

@JSON
public record PasswordlessStartRequest(
    UUID applicationId,
    String loginId,
    List<String> loginIdTypes,
    PasswordlessStrategy loginStrategy,
    Map<String, Object> state) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordlessStartRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PasswordlessStartRequestJSON.toJSONBytes(this);
  }

  public static PasswordlessStartRequest fromJSON(String json) {
    return PasswordlessStartRequestJSON.fromJSON(json);
  }

  public static PasswordlessStartRequest fromJSONBytes(byte[] json) {
    return PasswordlessStartRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String loginId;
    private List<String> loginIdTypes;
    private PasswordlessStrategy loginStrategy;
    private Map<String, Object> state;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdTypes(List<String> loginIdTypes) { this.loginIdTypes = loginIdTypes; return this; }
    public Builder loginStrategy(PasswordlessStrategy loginStrategy) { this.loginStrategy = loginStrategy; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public PasswordlessStartRequest build() { return new PasswordlessStartRequest(applicationId, loginId, loginIdTypes, loginStrategy, state); }
  }
}
