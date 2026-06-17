/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MessengerTransportJSON;

@JSON
public record MessengerTransport() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MessengerTransportJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MessengerTransportJSON.toJSONBytes(this);
  }
  
  public static MessengerTransport fromJSON(String json) {
    return MessengerTransportJSON.fromJSON(json);
  }
  
  public static MessengerTransport fromJSONBytes(byte[] json) {
    return MessengerTransportJSON.fromJSON(json);
  }

  public static final class Builder {
    public MessengerTransport build() { return new MessengerTransport(); }
  }
}
