/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MessengerRequestJSON;

@JSON
public record MessengerRequest(
    BaseMessengerConfiguration messenger) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MessengerRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MessengerRequestJSON.toJSONBytes(this);
  }
  
  public static MessengerRequest fromJSON(String json) {
    return MessengerRequestJSON.fromJSON(json);
  }
  
  public static MessengerRequest fromJSONBytes(byte[] json) {
    return MessengerRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private BaseMessengerConfiguration messenger;
    public Builder messenger(BaseMessengerConfiguration messenger) { this.messenger = messenger; return this; }
    public MessengerRequest build() { return new MessengerRequest(messenger); }
  }
}
