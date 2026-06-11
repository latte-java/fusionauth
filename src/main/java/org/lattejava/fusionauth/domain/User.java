/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserJSON;

@JSON
public record User(
    List<String> preferredLanguages,
    Boolean active,
    LocalDate birthDate,
    UUID cleanSpeakId,
    Map<String, Object> data,
    String email,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expiry,
    String firstName,
    String fullName,
    String imageUrl,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    String lastName,
    String legacyIdentifier,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String middleName,
    String mobilePhone,
    String parentEmail,
    String phoneNumber,
    UUID tenantId,
    String timezone,
    UserTwoFactorConfiguration twoFactor,
    List<GroupMember> memberships,
    List<UserRegistration> registrations,
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
    return UserJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserJSON.toJSONBytes(this);
  }

  public static User fromJSON(String json) {
    return UserJSON.fromJSON(json);
  }

  public static User fromJSONBytes(byte[] json) {
    return UserJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<String> preferredLanguages;
    private Boolean active;
    private LocalDate birthDate;
    private UUID cleanSpeakId;
    private Map<String, Object> data;
    private String email;
    private Instant expiry;
    private String firstName;
    private String fullName;
    private String imageUrl;
    private Instant insertInstant;
    private String lastName;
    private String legacyIdentifier;
    private Instant lastUpdateInstant;
    private String middleName;
    private String mobilePhone;
    private String parentEmail;
    private String phoneNumber;
    private UUID tenantId;
    private String timezone;
    private UserTwoFactorConfiguration twoFactor;
    private List<GroupMember> memberships;
    private List<UserRegistration> registrations;
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
    public Builder preferredLanguages(List<String> preferredLanguages) { this.preferredLanguages = preferredLanguages; return this; }
    public Builder active(Boolean active) { this.active = active; return this; }
    public Builder birthDate(LocalDate birthDate) { this.birthDate = birthDate; return this; }
    public Builder cleanSpeakId(UUID cleanSpeakId) { this.cleanSpeakId = cleanSpeakId; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder email(String email) { this.email = email; return this; }
    public Builder expiry(Instant expiry) { this.expiry = expiry; return this; }
    public Builder firstName(String firstName) { this.firstName = firstName; return this; }
    public Builder fullName(String fullName) { this.fullName = fullName; return this; }
    public Builder imageUrl(String imageUrl) { this.imageUrl = imageUrl; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastName(String lastName) { this.lastName = lastName; return this; }
    public Builder legacyIdentifier(String legacyIdentifier) { this.legacyIdentifier = legacyIdentifier; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder middleName(String middleName) { this.middleName = middleName; return this; }
    public Builder mobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; return this; }
    public Builder parentEmail(String parentEmail) { this.parentEmail = parentEmail; return this; }
    public Builder phoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder timezone(String timezone) { this.timezone = timezone; return this; }
    public Builder twoFactor(UserTwoFactorConfiguration twoFactor) { this.twoFactor = twoFactor; return this; }
    public Builder memberships(List<GroupMember> memberships) { this.memberships = memberships; return this; }
    public Builder registrations(List<UserRegistration> registrations) { this.registrations = registrations; return this; }
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
    public User build() { return new User(preferredLanguages, active, birthDate, cleanSpeakId, data, email, expiry, firstName, fullName, imageUrl, insertInstant, lastName, legacyIdentifier, lastUpdateInstant, middleName, mobilePhone, parentEmail, phoneNumber, tenantId, timezone, twoFactor, memberships, registrations, identities, breachedPasswordLastCheckedInstant, breachedPasswordStatus, connectorId, encryptionScheme, factor, id, lastLoginInstant, password, passwordChangeReason, passwordChangeRequired, passwordLastUpdateInstant, salt, uniqueUsername, username, usernameStatus, verified, verifiedInstant); }
  }
}
