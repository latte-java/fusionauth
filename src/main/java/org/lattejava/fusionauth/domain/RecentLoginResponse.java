/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RecentLoginResponseJSON;

@JSON
public record RecentLoginResponse(
    List<DisplayableRawLogin> logins) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RecentLoginResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RecentLoginResponseJSON.toJSONBytes(this);
  }

  public static RecentLoginResponse fromJSON(String json) {
    return RecentLoginResponseJSON.fromJSON(json);
  }

  public static RecentLoginResponse fromJSONBytes(byte[] json) {
    return RecentLoginResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<DisplayableRawLogin> logins;
    public Builder logins(List<DisplayableRawLogin> logins) { this.logins = logins; return this; }
    public RecentLoginResponse build() { return new RecentLoginResponse(logins); }
  }
}
