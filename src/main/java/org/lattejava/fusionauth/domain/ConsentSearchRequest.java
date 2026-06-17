/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConsentSearchRequestJSON;

@JSON
public record ConsentSearchRequest(
    ConsentSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConsentSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ConsentSearchRequestJSON.toJSONBytes(this);
  }
  
  public static ConsentSearchRequest fromJSON(String json) {
    return ConsentSearchRequestJSON.fromJSON(json);
  }
  
  public static ConsentSearchRequest fromJSONBytes(byte[] json) {
    return ConsentSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private ConsentSearchCriteria search;
    public Builder search(ConsentSearchCriteria search) { this.search = search; return this; }
    public ConsentSearchRequest build() { return new ConsentSearchRequest(search); }
  }
}
