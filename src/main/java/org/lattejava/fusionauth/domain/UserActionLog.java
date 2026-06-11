/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionLogJSON;

@JSON
public record UserActionLog(
    UUID actioneeUserId,
    UUID actionerUserId,
    List<UUID> applicationIds,
    String comment,
    Boolean emailUserOnEnd,
    Boolean endEventSent,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expiry,
    LogHistory history,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    String localizedName,
    String localizedOption,
    String localizedReason,
    String name,
    Boolean notifyUserOnEnd,
    String option,
    String reason,
    String reasonCode,
    UUID userActionId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionLogJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserActionLogJSON.toJSONBytes(this);
  }

  public static UserActionLog fromJSON(String json) {
    return UserActionLogJSON.fromJSON(json);
  }

  public static UserActionLog fromJSONBytes(byte[] json) {
    return UserActionLogJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID actioneeUserId;
    private UUID actionerUserId;
    private List<UUID> applicationIds;
    private String comment;
    private Boolean emailUserOnEnd;
    private Boolean endEventSent;
    private Instant expiry;
    private LogHistory history;
    private UUID id;
    private Instant insertInstant;
    private String localizedName;
    private String localizedOption;
    private String localizedReason;
    private String name;
    private Boolean notifyUserOnEnd;
    private String option;
    private String reason;
    private String reasonCode;
    private UUID userActionId;
    public Builder actioneeUserId(UUID actioneeUserId) { this.actioneeUserId = actioneeUserId; return this; }
    public Builder actionerUserId(UUID actionerUserId) { this.actionerUserId = actionerUserId; return this; }
    public Builder applicationIds(List<UUID> applicationIds) { this.applicationIds = applicationIds; return this; }
    public Builder comment(String comment) { this.comment = comment; return this; }
    public Builder emailUserOnEnd(Boolean emailUserOnEnd) { this.emailUserOnEnd = emailUserOnEnd; return this; }
    public Builder endEventSent(Boolean endEventSent) { this.endEventSent = endEventSent; return this; }
    public Builder expiry(Instant expiry) { this.expiry = expiry; return this; }
    public Builder history(LogHistory history) { this.history = history; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder localizedName(String localizedName) { this.localizedName = localizedName; return this; }
    public Builder localizedOption(String localizedOption) { this.localizedOption = localizedOption; return this; }
    public Builder localizedReason(String localizedReason) { this.localizedReason = localizedReason; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder notifyUserOnEnd(Boolean notifyUserOnEnd) { this.notifyUserOnEnd = notifyUserOnEnd; return this; }
    public Builder option(String option) { this.option = option; return this; }
    public Builder reason(String reason) { this.reason = reason; return this; }
    public Builder reasonCode(String reasonCode) { this.reasonCode = reasonCode; return this; }
    public Builder userActionId(UUID userActionId) { this.userActionId = userActionId; return this; }
    public UserActionLog build() { return new UserActionLog(actioneeUserId, actionerUserId, applicationIds, comment, emailUserOnEnd, endEventSent, expiry, history, id, insertInstant, localizedName, localizedOption, localizedReason, name, notifyUserOnEnd, option, reason, reasonCode, userActionId); }
  }
}
