/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionReasonJSON;

@JSON
public record UserActionReason(
    String code,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    LocalizedStrings localizedTexts,
    String text) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionReasonJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserActionReasonJSON.toJSONBytes(this);
  }

  public static UserActionReason fromJSON(String json) {
    return UserActionReasonJSON.fromJSON(json);
  }

  public static UserActionReason fromJSONBytes(byte[] json) {
    return UserActionReasonJSON.fromJSON(json);
  }

  public static final class Builder {
    private String code;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private LocalizedStrings localizedTexts;
    private String text;
    public Builder code(String code) { this.code = code; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder localizedTexts(LocalizedStrings localizedTexts) { this.localizedTexts = localizedTexts; return this; }
    public Builder text(String text) { this.text = text; return this; }
    public UserActionReason build() { return new UserActionReason(code, id, insertInstant, lastUpdateInstant, localizedTexts, text); }
  }
}
