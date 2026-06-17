/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MessageTemplateJSON;

@JSON
public record MessageTemplate(
    Map<String, Object> data,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    MessageType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MessageTemplateJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MessageTemplateJSON.toJSONBytes(this);
  }
  
  public static MessageTemplate fromJSON(String json) {
    return MessageTemplateJSON.fromJSON(json);
  }
  
  public static MessageTemplate fromJSONBytes(byte[] json) {
    return MessageTemplateJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    private MessageType type;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(MessageType type) { this.type = type; return this; }
    public MessageTemplate build() { return new MessageTemplate(data, id, insertInstant, lastUpdateInstant, name, type); }
  }
}
