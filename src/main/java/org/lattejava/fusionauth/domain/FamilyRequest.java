/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FamilyRequestJSON;

@JSON
public record FamilyRequest(
    FamilyMember familyMember) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FamilyRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FamilyRequestJSON.toJSONBytes(this);
  }

  public static FamilyRequest fromJSON(String json) {
    return FamilyRequestJSON.fromJSON(json);
  }

  public static FamilyRequest fromJSONBytes(byte[] json) {
    return FamilyRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private FamilyMember familyMember;
    public Builder familyMember(FamilyMember familyMember) { this.familyMember = familyMember; return this; }
    public FamilyRequest build() { return new FamilyRequest(familyMember); }
  }
}
