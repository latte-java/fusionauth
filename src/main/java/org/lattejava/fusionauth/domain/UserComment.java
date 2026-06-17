/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserCommentJSON;

@JSON
public record UserComment(
    String comment,
    UUID commenterId,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserCommentJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserCommentJSON.toJSONBytes(this);
  }
  
  public static UserComment fromJSON(String json) {
    return UserCommentJSON.fromJSON(json);
  }
  
  public static UserComment fromJSONBytes(byte[] json) {
    return UserCommentJSON.fromJSON(json);
  }

  public static final class Builder {
    private String comment;
    private UUID commenterId;
    private UUID id;
    private Instant insertInstant;
    private UUID userId;
    public Builder comment(String comment) { this.comment = comment; return this; }
    public Builder commenterId(UUID commenterId) { this.commenterId = commenterId; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public UserComment build() { return new UserComment(comment, commenterId, id, insertInstant, userId); }
  }
}
