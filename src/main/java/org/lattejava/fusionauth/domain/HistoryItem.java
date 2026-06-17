/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.HistoryItemJSON;

@JSON
public record HistoryItem(
    UUID actionerUserId,
    String comment,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expiry) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return HistoryItemJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return HistoryItemJSON.toJSONBytes(this);
  }
  
  public static HistoryItem fromJSON(String json) {
    return HistoryItemJSON.fromJSON(json);
  }
  
  public static HistoryItem fromJSONBytes(byte[] json) {
    return HistoryItemJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID actionerUserId;
    private String comment;
    private Instant createInstant;
    private Instant expiry;
    public Builder actionerUserId(UUID actionerUserId) { this.actionerUserId = actionerUserId; return this; }
    public Builder comment(String comment) { this.comment = comment; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder expiry(Instant expiry) { this.expiry = expiry; return this; }
    public HistoryItem build() { return new HistoryItem(actionerUserId, comment, createInstant, expiry); }
  }
}
