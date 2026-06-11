/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IPAccessControlListResponseJSON;

@JSON
public record IPAccessControlListResponse(
    IPAccessControlList ipAccessControlList,
    List<IPAccessControlList> ipAccessControlLists) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IPAccessControlListResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IPAccessControlListResponseJSON.toJSONBytes(this);
  }

  public static IPAccessControlListResponse fromJSON(String json) {
    return IPAccessControlListResponseJSON.fromJSON(json);
  }

  public static IPAccessControlListResponse fromJSONBytes(byte[] json) {
    return IPAccessControlListResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private IPAccessControlList ipAccessControlList;
    private List<IPAccessControlList> ipAccessControlLists;
    public Builder ipAccessControlList(IPAccessControlList ipAccessControlList) { this.ipAccessControlList = ipAccessControlList; return this; }
    public Builder ipAccessControlLists(List<IPAccessControlList> ipAccessControlLists) { this.ipAccessControlLists = ipAccessControlLists; return this; }
    public IPAccessControlListResponse build() { return new IPAccessControlListResponse(ipAccessControlList, ipAccessControlLists); }
  }
}
