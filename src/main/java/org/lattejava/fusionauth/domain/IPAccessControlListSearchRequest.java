/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IPAccessControlListSearchRequestJSON;

@JSON
public record IPAccessControlListSearchRequest(
    IPAccessControlListSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IPAccessControlListSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IPAccessControlListSearchRequestJSON.toJSONBytes(this);
  }
  
  public static IPAccessControlListSearchRequest fromJSON(String json) {
    return IPAccessControlListSearchRequestJSON.fromJSON(json);
  }
  
  public static IPAccessControlListSearchRequest fromJSONBytes(byte[] json) {
    return IPAccessControlListSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private IPAccessControlListSearchCriteria search;
    public Builder search(IPAccessControlListSearchCriteria search) { this.search = search; return this; }
    public IPAccessControlListSearchRequest build() { return new IPAccessControlListSearchRequest(search); }
  }
}
