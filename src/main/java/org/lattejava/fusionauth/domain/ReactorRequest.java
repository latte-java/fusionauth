/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ReactorRequestJSON;

@JSON
public record ReactorRequest(
    String license,
    String licenseId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ReactorRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ReactorRequestJSON.toJSONBytes(this);
  }

  public static ReactorRequest fromJSON(String json) {
    return ReactorRequestJSON.fromJSON(json);
  }

  public static ReactorRequest fromJSONBytes(byte[] json) {
    return ReactorRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String license;
    private String licenseId;
    public Builder license(String license) { this.license = license; return this; }
    public Builder licenseId(String licenseId) { this.licenseId = licenseId; return this; }
    public ReactorRequest build() { return new ReactorRequest(license, licenseId); }
  }
}
