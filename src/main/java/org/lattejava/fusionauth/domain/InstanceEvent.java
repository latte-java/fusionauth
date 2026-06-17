/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.InstanceEventJSON;

@JSON
public record InstanceEvent() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return InstanceEventJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return InstanceEventJSON.toJSONBytes(this);
  }
  
  public static InstanceEvent fromJSON(String json) {
    return InstanceEventJSON.fromJSON(json);
  }
  
  public static InstanceEvent fromJSONBytes(byte[] json) {
    return InstanceEventJSON.fromJSON(json);
  }

  public static final class Builder {
    public InstanceEvent build() { return new InstanceEvent(); }
  }
}
