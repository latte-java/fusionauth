/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserActionJSON;

@JSON
public record UserAction(
    Boolean active,
    UUID cancelEmailTemplateId,
    UUID endEmailTemplateId,
    UUID id,
    Boolean includeEmailInEventJSON,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    LocalizedStrings localizedNames,
    UUID modifyEmailTemplateId,
    String name,
    List<UserActionOption> options,
    Boolean preventLogin,
    Boolean sendEndEvent,
    UUID startEmailTemplateId,
    Boolean temporal,
    TransactionType transactionType,
    Boolean userEmailingEnabled,
    Boolean userNotificationsEnabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserActionJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserActionJSON.toJSONBytes(this);
  }

  public static UserAction fromJSON(String json) {
    return UserActionJSON.fromJSON(json);
  }

  public static UserAction fromJSONBytes(byte[] json) {
    return UserActionJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean active;
    private UUID cancelEmailTemplateId;
    private UUID endEmailTemplateId;
    private UUID id;
    private Boolean includeEmailInEventJSON;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private LocalizedStrings localizedNames;
    private UUID modifyEmailTemplateId;
    private String name;
    private List<UserActionOption> options;
    private Boolean preventLogin;
    private Boolean sendEndEvent;
    private UUID startEmailTemplateId;
    private Boolean temporal;
    private TransactionType transactionType;
    private Boolean userEmailingEnabled;
    private Boolean userNotificationsEnabled;
    public Builder active(Boolean active) { this.active = active; return this; }
    public Builder cancelEmailTemplateId(UUID cancelEmailTemplateId) { this.cancelEmailTemplateId = cancelEmailTemplateId; return this; }
    public Builder endEmailTemplateId(UUID endEmailTemplateId) { this.endEmailTemplateId = endEmailTemplateId; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder includeEmailInEventJSON(Boolean includeEmailInEventJSON) { this.includeEmailInEventJSON = includeEmailInEventJSON; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder localizedNames(LocalizedStrings localizedNames) { this.localizedNames = localizedNames; return this; }
    public Builder modifyEmailTemplateId(UUID modifyEmailTemplateId) { this.modifyEmailTemplateId = modifyEmailTemplateId; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder options(List<UserActionOption> options) { this.options = options; return this; }
    public Builder preventLogin(Boolean preventLogin) { this.preventLogin = preventLogin; return this; }
    public Builder sendEndEvent(Boolean sendEndEvent) { this.sendEndEvent = sendEndEvent; return this; }
    public Builder startEmailTemplateId(UUID startEmailTemplateId) { this.startEmailTemplateId = startEmailTemplateId; return this; }
    public Builder temporal(Boolean temporal) { this.temporal = temporal; return this; }
    public Builder transactionType(TransactionType transactionType) { this.transactionType = transactionType; return this; }
    public Builder userEmailingEnabled(Boolean userEmailingEnabled) { this.userEmailingEnabled = userEmailingEnabled; return this; }
    public Builder userNotificationsEnabled(Boolean userNotificationsEnabled) { this.userNotificationsEnabled = userNotificationsEnabled; return this; }
    public UserAction build() { return new UserAction(active, cancelEmailTemplateId, endEmailTemplateId, id, includeEmailInEventJSON, insertInstant, lastUpdateInstant, localizedNames, modifyEmailTemplateId, name, options, preventLogin, sendEndEvent, startEmailTemplateId, temporal, transactionType, userEmailingEnabled, userNotificationsEnabled); }
  }
}
