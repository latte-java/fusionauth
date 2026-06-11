/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LambdaResponseJSON;

@JSON
public record LambdaResponse(
    Lambda lambda,
    List<Lambda> lambdas) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LambdaResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LambdaResponseJSON.toJSONBytes(this);
  }

  public static LambdaResponse fromJSON(String json) {
    return LambdaResponseJSON.fromJSON(json);
  }

  public static LambdaResponse fromJSONBytes(byte[] json) {
    return LambdaResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Lambda lambda;
    private List<Lambda> lambdas;
    public Builder lambda(Lambda lambda) { this.lambda = lambda; return this; }
    public Builder lambdas(List<Lambda> lambdas) { this.lambdas = lambdas; return this; }
    public LambdaResponse build() { return new LambdaResponse(lambda, lambdas); }
  }
}
