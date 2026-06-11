/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ChangePasswordResponseJSON;

@JSON
public record ChangePasswordResponse(
    String oneTimePassword,
    Map<String, Object> state) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ChangePasswordResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ChangePasswordResponseJSON.toJSONBytes(this);
  }

  public static ChangePasswordResponse fromJSON(String json) {
    return ChangePasswordResponseJSON.fromJSON(json);
  }

  public static ChangePasswordResponse fromJSONBytes(byte[] json) {
    return ChangePasswordResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String oneTimePassword;
    private Map<String, Object> state;
    public Builder oneTimePassword(String oneTimePassword) { this.oneTimePassword = oneTimePassword; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public ChangePasswordResponse build() { return new ChangePasswordResponse(oneTimePassword, state); }
  }
}
