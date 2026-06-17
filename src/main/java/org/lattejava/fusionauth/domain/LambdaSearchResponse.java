/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LambdaSearchResponseJSON;

@JSON
public record LambdaSearchResponse(
    List<Lambda> lambdas,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LambdaSearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LambdaSearchResponseJSON.toJSONBytes(this);
  }
  
  public static LambdaSearchResponse fromJSON(String json) {
    return LambdaSearchResponseJSON.fromJSON(json);
  }
  
  public static LambdaSearchResponse fromJSONBytes(byte[] json) {
    return LambdaSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Lambda> lambdas;
    private Long total;
    public Builder lambdas(List<Lambda> lambdas) { this.lambdas = lambdas; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public LambdaSearchResponse build() { return new LambdaSearchResponse(lambdas, total); }
  }
}
