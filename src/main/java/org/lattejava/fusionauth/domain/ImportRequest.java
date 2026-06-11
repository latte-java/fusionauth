/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ImportRequestJSON;

@JSON
public record ImportRequest(
    String encryptionScheme,
    Integer factor,
    List<User> users,
    Boolean validateDbConstraints,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ImportRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ImportRequestJSON.toJSONBytes(this);
  }

  public static ImportRequest fromJSON(String json) {
    return ImportRequestJSON.fromJSON(json);
  }

  public static ImportRequest fromJSONBytes(byte[] json) {
    return ImportRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String encryptionScheme;
    private Integer factor;
    private List<User> users;
    private Boolean validateDbConstraints;
    private EventInfo eventInfo;
    public Builder encryptionScheme(String encryptionScheme) { this.encryptionScheme = encryptionScheme; return this; }
    public Builder factor(Integer factor) { this.factor = factor; return this; }
    public Builder users(List<User> users) { this.users = users; return this; }
    public Builder validateDbConstraints(Boolean validateDbConstraints) { this.validateDbConstraints = validateDbConstraints; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public ImportRequest build() { return new ImportRequest(encryptionScheme, factor, users, validateDbConstraints, eventInfo); }
  }
}
