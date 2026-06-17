/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IPAccessControlListSearchResponseJSON;

@JSON
public record IPAccessControlListSearchResponse(
    List<IPAccessControlList> ipAccessControlLists,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IPAccessControlListSearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IPAccessControlListSearchResponseJSON.toJSONBytes(this);
  }
  
  public static IPAccessControlListSearchResponse fromJSON(String json) {
    return IPAccessControlListSearchResponseJSON.fromJSON(json);
  }
  
  public static IPAccessControlListSearchResponse fromJSONBytes(byte[] json) {
    return IPAccessControlListSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<IPAccessControlList> ipAccessControlLists;
    private Long total;
    public Builder ipAccessControlLists(List<IPAccessControlList> ipAccessControlLists) { this.ipAccessControlLists = ipAccessControlLists; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public IPAccessControlListSearchResponse build() { return new IPAccessControlListSearchResponse(ipAccessControlLists, total); }
  }
}
