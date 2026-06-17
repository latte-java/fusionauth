/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCommentSearchResponseJSON;

@JSON
public record UserCommentSearchResponse(
    Long total,
    List<UserComment> userComments) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCommentSearchResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserCommentSearchResponseJSON.toJSONBytes(this);
  }
  
  public static UserCommentSearchResponse fromJSON(String json) {
    return UserCommentSearchResponseJSON.fromJSON(json);
  }
  
  public static UserCommentSearchResponse fromJSONBytes(byte[] json) {
    return UserCommentSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Long total;
    private List<UserComment> userComments;
    public Builder total(Long total) { this.total = total; return this; }
    public Builder userComments(List<UserComment> userComments) { this.userComments = userComments; return this; }
    public UserCommentSearchResponse build() { return new UserCommentSearchResponse(total, userComments); }
  }
}
