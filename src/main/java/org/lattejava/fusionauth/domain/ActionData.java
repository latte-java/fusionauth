/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ActionDataJSON;

@JSON
public record ActionData(
    UUID actioneeUserId,
    UUID actionerUserId,
    List<UUID> applicationIds,
    String comment,
    Boolean emailUser,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expiry,
    Boolean notifyUser,
    String option,
    UUID reasonId,
    UUID userActionId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ActionDataJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ActionDataJSON.toJSONBytes(this);
  }

  public static ActionData fromJSON(String json) {
    return ActionDataJSON.fromJSON(json);
  }

  public static ActionData fromJSONBytes(byte[] json) {
    return ActionDataJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID actioneeUserId;
    private UUID actionerUserId;
    private List<UUID> applicationIds;
    private String comment;
    private Boolean emailUser;
    private Instant expiry;
    private Boolean notifyUser;
    private String option;
    private UUID reasonId;
    private UUID userActionId;
    public Builder actioneeUserId(UUID actioneeUserId) { this.actioneeUserId = actioneeUserId; return this; }
    public Builder actionerUserId(UUID actionerUserId) { this.actionerUserId = actionerUserId; return this; }
    public Builder applicationIds(List<UUID> applicationIds) { this.applicationIds = applicationIds; return this; }
    public Builder comment(String comment) { this.comment = comment; return this; }
    public Builder emailUser(Boolean emailUser) { this.emailUser = emailUser; return this; }
    public Builder expiry(Instant expiry) { this.expiry = expiry; return this; }
    public Builder notifyUser(Boolean notifyUser) { this.notifyUser = notifyUser; return this; }
    public Builder option(String option) { this.option = option; return this; }
    public Builder reasonId(UUID reasonId) { this.reasonId = reasonId; return this; }
    public Builder userActionId(UUID userActionId) { this.userActionId = userActionId; return this; }
    public ActionData build() { return new ActionData(actioneeUserId, actionerUserId, applicationIds, comment, emailUser, expiry, notifyUser, option, reasonId, userActionId); }
  }
}
