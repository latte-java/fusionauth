/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailTemplateSearchRequestJSON;

@JSON
public record EmailTemplateSearchRequest(
    EmailTemplateSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailTemplateSearchRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EmailTemplateSearchRequestJSON.toJSONBytes(this);
  }
  
  public static EmailTemplateSearchRequest fromJSON(String json) {
    return EmailTemplateSearchRequestJSON.fromJSON(json);
  }
  
  public static EmailTemplateSearchRequest fromJSONBytes(byte[] json) {
    return EmailTemplateSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EmailTemplateSearchCriteria search;
    public Builder search(EmailTemplateSearchCriteria search) { this.search = search; return this; }
    public EmailTemplateSearchRequest build() { return new EmailTemplateSearchRequest(search); }
  }
}
