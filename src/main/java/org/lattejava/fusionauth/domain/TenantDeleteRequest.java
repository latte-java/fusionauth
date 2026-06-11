/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantDeleteRequestJSON;

@JSON
public record TenantDeleteRequest(
    Boolean async,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantDeleteRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantDeleteRequestJSON.toJSONBytes(this);
  }

  public static TenantDeleteRequest fromJSON(String json) {
    return TenantDeleteRequestJSON.fromJSON(json);
  }

  public static TenantDeleteRequest fromJSONBytes(byte[] json) {
    return TenantDeleteRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean async;
    private EventInfo eventInfo;
    public Builder async(Boolean async) { this.async = async; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public TenantDeleteRequest build() { return new TenantDeleteRequest(async, eventInfo); }
  }
}
