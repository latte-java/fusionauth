/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConsentResponseJSON;

@JSON
public record ConsentResponse(
    Consent consent,
    List<Consent> consents) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConsentResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ConsentResponseJSON.toJSONBytes(this);
  }
  
  public static ConsentResponse fromJSON(String json) {
    return ConsentResponseJSON.fromJSON(json);
  }
  
  public static ConsentResponse fromJSONBytes(byte[] json) {
    return ConsentResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Consent consent;
    private List<Consent> consents;
    public Builder consent(Consent consent) { this.consent = consent; return this; }
    public Builder consents(List<Consent> consents) { this.consents = consents; return this; }
    public ConsentResponse build() { return new ConsentResponse(consent, consents); }
  }
}
