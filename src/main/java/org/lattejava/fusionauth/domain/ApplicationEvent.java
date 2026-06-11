/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationEventJSON;

@JSON
public record ApplicationEvent() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationEventJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationEventJSON.toJSONBytes(this);
  }

  public static ApplicationEvent fromJSON(String json) {
    return ApplicationEventJSON.fromJSON(json);
  }

  public static ApplicationEvent fromJSONBytes(byte[] json) {
    return ApplicationEventJSON.fromJSON(json);
  }

  public static final class Builder {
    public ApplicationEvent build() { return new ApplicationEvent(); }
  }
}
