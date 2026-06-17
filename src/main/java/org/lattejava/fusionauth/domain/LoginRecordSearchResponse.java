/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginRecordSearchResponseJSON;

@JSON
public record LoginRecordSearchResponse(
    List<DisplayableRawLogin> logins,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginRecordSearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginRecordSearchResponseJSON.toJSONBytes(this);
  }
  
  public static LoginRecordSearchResponse fromJSON(String json) {
    return LoginRecordSearchResponseJSON.fromJSON(json);
  }
  
  public static LoginRecordSearchResponse fromJSONBytes(byte[] json) {
    return LoginRecordSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<DisplayableRawLogin> logins;
    private Long total;
    public Builder logins(List<DisplayableRawLogin> logins) { this.logins = logins; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public LoginRecordSearchResponse build() { return new LoginRecordSearchResponse(logins, total); }
  }
}
