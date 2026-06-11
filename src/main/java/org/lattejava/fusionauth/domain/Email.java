/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailJSON;

@JSON
public record Email(
    List<Attachment> attachments,
    List<EmailAddress> bcc,
    List<EmailAddress> cc,
    EmailAddress from,
    String html,
    EmailAddress replyTo,
    String subject,
    String text,
    List<EmailAddress> to) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EmailJSON.toJSONBytes(this);
  }

  public static Email fromJSON(String json) {
    return EmailJSON.fromJSON(json);
  }

  public static Email fromJSONBytes(byte[] json) {
    return EmailJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<Attachment> attachments;
    private List<EmailAddress> bcc;
    private List<EmailAddress> cc;
    private EmailAddress from;
    private String html;
    private EmailAddress replyTo;
    private String subject;
    private String text;
    private List<EmailAddress> to;
    public Builder attachments(List<Attachment> attachments) { this.attachments = attachments; return this; }
    public Builder bcc(List<EmailAddress> bcc) { this.bcc = bcc; return this; }
    public Builder cc(List<EmailAddress> cc) { this.cc = cc; return this; }
    public Builder from(EmailAddress from) { this.from = from; return this; }
    public Builder html(String html) { this.html = html; return this; }
    public Builder replyTo(EmailAddress replyTo) { this.replyTo = replyTo; return this; }
    public Builder subject(String subject) { this.subject = subject; return this; }
    public Builder text(String text) { this.text = text; return this; }
    public Builder to(List<EmailAddress> to) { this.to = to; return this; }
    public Email build() { return new Email(attachments, bcc, cc, from, html, replyTo, subject, text, to); }
  }
}
