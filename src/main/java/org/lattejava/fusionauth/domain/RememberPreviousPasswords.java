/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RememberPreviousPasswordsJSON;

@JSON
public record RememberPreviousPasswords(
    Integer count,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RememberPreviousPasswordsJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return RememberPreviousPasswordsJSON.toJSONBytes(this);
  }

  public static RememberPreviousPasswords fromJSON(String json) {
    return RememberPreviousPasswordsJSON.fromJSON(json);
  }

  public static RememberPreviousPasswords fromJSONBytes(byte[] json) {
    return RememberPreviousPasswordsJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer count;
    private Boolean enabled;
    public Builder count(Integer count) { this.count = count; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public RememberPreviousPasswords build() { return new RememberPreviousPasswords(count, enabled); }
  }
}
