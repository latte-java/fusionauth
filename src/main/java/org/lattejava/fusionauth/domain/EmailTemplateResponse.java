/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailTemplateResponseJSON;

@JSON
public record EmailTemplateResponse(
    EmailTemplate emailTemplate,
    List<EmailTemplate> emailTemplates) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailTemplateResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EmailTemplateResponseJSON.toJSONBytes(this);
  }
  
  public static EmailTemplateResponse fromJSON(String json) {
    return EmailTemplateResponseJSON.fromJSON(json);
  }
  
  public static EmailTemplateResponse fromJSONBytes(byte[] json) {
    return EmailTemplateResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private EmailTemplate emailTemplate;
    private List<EmailTemplate> emailTemplates;
    public Builder emailTemplate(EmailTemplate emailTemplate) { this.emailTemplate = emailTemplate; return this; }
    public Builder emailTemplates(List<EmailTemplate> emailTemplates) { this.emailTemplates = emailTemplates; return this; }
    public EmailTemplateResponse build() { return new EmailTemplateResponse(emailTemplate, emailTemplates); }
  }
}
