/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MessageTemplateRequestJSON;

@JSON
public record MessageTemplateRequest(
    MessageTemplate messageTemplate) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MessageTemplateRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MessageTemplateRequestJSON.toJSONBytes(this);
  }
  
  public static MessageTemplateRequest fromJSON(String json) {
    return MessageTemplateRequestJSON.fromJSON(json);
  }
  
  public static MessageTemplateRequest fromJSONBytes(byte[] json) {
    return MessageTemplateRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private MessageTemplate messageTemplate;
    public Builder messageTemplate(MessageTemplate messageTemplate) { this.messageTemplate = messageTemplate; return this; }
    public MessageTemplateRequest build() { return new MessageTemplateRequest(messageTemplate); }
  }
}
