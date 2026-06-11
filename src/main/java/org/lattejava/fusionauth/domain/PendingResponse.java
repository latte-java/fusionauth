/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PendingResponseJSON;

@JSON
public record PendingResponse(
    List<User> users) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PendingResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PendingResponseJSON.toJSONBytes(this);
  }

  public static PendingResponse fromJSON(String json) {
    return PendingResponseJSON.fromJSON(json);
  }

  public static PendingResponse fromJSONBytes(byte[] json) {
    return PendingResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<User> users;
    public Builder users(List<User> users) { this.users = users; return this; }
    public PendingResponse build() { return new PendingResponse(users); }
  }
}
