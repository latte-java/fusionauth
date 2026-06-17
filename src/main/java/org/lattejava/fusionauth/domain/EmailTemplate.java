/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailTemplateJSON;

@JSON
public record EmailTemplate(
    String defaultFromName,
    String defaultHtmlTemplate,
    String defaultSubject,
    String defaultTextTemplate,
    String fromEmail,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    LocalizedStrings localizedFromNames,
    LocalizedStrings localizedHtmlTemplates,
    LocalizedStrings localizedSubjects,
    LocalizedStrings localizedTextTemplates,
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailTemplateJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EmailTemplateJSON.toJSONBytes(this);
  }
  
  public static EmailTemplate fromJSON(String json) {
    return EmailTemplateJSON.fromJSON(json);
  }
  
  public static EmailTemplate fromJSONBytes(byte[] json) {
    return EmailTemplateJSON.fromJSON(json);
  }

  public static final class Builder {
    private String defaultFromName;
    private String defaultHtmlTemplate;
    private String defaultSubject;
    private String defaultTextTemplate;
    private String fromEmail;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private LocalizedStrings localizedFromNames;
    private LocalizedStrings localizedHtmlTemplates;
    private LocalizedStrings localizedSubjects;
    private LocalizedStrings localizedTextTemplates;
    private String name;
    public Builder defaultFromName(String defaultFromName) { this.defaultFromName = defaultFromName; return this; }
    public Builder defaultHtmlTemplate(String defaultHtmlTemplate) { this.defaultHtmlTemplate = defaultHtmlTemplate; return this; }
    public Builder defaultSubject(String defaultSubject) { this.defaultSubject = defaultSubject; return this; }
    public Builder defaultTextTemplate(String defaultTextTemplate) { this.defaultTextTemplate = defaultTextTemplate; return this; }
    public Builder fromEmail(String fromEmail) { this.fromEmail = fromEmail; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder localizedFromNames(LocalizedStrings localizedFromNames) { this.localizedFromNames = localizedFromNames; return this; }
    public Builder localizedHtmlTemplates(LocalizedStrings localizedHtmlTemplates) { this.localizedHtmlTemplates = localizedHtmlTemplates; return this; }
    public Builder localizedSubjects(LocalizedStrings localizedSubjects) { this.localizedSubjects = localizedSubjects; return this; }
    public Builder localizedTextTemplates(LocalizedStrings localizedTextTemplates) { this.localizedTextTemplates = localizedTextTemplates; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public EmailTemplate build() { return new EmailTemplate(defaultFromName, defaultHtmlTemplate, defaultSubject, defaultTextTemplate, fromEmail, id, insertInstant, lastUpdateInstant, localizedFromNames, localizedHtmlTemplates, localizedSubjects, localizedTextTemplates, name); }
  }
}
