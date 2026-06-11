/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRegistrationJSON;

@JSON
public record UserRegistration(
    Map<String, Object> data,
    List<String> preferredLanguages,
    Map<String, String> tokens,
    UUID applicationId,
    String authenticationToken,
    UUID cleanSpeakId,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastLoginInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Set<String> roles,
    String timezone,
    String username,
    ContentStatus usernameStatus,
    Boolean verified,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant verifiedInstant) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRegistrationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRegistrationJSON.toJSONBytes(this);
  }

  public static UserRegistration fromJSON(String json) {
    return UserRegistrationJSON.fromJSON(json);
  }

  public static UserRegistration fromJSONBytes(byte[] json) {
    return UserRegistrationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private List<String> preferredLanguages;
    private Map<String, String> tokens;
    private UUID applicationId;
    private String authenticationToken;
    private UUID cleanSpeakId;
    private UUID id;
    private Instant insertInstant;
    private Instant lastLoginInstant;
    private Instant lastUpdateInstant;
    private Set<String> roles;
    private String timezone;
    private String username;
    private ContentStatus usernameStatus;
    private Boolean verified;
    private Instant verifiedInstant;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder preferredLanguages(List<String> preferredLanguages) { this.preferredLanguages = preferredLanguages; return this; }
    public Builder tokens(Map<String, String> tokens) { this.tokens = tokens; return this; }
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder authenticationToken(String authenticationToken) { this.authenticationToken = authenticationToken; return this; }
    public Builder cleanSpeakId(UUID cleanSpeakId) { this.cleanSpeakId = cleanSpeakId; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastLoginInstant(Instant lastLoginInstant) { this.lastLoginInstant = lastLoginInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder roles(Set<String> roles) { this.roles = roles; return this; }
    public Builder timezone(String timezone) { this.timezone = timezone; return this; }
    public Builder username(String username) { this.username = username; return this; }
    public Builder usernameStatus(ContentStatus usernameStatus) { this.usernameStatus = usernameStatus; return this; }
    public Builder verified(Boolean verified) { this.verified = verified; return this; }
    public Builder verifiedInstant(Instant verifiedInstant) { this.verifiedInstant = verifiedInstant; return this; }
    public UserRegistration build() { return new UserRegistration(data, preferredLanguages, tokens, applicationId, authenticationToken, cleanSpeakId, id, insertInstant, lastLoginInstant, lastUpdateInstant, roles, timezone, username, usernameStatus, verified, verifiedInstant); }
  }
}
