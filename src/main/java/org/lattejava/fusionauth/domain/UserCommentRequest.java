/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCommentRequestJSON;

@JSON
public record UserCommentRequest(
    UserComment userComment) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCommentRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserCommentRequestJSON.toJSONBytes(this);
  }

  public static UserCommentRequest fromJSON(String json) {
    return UserCommentRequestJSON.fromJSON(json);
  }

  public static UserCommentRequest fromJSONBytes(byte[] json) {
    return UserCommentRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserComment userComment;
    public Builder userComment(UserComment userComment) { this.userComment = userComment; return this; }
    public UserCommentRequest build() { return new UserCommentRequest(userComment); }
  }
}
