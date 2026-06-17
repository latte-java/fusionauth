/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RegistrationDeleteRequestJSON;

@JSON
public record RegistrationDeleteRequest(
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RegistrationDeleteRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RegistrationDeleteRequestJSON.toJSONBytes(this);
  }
  
  public static RegistrationDeleteRequest fromJSON(String json) {
    return RegistrationDeleteRequestJSON.fromJSON(json);
  }
  
  public static RegistrationDeleteRequest fromJSONBytes(byte[] json) {
    return RegistrationDeleteRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private EventInfo eventInfo;
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public RegistrationDeleteRequest build() { return new RegistrationDeleteRequest(eventInfo); }
  }
}
