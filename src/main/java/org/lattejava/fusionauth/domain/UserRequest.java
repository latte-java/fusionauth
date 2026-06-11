/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserRequestJSON;

@JSON
public record UserRequest(
    UUID applicationId,
    String currentPassword,
    Boolean disableDomainBlock,
    Boolean sendSetPasswordEmail,
    SendSetPasswordIdentityType sendSetPasswordIdentityType,
    Boolean skipVerification,
    User user,
    List<String> verificationIds,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserRequestJSON.toJSONBytes(this);
  }

  public static UserRequest fromJSON(String json) {
    return UserRequestJSON.fromJSON(json);
  }

  public static UserRequest fromJSONBytes(byte[] json) {
    return UserRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String currentPassword;
    private Boolean disableDomainBlock;
    private Boolean sendSetPasswordEmail;
    private SendSetPasswordIdentityType sendSetPasswordIdentityType;
    private Boolean skipVerification;
    private User user;
    private List<String> verificationIds;
    private EventInfo eventInfo;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder currentPassword(String currentPassword) { this.currentPassword = currentPassword; return this; }
    public Builder disableDomainBlock(Boolean disableDomainBlock) { this.disableDomainBlock = disableDomainBlock; return this; }
    public Builder sendSetPasswordEmail(Boolean sendSetPasswordEmail) { this.sendSetPasswordEmail = sendSetPasswordEmail; return this; }
    public Builder sendSetPasswordIdentityType(SendSetPasswordIdentityType sendSetPasswordIdentityType) { this.sendSetPasswordIdentityType = sendSetPasswordIdentityType; return this; }
    public Builder skipVerification(Boolean skipVerification) { this.skipVerification = skipVerification; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public Builder verificationIds(List<String> verificationIds) { this.verificationIds = verificationIds; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public UserRequest build() { return new UserRequest(applicationId, currentPassword, disableDomainBlock, sendSetPasswordEmail, sendSetPasswordIdentityType, skipVerification, user, verificationIds, eventInfo); }
  }
}
