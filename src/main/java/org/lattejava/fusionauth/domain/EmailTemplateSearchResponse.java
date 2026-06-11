/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailTemplateSearchResponseJSON;

@JSON
public record EmailTemplateSearchResponse(
    List<EmailTemplate> emailTemplates,
    Long total) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailTemplateSearchResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EmailTemplateSearchResponseJSON.toJSONBytes(this);
  }

  public static EmailTemplateSearchResponse fromJSON(String json) {
    return EmailTemplateSearchResponseJSON.fromJSON(json);
  }

  public static EmailTemplateSearchResponse fromJSONBytes(byte[] json) {
    return EmailTemplateSearchResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<EmailTemplate> emailTemplates;
    private Long total;
    public Builder emailTemplates(List<EmailTemplate> emailTemplates) { this.emailTemplates = emailTemplates; return this; }
    public Builder total(Long total) { this.total = total; return this; }
    public EmailTemplateSearchResponse build() { return new EmailTemplateSearchResponse(emailTemplates, total); }
  }
}
