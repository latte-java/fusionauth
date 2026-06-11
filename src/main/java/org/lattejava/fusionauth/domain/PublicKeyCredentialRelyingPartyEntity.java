/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PublicKeyCredentialRelyingPartyEntityJSON;

@JSON
public record PublicKeyCredentialRelyingPartyEntity(
    String id,
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PublicKeyCredentialRelyingPartyEntityJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PublicKeyCredentialRelyingPartyEntityJSON.toJSONBytes(this);
  }

  public static PublicKeyCredentialRelyingPartyEntity fromJSON(String json) {
    return PublicKeyCredentialRelyingPartyEntityJSON.fromJSON(json);
  }

  public static PublicKeyCredentialRelyingPartyEntity fromJSONBytes(byte[] json) {
    return PublicKeyCredentialRelyingPartyEntityJSON.fromJSON(json);
  }

  public static final class Builder {
    private String id;
    private String name;
    public Builder id(String id) { this.id = id; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public PublicKeyCredentialRelyingPartyEntity build() { return new PublicKeyCredentialRelyingPartyEntity(id, name); }
  }
}
