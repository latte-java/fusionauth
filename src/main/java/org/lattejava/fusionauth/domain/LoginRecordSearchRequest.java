/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginRecordSearchRequestJSON;

@JSON
public record LoginRecordSearchRequest(
    Boolean retrieveTotal,
    LoginRecordSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginRecordSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginRecordSearchRequestJSON.toJSONBytes(this);
  }
  
  public static LoginRecordSearchRequest fromJSON(String json) {
    return LoginRecordSearchRequestJSON.fromJSON(json);
  }
  
  public static LoginRecordSearchRequest fromJSONBytes(byte[] json) {
    return LoginRecordSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean retrieveTotal;
    private LoginRecordSearchCriteria search;
    public Builder retrieveTotal(Boolean retrieveTotal) { this.retrieveTotal = retrieveTotal; return this; }
    public Builder search(LoginRecordSearchCriteria search) { this.search = search; return this; }
    public LoginRecordSearchRequest build() { return new LoginRecordSearchRequest(retrieveTotal, search); }
  }
}
