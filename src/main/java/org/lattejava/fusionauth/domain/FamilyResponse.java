/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FamilyResponseJSON;

@JSON
public record FamilyResponse(
    List<Family> families,
    Family family) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FamilyResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FamilyResponseJSON.toJSONBytes(this);
  }

  public static FamilyResponse fromJSON(String json) {
    return FamilyResponseJSON.fromJSON(json);
  }

  public static FamilyResponse fromJSONBytes(byte[] json) {
    return FamilyResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Family> families;
    private Family family;
    public Builder families(List<Family> families) { this.families = families; return this; }
    public Builder family(Family family) { this.family = family; return this; }
    public FamilyResponse build() { return new FamilyResponse(families, family); }
  }
}
