/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RegistrationRequestJSON;

@JSON
public record RegistrationRequest(
    Boolean disableDomainBlock,
    Boolean generateAuthenticationToken,
    UserRegistration registration,
    Boolean sendSetPasswordEmail,
    SendSetPasswordIdentityType sendSetPasswordIdentityType,
    Boolean skipRegistrationVerification,
    Boolean skipVerification,
    User user,
    List<String> verificationIds,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RegistrationRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RegistrationRequestJSON.toJSONBytes(this);
  }
  
  public static RegistrationRequest fromJSON(String json) {
    return RegistrationRequestJSON.fromJSON(json);
  }
  
  public static RegistrationRequest fromJSONBytes(byte[] json) {
    return RegistrationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean disableDomainBlock;
    private Boolean generateAuthenticationToken;
    private UserRegistration registration;
    private Boolean sendSetPasswordEmail;
    private SendSetPasswordIdentityType sendSetPasswordIdentityType;
    private Boolean skipRegistrationVerification;
    private Boolean skipVerification;
    private User user;
    private List<String> verificationIds;
    private EventInfo eventInfo;
    public Builder disableDomainBlock(Boolean disableDomainBlock) { this.disableDomainBlock = disableDomainBlock; return this; }
    public Builder generateAuthenticationToken(Boolean generateAuthenticationToken) { this.generateAuthenticationToken = generateAuthenticationToken; return this; }
    public Builder registration(UserRegistration registration) { this.registration = registration; return this; }
    public Builder sendSetPasswordEmail(Boolean sendSetPasswordEmail) { this.sendSetPasswordEmail = sendSetPasswordEmail; return this; }
    public Builder sendSetPasswordIdentityType(SendSetPasswordIdentityType sendSetPasswordIdentityType) { this.sendSetPasswordIdentityType = sendSetPasswordIdentityType; return this; }
    public Builder skipRegistrationVerification(Boolean skipRegistrationVerification) { this.skipRegistrationVerification = skipRegistrationVerification; return this; }
    public Builder skipVerification(Boolean skipVerification) { this.skipVerification = skipVerification; return this; }
    public Builder user(User user) { this.user = user; return this; }
    public Builder verificationIds(List<String> verificationIds) { this.verificationIds = verificationIds; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public RegistrationRequest build() { return new RegistrationRequest(disableDomainBlock, generateAuthenticationToken, registration, sendSetPasswordEmail, sendSetPasswordIdentityType, skipRegistrationVerification, skipVerification, user, verificationIds, eventInfo); }
  }
}
