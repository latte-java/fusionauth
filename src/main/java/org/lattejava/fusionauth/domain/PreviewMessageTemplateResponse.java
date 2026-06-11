/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PreviewMessageTemplateResponseJSON;

@JSON
public record PreviewMessageTemplateResponse(
    Errors errors,
    SMSMessage message,
    String previewMessage) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PreviewMessageTemplateResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return PreviewMessageTemplateResponseJSON.toJSONBytes(this);
  }

  public static PreviewMessageTemplateResponse fromJSON(String json) {
    return PreviewMessageTemplateResponseJSON.fromJSON(json);
  }

  public static PreviewMessageTemplateResponse fromJSONBytes(byte[] json) {
    return PreviewMessageTemplateResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Errors errors;
    private SMSMessage message;
    private String previewMessage;
    public Builder errors(Errors errors) { this.errors = errors; return this; }
    public Builder message(SMSMessage message) { this.message = message; return this; }
    public Builder previewMessage(String previewMessage) { this.previewMessage = previewMessage; return this; }
    public PreviewMessageTemplateResponse build() { return new PreviewMessageTemplateResponse(errors, message, previewMessage); }
  }
}
