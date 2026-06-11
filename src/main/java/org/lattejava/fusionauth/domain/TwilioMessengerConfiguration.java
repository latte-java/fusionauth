/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwilioMessengerConfigurationJSON;

@JSON
public record TwilioMessengerConfiguration(
    String accountSID,
    String authToken,
    String fromPhoneNumber,
    String messagingServiceSid,
    String url,
    Map<String, Object> data,
    Boolean debug,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Set<String> messageTypes,
    String name,
    String transport,
    MessengerType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwilioMessengerConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TwilioMessengerConfigurationJSON.toJSONBytes(this);
  }

  public static TwilioMessengerConfiguration fromJSON(String json) {
    return TwilioMessengerConfigurationJSON.fromJSON(json);
  }

  public static TwilioMessengerConfiguration fromJSONBytes(byte[] json) {
    return TwilioMessengerConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String accountSID;
    private String authToken;
    private String fromPhoneNumber;
    private String messagingServiceSid;
    private String url;
    private Map<String, Object> data;
    private Boolean debug;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private Set<String> messageTypes;
    private String name;
    private String transport;
    private MessengerType type;
    public Builder accountSID(String accountSID) { this.accountSID = accountSID; return this; }
    public Builder authToken(String authToken) { this.authToken = authToken; return this; }
    public Builder fromPhoneNumber(String fromPhoneNumber) { this.fromPhoneNumber = fromPhoneNumber; return this; }
    public Builder messagingServiceSid(String messagingServiceSid) { this.messagingServiceSid = messagingServiceSid; return this; }
    public Builder url(String url) { this.url = url; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder messageTypes(Set<String> messageTypes) { this.messageTypes = messageTypes; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder transport(String transport) { this.transport = transport; return this; }
    public Builder type(MessengerType type) { this.type = type; return this; }
    public TwilioMessengerConfiguration build() { return new TwilioMessengerConfiguration(accountSID, authToken, fromPhoneNumber, messagingServiceSid, url, data, debug, id, insertInstant, lastUpdateInstant, messageTypes, name, transport, type); }
  }
}
