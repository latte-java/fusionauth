/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ConsentSearchResponseJSON;

@JSON
public record ConsentSearchResponse(
    List<Consent> consents,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ConsentSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ConsentSearchResponseJSON.toJSONBytes(this);
  }

  public static ConsentSearchResponse fromJSON(String json) {
    return ConsentSearchResponseJSON.fromJSON(json);
  }

  public static ConsentSearchResponse fromJSONBytes(byte[] json) {
    return ConsentSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Consent> consents;
    private Long total;
    public Builder consents(List<Consent> consents) { this.consents = consents; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public ConsentSearchResponse build() { return new ConsentSearchResponse(consents, total); }
  }
}
