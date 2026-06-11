/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SecureIdentityJSON;

@JSON
public record SecureIdentity(
    List<UserIdentity> identities,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant breachedPasswordLastCheckedInstant,
    BreachedPasswordStatus breachedPasswordStatus,
    UUID connectorId,
    String encryptionScheme,
    Integer factor,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastLoginInstant,
    String password,
    ChangePasswordReason passwordChangeReason,
    Boolean passwordChangeRequired,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant passwordLastUpdateInstant,
    String salt,
    String uniqueUsername,
    String username,
    ContentStatus usernameStatus,
    Boolean verified,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant verifiedInstant) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SecureIdentityJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SecureIdentityJSON.toJSONBytes(this);
  }

  public static SecureIdentity fromJSON(String json) {
    return SecureIdentityJSON.fromJSON(json);
  }

  public static SecureIdentity fromJSONBytes(byte[] json) {
    return SecureIdentityJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<UserIdentity> identities;
    private Instant breachedPasswordLastCheckedInstant;
    private BreachedPasswordStatus breachedPasswordStatus;
    private UUID connectorId;
    private String encryptionScheme;
    private Integer factor;
    private UUID id;
    private Instant lastLoginInstant;
    private String password;
    private ChangePasswordReason passwordChangeReason;
    private Boolean passwordChangeRequired;
    private Instant passwordLastUpdateInstant;
    private String salt;
    private String uniqueUsername;
    private String username;
    private ContentStatus usernameStatus;
    private Boolean verified;
    private Instant verifiedInstant;
    public Builder identities(List<UserIdentity> identities) { this.identities = identities; return this; }
    public Builder breachedPasswordLastCheckedInstant(Instant breachedPasswordLastCheckedInstant) { this.breachedPasswordLastCheckedInstant = breachedPasswordLastCheckedInstant; return this; }
    public Builder breachedPasswordStatus(BreachedPasswordStatus breachedPasswordStatus) { this.breachedPasswordStatus = breachedPasswordStatus; return this; }
    public Builder connectorId(UUID connectorId) { this.connectorId = connectorId; return this; }
    public Builder encryptionScheme(String encryptionScheme) { this.encryptionScheme = encryptionScheme; return this; }
    public Builder factor(Integer factor) { this.factor = factor; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder lastLoginInstant(Instant lastLoginInstant) { this.lastLoginInstant = lastLoginInstant; return this; }
    public Builder password(String password) { this.password = password; return this; }
    public Builder passwordChangeReason(ChangePasswordReason passwordChangeReason) { this.passwordChangeReason = passwordChangeReason; return this; }
    public Builder passwordChangeRequired(Boolean passwordChangeRequired) { this.passwordChangeRequired = passwordChangeRequired; return this; }
    public Builder passwordLastUpdateInstant(Instant passwordLastUpdateInstant) { this.passwordLastUpdateInstant = passwordLastUpdateInstant; return this; }
    public Builder salt(String salt) { this.salt = salt; return this; }
    public Builder uniqueUsername(String uniqueUsername) { this.uniqueUsername = uniqueUsername; return this; }
    public Builder username(String username) { this.username = username; return this; }
    public Builder usernameStatus(ContentStatus usernameStatus) { this.usernameStatus = usernameStatus; return this; }
    public Builder verified(Boolean verified) { this.verified = verified; return this; }
    public Builder verifiedInstant(Instant verifiedInstant) { this.verifiedInstant = verifiedInstant; return this; }
    public SecureIdentity build() { return new SecureIdentity(identities, breachedPasswordLastCheckedInstant, breachedPasswordStatus, connectorId, encryptionScheme, factor, id, lastLoginInstant, password, passwordChangeReason, passwordChangeRequired, passwordLastUpdateInstant, salt, uniqueUsername, username, usernameStatus, verified, verifiedInstant); }
  }
}
