/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ProvidedScopePolicyJSON;

@JSON
public record ProvidedScopePolicy(
    Requirable address,
    Requirable email,
    Requirable phone,
    Requirable profile) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ProvidedScopePolicyJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ProvidedScopePolicyJSON.toJSONBytes(this);
  }

  public static ProvidedScopePolicy fromJSON(String json) {
    return ProvidedScopePolicyJSON.fromJSON(json);
  }

  public static ProvidedScopePolicy fromJSONBytes(byte[] json) {
    return ProvidedScopePolicyJSON.fromJSON(json);
  }

  public static final class Builder {
    private Requirable address;
    private Requirable email;
    private Requirable phone;
    private Requirable profile;
    public Builder address(Requirable address) { this.address = address; return this; }
    public Builder email(Requirable email) { this.email = email; return this; }
    public Builder phone(Requirable phone) { this.phone = phone; return this; }
    public Builder profile(Requirable profile) { this.profile = profile; return this; }
    public ProvidedScopePolicy build() { return new ProvidedScopePolicy(address, email, phone, profile); }
  }
}
