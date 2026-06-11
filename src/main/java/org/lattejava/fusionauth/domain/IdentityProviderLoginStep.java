/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderLoginStepJSON;

@JSON
public record IdentityProviderLoginStep(
    String detail,
    Boolean success,
    String title) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderLoginStepJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderLoginStepJSON.toJSONBytes(this);
  }

  public static IdentityProviderLoginStep fromJSON(String json) {
    return IdentityProviderLoginStepJSON.fromJSON(json);
  }

  public static IdentityProviderLoginStep fromJSONBytes(byte[] json) {
    return IdentityProviderLoginStepJSON.fromJSON(json);
  }

  public static final class Builder {
    private String detail;
    private Boolean success;
    private String title;
    public Builder detail(String detail) { this.detail = detail; return this; }
    public Builder success(Boolean success) { this.success = success; return this; }
    public Builder title(String title) { this.title = title; return this; }
    public IdentityProviderLoginStep build() { return new IdentityProviderLoginStep(detail, success, title); }
  }
}
