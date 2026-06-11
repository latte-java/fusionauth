/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCommentSearchRequestJSON;

@JSON
public record UserCommentSearchRequest(
    UserCommentSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCommentSearchRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserCommentSearchRequestJSON.toJSONBytes(this);
  }

  public static UserCommentSearchRequest fromJSON(String json) {
    return UserCommentSearchRequestJSON.fromJSON(json);
  }

  public static UserCommentSearchRequest fromJSONBytes(byte[] json) {
    return UserCommentSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserCommentSearchCriteria search;
    public Builder search(UserCommentSearchCriteria search) { this.search = search; return this; }
    public UserCommentSearchRequest build() { return new UserCommentSearchRequest(search); }
  }
}
