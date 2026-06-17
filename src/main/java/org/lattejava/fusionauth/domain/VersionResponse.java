/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VersionResponseJSON;

@JSON
public record VersionResponse(
    String version) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VersionResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return VersionResponseJSON.toJSONBytes(this);
  }
  
  public static VersionResponse fromJSON(String json) {
    return VersionResponseJSON.fromJSON(json);
  }
  
  public static VersionResponse fromJSONBytes(byte[] json) {
    return VersionResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String version;
    public Builder version(String version) { this.version = version; return this; }
    public VersionResponse build() { return new VersionResponse(version); }
  }
}
