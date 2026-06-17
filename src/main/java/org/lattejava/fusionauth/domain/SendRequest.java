/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SendRequestJSON;

@JSON
public record SendRequest(
    UUID applicationId,
    List<String> bccAddresses,
    List<String> ccAddresses,
    List<String> preferredLanguages,
    Map<String, Object> requestData,
    List<EmailAddress> toAddresses,
    List<UUID> userIds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SendRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SendRequestJSON.toJSONBytes(this);
  }
  
  public static SendRequest fromJSON(String json) {
    return SendRequestJSON.fromJSON(json);
  }
  
  public static SendRequest fromJSONBytes(byte[] json) {
    return SendRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private List<String> bccAddresses;
    private List<String> ccAddresses;
    private List<String> preferredLanguages;
    private Map<String, Object> requestData;
    private List<EmailAddress> toAddresses;
    private List<UUID> userIds;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder bccAddresses(List<String> bccAddresses) { this.bccAddresses = bccAddresses; return this; }
    public Builder ccAddresses(List<String> ccAddresses) { this.ccAddresses = ccAddresses; return this; }
    public Builder preferredLanguages(List<String> preferredLanguages) { this.preferredLanguages = preferredLanguages; return this; }
    public Builder requestData(Map<String, Object> requestData) { this.requestData = requestData; return this; }
    public Builder toAddresses(List<EmailAddress> toAddresses) { this.toAddresses = toAddresses; return this; }
    public Builder userIds(List<UUID> userIds) { this.userIds = userIds; return this; }
    public SendRequest build() { return new SendRequest(applicationId, bccAddresses, ccAddresses, preferredLanguages, requestData, toAddresses, userIds); }
  }
}
