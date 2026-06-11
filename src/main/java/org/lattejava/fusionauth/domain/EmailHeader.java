/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailHeaderJSON;

@JSON
public record EmailHeader(
    String name,
    String value) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailHeaderJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EmailHeaderJSON.toJSONBytes(this);
  }

  public static EmailHeader fromJSON(String json) {
    return EmailHeaderJSON.fromJSON(json);
  }

  public static EmailHeader fromJSONBytes(byte[] json) {
    return EmailHeaderJSON.fromJSON(json);
  }

  public static final class Builder {
    private String name;
    private String value;
    public Builder name(String name) { this.name = name; return this; }
    public Builder value(String value) { this.value = value; return this; }
    public EmailHeader build() { return new EmailHeader(name, value); }
  }
}
