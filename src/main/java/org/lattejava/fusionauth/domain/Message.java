/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MessageJSON;

@JSON
public record Message() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MessageJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MessageJSON.toJSONBytes(this);
  }
  
  public static Message fromJSON(String json) {
    return MessageJSON.fromJSON(json);
  }
  
  public static Message fromJSONBytes(byte[] json) {
    return MessageJSON.fromJSON(json);
  }

  public static final class Builder {
    public Message build() { return new Message(); }
  }
}
