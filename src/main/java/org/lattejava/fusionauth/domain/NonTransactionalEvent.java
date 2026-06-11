/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.NonTransactionalEventJSON;

@JSON
public record NonTransactionalEvent() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return NonTransactionalEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return NonTransactionalEventJSON.toJSONBytes(this);
  }

  public static NonTransactionalEvent fromJSON(String json) {
    return NonTransactionalEventJSON.fromJSON(json);
  }

  public static NonTransactionalEvent fromJSONBytes(byte[] json) {
    return NonTransactionalEventJSON.fromJSON(json);
  }

  public static final class Builder {
    public NonTransactionalEvent build() { return new NonTransactionalEvent(); }
  }
}
