/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LambdaRequestJSON;

@JSON
public record LambdaRequest(
    Lambda lambda) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LambdaRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LambdaRequestJSON.toJSONBytes(this);
  }
  
  public static LambdaRequest fromJSON(String json) {
    return LambdaRequestJSON.fromJSON(json);
  }
  
  public static LambdaRequest fromJSONBytes(byte[] json) {
    return LambdaRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Lambda lambda;
    public Builder lambda(Lambda lambda) { this.lambda = lambda; return this; }
    public LambdaRequest build() { return new LambdaRequest(lambda); }
  }
}
