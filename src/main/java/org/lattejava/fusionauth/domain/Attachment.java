/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AttachmentJSON;

@JSON
public record Attachment(
    String attachment,
    String mime,
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AttachmentJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return AttachmentJSON.toJSONBytes(this);
  }
  
  public static Attachment fromJSON(String json) {
    return AttachmentJSON.fromJSON(json);
  }
  
  public static Attachment fromJSONBytes(byte[] json) {
    return AttachmentJSON.fromJSON(json);
  }

  public static final class Builder {
    private String attachment;
    private String mime;
    private String name;
    public Builder attachment(String attachment) { this.attachment = attachment; return this; }
    public Builder mime(String mime) { this.mime = mime; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Attachment build() { return new Attachment(attachment, mime, name); }
  }
}
