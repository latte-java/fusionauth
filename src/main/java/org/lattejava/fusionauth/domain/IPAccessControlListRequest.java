/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IPAccessControlListRequestJSON;

@JSON
public record IPAccessControlListRequest(
    IPAccessControlList ipAccessControlList) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IPAccessControlListRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IPAccessControlListRequestJSON.toJSONBytes(this);
  }
  
  public static IPAccessControlListRequest fromJSON(String json) {
    return IPAccessControlListRequestJSON.fromJSON(json);
  }
  
  public static IPAccessControlListRequest fromJSONBytes(byte[] json) {
    return IPAccessControlListRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private IPAccessControlList ipAccessControlList;
    public Builder ipAccessControlList(IPAccessControlList ipAccessControlList) { this.ipAccessControlList = ipAccessControlList; return this; }
    public IPAccessControlListRequest build() { return new IPAccessControlListRequest(ipAccessControlList); }
  }
}
