/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PublicKeyCredentialEntityJSON;

@JSON
public record PublicKeyCredentialEntity(
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PublicKeyCredentialEntityJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PublicKeyCredentialEntityJSON.toJSONBytes(this);
  }

  public static PublicKeyCredentialEntity fromJSON(String json) {
    return PublicKeyCredentialEntityJSON.fromJSON(json);
  }

  public static PublicKeyCredentialEntity fromJSONBytes(byte[] json) {
    return PublicKeyCredentialEntityJSON.fromJSON(json);
  }

  public static final class Builder {
    private String name;
    public Builder name(String name) { this.name = name; return this; }
    public PublicKeyCredentialEntity build() { return new PublicKeyCredentialEntity(name); }
  }
}
