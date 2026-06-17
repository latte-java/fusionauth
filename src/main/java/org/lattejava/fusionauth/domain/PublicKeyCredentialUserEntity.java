/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PublicKeyCredentialUserEntityJSON;

@JSON
public record PublicKeyCredentialUserEntity(
    String displayName,
    String id,
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PublicKeyCredentialUserEntityJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PublicKeyCredentialUserEntityJSON.toJSONBytes(this);
  }
  
  public static PublicKeyCredentialUserEntity fromJSON(String json) {
    return PublicKeyCredentialUserEntityJSON.fromJSON(json);
  }
  
  public static PublicKeyCredentialUserEntity fromJSONBytes(byte[] json) {
    return PublicKeyCredentialUserEntityJSON.fromJSON(json);
  }

  public static final class Builder {
    private String displayName;
    private String id;
    private String name;
    public Builder displayName(String displayName) { this.displayName = displayName; return this; }
    public Builder id(String id) { this.id = id; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public PublicKeyCredentialUserEntity build() { return new PublicKeyCredentialUserEntity(displayName, id, name); }
  }
}
