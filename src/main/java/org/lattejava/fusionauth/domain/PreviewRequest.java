/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PreviewRequestJSON;

@JSON
public record PreviewRequest(
    EmailTemplate emailTemplate,
    String locale) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PreviewRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PreviewRequestJSON.toJSONBytes(this);
  }
  
  public static PreviewRequest fromJSON(String json) {
    return PreviewRequestJSON.fromJSON(json);
  }
  
  public static PreviewRequest fromJSONBytes(byte[] json) {
    return PreviewRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EmailTemplate emailTemplate;
    private String locale;
    public Builder emailTemplate(EmailTemplate emailTemplate) { this.emailTemplate = emailTemplate; return this; }
    public Builder locale(String locale) { this.locale = locale; return this; }
    public PreviewRequest build() { return new PreviewRequest(emailTemplate, locale); }
  }
}
