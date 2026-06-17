/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LoginPreventedResponseJSON;

@JSON
public record LoginPreventedResponse(
    UUID actionId,
    UUID actionerUserId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expiry,
    String localizedName,
    String localizedOption,
    String localizedReason,
    String name,
    String option,
    String reason,
    String reasonCode) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LoginPreventedResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return LoginPreventedResponseJSON.toJSONBytes(this);
  }
  
  public static LoginPreventedResponse fromJSON(String json) {
    return LoginPreventedResponseJSON.fromJSON(json);
  }
  
  public static LoginPreventedResponse fromJSONBytes(byte[] json) {
    return LoginPreventedResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID actionId;
    private UUID actionerUserId;
    private Instant expiry;
    private String localizedName;
    private String localizedOption;
    private String localizedReason;
    private String name;
    private String option;
    private String reason;
    private String reasonCode;
    public Builder actionId(UUID actionId) { this.actionId = actionId; return this; }
    public Builder actionerUserId(UUID actionerUserId) { this.actionerUserId = actionerUserId; return this; }
    public Builder expiry(Instant expiry) { this.expiry = expiry; return this; }
    public Builder localizedName(String localizedName) { this.localizedName = localizedName; return this; }
    public Builder localizedOption(String localizedOption) { this.localizedOption = localizedOption; return this; }
    public Builder localizedReason(String localizedReason) { this.localizedReason = localizedReason; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder option(String option) { this.option = option; return this; }
    public Builder reason(String reason) { this.reason = reason; return this; }
    public Builder reasonCode(String reasonCode) { this.reasonCode = reasonCode; return this; }
    public LoginPreventedResponse build() { return new LoginPreventedResponse(actionId, actionerUserId, expiry, localizedName, localizedOption, localizedReason, name, option, reason, reasonCode); }
  }
}
