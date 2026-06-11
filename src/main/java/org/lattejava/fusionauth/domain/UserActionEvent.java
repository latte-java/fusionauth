/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionEventJSON;

@JSON
public record UserActionEvent(
    List<UUID> applicationIds,
    String action,
    UUID actionId,
    UUID actioneeUserId,
    UUID actionerUserId,
    String comment,
    Email email,
    Boolean emailedUser,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expiry,
    String localizedAction,
    String localizedDuration,
    String localizedOption,
    String localizedReason,
    Boolean notifyUser,
    String option,
    UserActionPhase phase,
    String reason,
    String reasonCode,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant createInstant,
    UUID id,
    EventInfo info,
    UUID tenantId,
    EventType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserActionEventJSON.toJSONBytes(this);
  }

  public static UserActionEvent fromJSON(String json) {
    return UserActionEventJSON.fromJSON(json);
  }

  public static UserActionEvent fromJSONBytes(byte[] json) {
    return UserActionEventJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<UUID> applicationIds;
    private String action;
    private UUID actionId;
    private UUID actioneeUserId;
    private UUID actionerUserId;
    private String comment;
    private Email email;
    private Boolean emailedUser;
    private Instant expiry;
    private String localizedAction;
    private String localizedDuration;
    private String localizedOption;
    private String localizedReason;
    private Boolean notifyUser;
    private String option;
    private UserActionPhase phase;
    private String reason;
    private String reasonCode;
    private Instant createInstant;
    private UUID id;
    private EventInfo info;
    private UUID tenantId;
    private EventType type;
    public Builder applicationIds(List<UUID> applicationIds) { this.applicationIds = applicationIds; return this; }
    public Builder action(String action) { this.action = action; return this; }
    public Builder actionId(UUID actionId) { this.actionId = actionId; return this; }
    public Builder actioneeUserId(UUID actioneeUserId) { this.actioneeUserId = actioneeUserId; return this; }
    public Builder actionerUserId(UUID actionerUserId) { this.actionerUserId = actionerUserId; return this; }
    public Builder comment(String comment) { this.comment = comment; return this; }
    public Builder email(Email email) { this.email = email; return this; }
    public Builder emailedUser(Boolean emailedUser) { this.emailedUser = emailedUser; return this; }
    public Builder expiry(Instant expiry) { this.expiry = expiry; return this; }
    public Builder localizedAction(String localizedAction) { this.localizedAction = localizedAction; return this; }
    public Builder localizedDuration(String localizedDuration) { this.localizedDuration = localizedDuration; return this; }
    public Builder localizedOption(String localizedOption) { this.localizedOption = localizedOption; return this; }
    public Builder localizedReason(String localizedReason) { this.localizedReason = localizedReason; return this; }
    public Builder notifyUser(Boolean notifyUser) { this.notifyUser = notifyUser; return this; }
    public Builder option(String option) { this.option = option; return this; }
    public Builder phase(UserActionPhase phase) { this.phase = phase; return this; }
    public Builder reason(String reason) { this.reason = reason; return this; }
    public Builder reasonCode(String reasonCode) { this.reasonCode = reasonCode; return this; }
    public Builder createInstant(Instant createInstant) { this.createInstant = createInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder info(EventInfo info) { this.info = info; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder type(EventType type) { this.type = type; return this; }
    public UserActionEvent build() { return new UserActionEvent(applicationIds, action, actionId, actioneeUserId, actionerUserId, comment, email, emailedUser, expiry, localizedAction, localizedDuration, localizedOption, localizedReason, notifyUser, option, phase, reason, reasonCode, createInstant, id, info, tenantId, type); }
  }
}
