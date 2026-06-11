/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RequiredLambdaResultJSON;

@JSON
public record RequiredLambdaResult(
    Boolean required,
    Boolean sendSuspiciousLoginEvent) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RequiredLambdaResultJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RequiredLambdaResultJSON.toJSONBytes(this);
  }

  public static RequiredLambdaResult fromJSON(String json) {
    return RequiredLambdaResultJSON.fromJSON(json);
  }

  public static RequiredLambdaResult fromJSONBytes(byte[] json) {
    return RequiredLambdaResultJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean required;
    private Boolean sendSuspiciousLoginEvent;
    public Builder required(Boolean required) { this.required = required; return this; }
    public Builder sendSuspiciousLoginEvent(Boolean sendSuspiciousLoginEvent) { this.sendSuspiciousLoginEvent = sendSuspiciousLoginEvent; return this; }
    public RequiredLambdaResult build() { return new RequiredLambdaResult(required, sendSuspiciousLoginEvent); }
  }
}
