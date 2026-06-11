/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserDeleteSingleRequestJSON;

@JSON
public record UserDeleteSingleRequest(
    Boolean hardDelete,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserDeleteSingleRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserDeleteSingleRequestJSON.toJSONBytes(this);
  }

  public static UserDeleteSingleRequest fromJSON(String json) {
    return UserDeleteSingleRequestJSON.fromJSON(json);
  }

  public static UserDeleteSingleRequest fromJSONBytes(byte[] json) {
    return UserDeleteSingleRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean hardDelete;
    private EventInfo eventInfo;
    public Builder hardDelete(Boolean hardDelete) { this.hardDelete = hardDelete; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public UserDeleteSingleRequest build() { return new UserDeleteSingleRequest(hardDelete, eventInfo); }
  }
}
