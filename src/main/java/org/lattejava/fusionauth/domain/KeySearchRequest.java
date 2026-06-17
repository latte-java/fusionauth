/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KeySearchRequestJSON;

@JSON
public record KeySearchRequest(
    KeySearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return KeySearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return KeySearchRequestJSON.toJSONBytes(this);
  }
  
  public static KeySearchRequest fromJSON(String json) {
    return KeySearchRequestJSON.fromJSON(json);
  }
  
  public static KeySearchRequest fromJSONBytes(byte[] json) {
    return KeySearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private KeySearchCriteria search;
    public Builder search(KeySearchCriteria search) { this.search = search; return this; }
    public KeySearchRequest build() { return new KeySearchRequest(search); }
  }
}
