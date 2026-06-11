/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailTemplateRequestJSON;

@JSON
public record EmailTemplateRequest(
    EmailTemplate emailTemplate) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailTemplateRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EmailTemplateRequestJSON.toJSONBytes(this);
  }

  public static EmailTemplateRequest fromJSON(String json) {
    return EmailTemplateRequestJSON.fromJSON(json);
  }

  public static EmailTemplateRequest fromJSONBytes(byte[] json) {
    return EmailTemplateRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EmailTemplate emailTemplate;
    public Builder emailTemplate(EmailTemplate emailTemplate) { this.emailTemplate = emailTemplate; return this; }
    public EmailTemplateRequest build() { return new EmailTemplateRequest(emailTemplate); }
  }
}
