/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LambdaSearchRequestJSON;

@JSON
public record LambdaSearchRequest(
    LambdaSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LambdaSearchRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LambdaSearchRequestJSON.toJSONBytes(this);
  }

  public static LambdaSearchRequest fromJSON(String json) {
    return LambdaSearchRequestJSON.fromJSON(json);
  }

  public static LambdaSearchRequest fromJSONBytes(byte[] json) {
    return LambdaSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private LambdaSearchCriteria search;
    public Builder search(LambdaSearchCriteria search) { this.search = search; return this; }
    public LambdaSearchRequest build() { return new LambdaSearchRequest(search); }
  }
}
