/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConsentRequestJSON;

@JSON
public record ConsentRequest(
    Consent consent) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConsentRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ConsentRequestJSON.toJSONBytes(this);
  }
  
  public static ConsentRequest fromJSON(String json) {
    return ConsentRequestJSON.fromJSON(json);
  }
  
  public static ConsentRequest fromJSONBytes(byte[] json) {
    return ConsentRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Consent consent;
    public Builder consent(Consent consent) { this.consent = consent; return this; }
    public ConsentRequest build() { return new ConsentRequest(consent); }
  }
}
