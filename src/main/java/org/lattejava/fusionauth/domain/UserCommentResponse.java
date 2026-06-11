/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCommentResponseJSON;

@JSON
public record UserCommentResponse(
    UserComment userComment,
    List<UserComment> userComments) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCommentResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserCommentResponseJSON.toJSONBytes(this);
  }

  public static UserCommentResponse fromJSON(String json) {
    return UserCommentResponseJSON.fromJSON(json);
  }

  public static UserCommentResponse fromJSONBytes(byte[] json) {
    return UserCommentResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserComment userComment;
    private List<UserComment> userComments;
    public Builder userComment(UserComment userComment) { this.userComment = userComment; return this; }
    public Builder userComments(List<UserComment> userComments) { this.userComments = userComments; return this; }
    public UserCommentResponse build() { return new UserCommentResponse(userComment, userComments); }
  }
}
