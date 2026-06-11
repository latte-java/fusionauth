/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MessengerResponseJSON;

@JSON
public record MessengerResponse(
    BaseMessengerConfiguration messenger,
    List<BaseMessengerConfiguration> messengers) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MessengerResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return MessengerResponseJSON.toJSONBytes(this);
  }

  public static MessengerResponse fromJSON(String json) {
    return MessengerResponseJSON.fromJSON(json);
  }

  public static MessengerResponse fromJSONBytes(byte[] json) {
    return MessengerResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private BaseMessengerConfiguration messenger;
    private List<BaseMessengerConfiguration> messengers;
    public Builder messenger(BaseMessengerConfiguration messenger) { this.messenger = messenger; return this; }
    public Builder messengers(List<BaseMessengerConfiguration> messengers) { this.messengers = messengers; return this; }
    public MessengerResponse build() { return new MessengerResponse(messenger, messengers); }
  }
}
