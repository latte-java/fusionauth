/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PublicKeyCredentialDescriptorJSON;

@JSON
public record PublicKeyCredentialDescriptor(
    String id,
    List<String> transports,
    PublicKeyCredentialType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PublicKeyCredentialDescriptorJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PublicKeyCredentialDescriptorJSON.toJSONBytes(this);
  }

  public static PublicKeyCredentialDescriptor fromJSON(String json) {
    return PublicKeyCredentialDescriptorJSON.fromJSON(json);
  }

  public static PublicKeyCredentialDescriptor fromJSONBytes(byte[] json) {
    return PublicKeyCredentialDescriptorJSON.fromJSON(json);
  }

  public static final class Builder {
    private String id;
    private List<String> transports;
    private PublicKeyCredentialType type;
    public Builder id(String id) { this.id = id; return this; }
    public Builder transports(List<String> transports) { this.transports = transports; return this; }
    public Builder type(PublicKeyCredentialType type) { this.type = type; return this; }
    public PublicKeyCredentialDescriptor build() { return new PublicKeyCredentialDescriptor(id, transports, type); }
  }
}
