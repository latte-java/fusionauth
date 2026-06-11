/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailTemplateErrorsJSON;

@JSON
public record EmailTemplateErrors(
    Map<String, String> parseErrors,
    Map<String, String> renderErrors) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailTemplateErrorsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EmailTemplateErrorsJSON.toJSONBytes(this);
  }

  public static EmailTemplateErrors fromJSON(String json) {
    return EmailTemplateErrorsJSON.fromJSON(json);
  }

  public static EmailTemplateErrors fromJSONBytes(byte[] json) {
    return EmailTemplateErrorsJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, String> parseErrors;
    private Map<String, String> renderErrors;
    public Builder parseErrors(Map<String, String> parseErrors) { this.parseErrors = parseErrors; return this; }
    public Builder renderErrors(Map<String, String> renderErrors) { this.renderErrors = renderErrors; return this; }
    public EmailTemplateErrors build() { return new EmailTemplateErrors(parseErrors, renderErrors); }
  }
}
