/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginRecordConfigurationJSON;

@JSON
public record LoginRecordConfiguration(
    DeleteConfiguration delete) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginRecordConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginRecordConfigurationJSON.toJSONBytes(this);
  }
  
  public static LoginRecordConfiguration fromJSON(String json) {
    return LoginRecordConfigurationJSON.fromJSON(json);
  }
  
  public static LoginRecordConfiguration fromJSONBytes(byte[] json) {
    return LoginRecordConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private DeleteConfiguration delete;
    public Builder delete(DeleteConfiguration delete) { this.delete = delete; return this; }
    public LoginRecordConfiguration build() { return new LoginRecordConfiguration(delete); }
  }
}
