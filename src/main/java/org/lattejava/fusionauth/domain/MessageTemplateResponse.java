/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MessageTemplateResponseJSON;

@JSON
public record MessageTemplateResponse(
    MessageTemplate messageTemplate,
    List<MessageTemplate> messageTemplates) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MessageTemplateResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MessageTemplateResponseJSON.toJSONBytes(this);
  }
  
  public static MessageTemplateResponse fromJSON(String json) {
    return MessageTemplateResponseJSON.fromJSON(json);
  }
  
  public static MessageTemplateResponse fromJSONBytes(byte[] json) {
    return MessageTemplateResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private MessageTemplate messageTemplate;
    private List<MessageTemplate> messageTemplates;
    public Builder messageTemplate(MessageTemplate messageTemplate) { this.messageTemplate = messageTemplate; return this; }
    public Builder messageTemplates(List<MessageTemplate> messageTemplates) { this.messageTemplates = messageTemplates; return this; }
    public MessageTemplateResponse build() { return new MessageTemplateResponse(messageTemplate, messageTemplates); }
  }
}
