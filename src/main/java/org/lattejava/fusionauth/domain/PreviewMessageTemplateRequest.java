/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PreviewMessageTemplateRequestJSON;

@JSON
public record PreviewMessageTemplateRequest(
    String locale,
    MessageTemplate messageTemplate) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PreviewMessageTemplateRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PreviewMessageTemplateRequestJSON.toJSONBytes(this);
  }

  public static PreviewMessageTemplateRequest fromJSON(String json) {
    return PreviewMessageTemplateRequestJSON.fromJSON(json);
  }

  public static PreviewMessageTemplateRequest fromJSONBytes(byte[] json) {
    return PreviewMessageTemplateRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String locale;
    private MessageTemplate messageTemplate;
    public Builder locale(String locale) { this.locale = locale; return this; }
    public Builder messageTemplate(MessageTemplate messageTemplate) { this.messageTemplate = messageTemplate; return this; }
    public PreviewMessageTemplateRequest build() { return new PreviewMessageTemplateRequest(locale, messageTemplate); }
  }
}
